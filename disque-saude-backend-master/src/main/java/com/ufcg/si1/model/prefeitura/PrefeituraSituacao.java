package com.ufcg.si1.model.prefeitura;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "type")
@JsonSubTypes({ @JsonSubTypes.Type(value = PrefeituraNormal.class, name = "NORMAL"),
	@JsonSubTypes.Type(value = PrefeituraExtra.class, name = "EXTRA"),
	@JsonSubTypes.Type(value = PrefeituraCaos.class, name = "CAOS"), })
public abstract class PrefeituraSituacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	abstract SituacaoGeralQueixas calculaSituacaoGeralQueixa(double qtdQueixaAberta, int qtdQueixaTotal);

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
