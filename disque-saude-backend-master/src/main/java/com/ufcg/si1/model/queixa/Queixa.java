package com.ufcg.si1.model.queixa;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.ufcg.si1.model.Solicitante;

@Entity
@Table(name="queixas")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "type")
@JsonSubTypes({ @JsonSubTypes.Type(value = QueixaAlimentar.class, name = "ALIMENTAR"),
	@JsonSubTypes.Type(value = QueixaAnimais.class, name = "ANIMAIS"),
	@JsonSubTypes.Type(value = QueixaGeral.class, name = "GERAL") })
public abstract class Queixa {
	


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String descricao;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Solicitante solicitante;

	
	@Transient
	@JsonIgnore
	private QueixaStatus status;
	
	
	private QueixaStatusEnum statusEnum;
	
	private String comentario = "";
	
	private String rua;
	private String cidade;
	private String uf;
	private String nome;
	private String email;

	public Queixa(){
	}

	public Queixa(Long id, String descricao, String comentario,
                  String nome, String email,
				  String rua, String uf, String cidade, QueixaStatus status) {
		this.id = id;
		this.descricao = descricao;
		this.status = status;
		this.comentario = comentario;
		this.solicitante = new Solicitante(nome, email);
		this.rua = rua;
		this.cidade = cidade;
		this.uf = uf;
		this.solicitante = new Solicitante(nome, email);
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Solicitante getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Solicitante solicitante) {
		this.solicitante = solicitante;
	}
	
	
	public QueixaStatus getStatus() {
		return status;
	}

	public void setStatus(QueixaStatus status) {
		this.status = status;
	}
	
	public QueixaStatusEnum getStatusEnum() {
		if(status instanceof QueixaAberta){
			statusEnum = QueixaStatusEnum.ABERTA;

		}else if(status instanceof QueixaFechada){
			statusEnum = QueixaStatusEnum.FECHADA;
		}else{
			statusEnum = QueixaStatusEnum.ABERTA;
		}
		
		return statusEnum;
	}
	
	public abstract String showType();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Queixa other = (Queixa) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Queixa [id=" + id + ", descricao=" + descricao + ", solicitante=" + solicitante + ", status=" + status
				+ ", statusEnum=" + statusEnum + ", comentario=" + comentario + ", rua=" + rua + ", cidade=" + cidade
				+ ", uf=" + uf + ", nome=" + nome + ", email=" + email + ", type=" + showType() + "]";
	}
	


}
