package com.ufcg.si1.model.prefeitura;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Prefeitura {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	private PrefeituraSituacao situacaoPrefeitura;
	
	public Prefeitura() {
	}

	public Prefeitura(Long id, PrefeituraSituacao situacaoPrefeitura) {
		this.id = id;
		this.situacaoPrefeitura = situacaoPrefeitura;
	}
	
	public Prefeitura(PrefeituraSituacao situacaoPrefeitura) {
		this.situacaoPrefeitura = situacaoPrefeitura;
	}

	public SituacaoGeralQueixas calculaSituacaoGeralQueixa(double qtdQueixaAberta, int qtdQueixaTotal){
		return situacaoPrefeitura.calculaSituacaoGeralQueixa(qtdQueixaAberta, qtdQueixaTotal);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PrefeituraSituacao getSituacaoPrefeitura() {
		return situacaoPrefeitura;
	}

	public void setSituacaoPrefeitura(PrefeituraSituacao situacaoPrefeitura) {
		this.situacaoPrefeitura = situacaoPrefeitura;
	}
}
