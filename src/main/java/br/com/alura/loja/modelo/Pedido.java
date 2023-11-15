package br.com.alura.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//For�a jpa colocar separador underline.
	@Column(name = "valor_total")
	private BigDecimal valorTotal = BigDecimal.ZERO;
	private LocalDate data = LocalDate.now();

	//Objetos carregados automaticamente.
	//Todo o relacionamento toOne tem por padr�o,
	//o carregamento eager.
	//Por outro lado, o relacionamento toMany tem por
	//padr�o o carregamento lazy, o qual s� � carregado,
	//se fizer refer�ncia.
	//� uma boa pr�tica colocar lazy em todo o relacionamento
	//toOne.
	@ManyToOne(fetch = FetchType.LAZY) 
	private Cliente cliente;
	
	//Relacionamento ToMany o padr�o � lazy.
	//mappedBy informa ao JPA que o relacionamento � bidirecional.
	//itens = new ArrayList<>(); inicializa uma lista (vazia). Isso evita if�s no c�digo.
	//cascade = CascadeType.ALL tudo o que for feito para pedido ser� feito em itemPedido.
	//Objetos n�o carregados automaticamente.
	//Carregado somente se fizer acesso � lista.
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<ItemPedido> itens = new ArrayList<>();

	public Pedido() {
	}

	public Pedido(Cliente cliente) {
		this.cliente = cliente;
	}
	
	//M�todo para adicionar itens.
	//Relacionando item e pedido.
	public void adicionarItem(ItemPedido item) {
		item.setPedido(this);
		this.itens.add(item);
		this.valorTotal = this.valorTotal.add(item.getValor());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
