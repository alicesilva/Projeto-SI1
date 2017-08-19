package com.ufcg.si1.model.queixa;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ufcg.si1.model.Endereco;
import com.ufcg.si1.model.Solicitante;

import exceptions.AcaoNaoPermitidaException;

@Entity
public class Queixa{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String descricao;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Solicitante solicitante;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Endereco enderecoDoEstabelecimento;
	
	@OneToOne(cascade=CascadeType.ALL)
	private QueixaStatus status;
	
	private String comentario = "";

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
		this.enderecoDoEstabelecimento = new Endereco(rua, uf, cidade);
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
	

	public Endereco getEnderecoDoEstabelecimento() {
		return enderecoDoEstabelecimento;
	}
	
	public QueixaStatus getStatus() {
		return status;
	}
	
	public void abrir() throws AcaoNaoPermitidaException{
		if(this.status == null){
			this.status = new QueixaAberta();
		}else{
			this.status = status.abrirQueixa();
		}
	}
	
	public void fechar() throws AcaoNaoPermitidaException{
		this.status = status.fecharQueixa();
	}
	
	public void resolver() throws AcaoNaoPermitidaException{
		this.status = status.resolverQueixa();
	}

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

}
