package com.ufcg.si1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Administrador {
	
	@Id
	@GeneratedValue
	private Long id;
	private String email;
	private String nome;
	private String senha;
	
	public static final String CODIGO = "admin";
	private String codigo = CODIGO;
	
	public Administrador(Long id, String email, String nome, String senha) {
		this.id = id;
		this.email = email;
		this.nome = nome;
		this.senha = senha;
		this.codigo = CODIGO;
	}
	
	public Administrador(){
		
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCodigo() {
		return codigo;
	}
	
	
	
	
}
