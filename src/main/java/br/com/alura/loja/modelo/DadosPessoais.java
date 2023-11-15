package br.com.alura.loja.modelo;

import javax.persistence.Embeddable;

//Serve para embutir uma classe dentro de uma entidade.
@Embeddable
public class DadosPessoais {
	
	private String nome;
	private String cpf;
	
	public DadosPessoais() {
		
	}
	
	public DadosPessoais(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	
	

}
