package com.ufcg.si1.model.queixa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import exceptions.AcaoNaoPermitidaException;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "type")
@JsonSubTypes({ @JsonSubTypes.Type(value = QueixaAberta.class, name = "ABERTA"),
	@JsonSubTypes.Type(value = QueixaFechada.class, name = "FECHADA"),
	@JsonSubTypes.Type(value = QueixaAndamento.class, name = "ANDAMENTO"), })
public abstract class QueixaStatus{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	abstract QueixaStatus abrirQueixa() throws AcaoNaoPermitidaException;
	
	abstract QueixaStatus resolverQueixa() throws AcaoNaoPermitidaException;
	
	abstract QueixaStatus fecharQueixa()  throws AcaoNaoPermitidaException;
	
	public abstract QueixaStatusEnum tipoQueixa();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	

}
