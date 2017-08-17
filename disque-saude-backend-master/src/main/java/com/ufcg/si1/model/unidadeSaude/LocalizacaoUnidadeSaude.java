package com.ufcg.si1.model.unidadeSaude;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class LocalizacaoUnidadeSaude {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String bairro;
	
	private String rua;
	
	private String cidade;
	
	private String uf;

	public LocalizacaoUnidadeSaude(String bairro, String rua, String cidade, String uf) {
		this.bairro = bairro;
		this.rua = rua;
		this.cidade = cidade;
		this.uf = uf;
	}
	
	public LocalizacaoUnidadeSaude(){
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
	
	

}
