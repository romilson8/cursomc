package br.com.banzo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Estado extends AbstractEntity{

	private String nome;
	
	@OneToMany(mappedBy="estado")
	private List<Cidade> cidades = new ArrayList<>();

	public Estado() {

	}

	public Estado(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
}
