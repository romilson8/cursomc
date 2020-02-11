package br.com.banzo.domain;



public class Categoria extends AbstractEntity{
	
	private String nome;

	
	public Categoria() {
		
	}
	
	public Categoria(String nome) {
		this.nome = nome;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
