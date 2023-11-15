package br.com.alura.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")
//Cria uma tabela produto simples com as classes Livro e informática.
//DTYPE varchar(31) not null. Hibernate cria uma coluna,
//com o nome Livro e Informática.
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//Cria uma tabela produto e as tabelas Livro e informática com os relacionamentos.
@Inheritance(strategy = InheritanceType.JOINED)
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome; 
	private String descricao; 
	private BigDecimal preco;
	private LocalDate dataCadastro = LocalDate.now();
	
	//@Enumerated(EnumType.STRING) //Para que ao ser persistido insira o nome da constante.
	//É uma boa prática colocar lazy em todo o relacionamento toOne.
	@ManyToOne(fetch = FetchType.LAZY) 
    private Categoria categoria;
    
	public Produto() {
		
	}

	public Produto(String nome, String descricao, BigDecimal preco, Categoria categoria) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	} 
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	
	

}
