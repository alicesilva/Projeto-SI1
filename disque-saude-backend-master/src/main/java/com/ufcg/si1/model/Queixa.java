package com.ufcg.si1.model;

import exceptions.AcaoNaoPermitidaException;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Queixa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String descricao;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Solicitante solicitante;
	
	@OneToOne(cascade=CascadeType.ALL)
	private LocalizacaoDoProblema localizacaoDoProblema;

	private SituacaoDaQueixa situacao;

	private String comentario = ""; // usado na atualizacao da queixa

	public Queixa(){
	}

	public Queixa(Long id, String descricao, String situacao, String comentario,
                  String nome, String email,
				  String rua, String uf, String cidade) {
		this.id = id;
		this.descricao = descricao;
		this.situacao = SituacaoDaQueixa.valueOf(situacao);
		this.comentario = comentario;
		this.solicitante = new Solicitante(nome, email);
		this.localizacaoDoProblema = new LocalizacaoDoProblema(rua, uf, cidade);
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

	

	public SituacaoDaQueixa getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoDaQueixa situacao) {
		this.situacao = situacao;
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
	
	public LocalizacaoDoProblema getLocalizacaoDoProblema() {
		return localizacaoDoProblema;
	}

	public void setLocalizacaoDoProblema(LocalizacaoDoProblema localizacaoDoProblema) {
		this.localizacaoDoProblema = localizacaoDoProblema;
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
