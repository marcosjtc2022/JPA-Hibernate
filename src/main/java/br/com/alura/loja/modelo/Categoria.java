package br.com.alura.loja.modelo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {
	
	//Retirados para construir chave composta.
	//@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private Long id;
	
	//Mapeamento de chave composta. Tem que usar o @EmbeddedId para informar ao JPA
	//que não são atributos comuns, mas a chave primária.
	@EmbeddedId
	private CategoriaId id;
   
     
	public Categoria() {
		
	}

	public Categoria(String nome) {
		this.id = new CategoriaId(nome, "xpto") ;
	}

//	public Long getId() {
//		return this.id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}

	public String getNome() {
		return this.id.getNome();
	}
//
//	public void setNome(String nome) {
//		this.nome = nome;
//	}

	
	 
	 
     
     

}
