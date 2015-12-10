package br.com.cepep.agenda.entidades;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Pessoa {
	private int id;
	@NotNull
	private String nome;
	@NotNull
	@Size(min=11)
	private String celular;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
}
