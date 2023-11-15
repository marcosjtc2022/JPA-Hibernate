package br.com.alura.loja.modelo;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//Incorpora classe DadosPessoais nesta classe.
	@Embedded
	private DadosPessoais dadosPessoais;
	
	
	public Cliente(String nome, String cpf) {
		this.dadosPessoais = new DadosPessoais(nome,cpf);
	}

	public Cliente() {
	}

	public DadosPessoais getDadosPessoais() {
		return dadosPessoais;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	//Método delegate para evitar "quebra" do código.
	public String getNome() {
		return this.dadosPessoais.getNome();
	}
	
	//Método delegate para evitar "quebra" do código.
	public String getCpf() {
			return this.dadosPessoais.getCpf();
	}
	
}
