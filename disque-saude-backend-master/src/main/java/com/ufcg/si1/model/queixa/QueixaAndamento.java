package com.ufcg.si1.model.queixa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import exceptions.AcaoNaoPermitidaException;

@Entity
@DiscriminatorValue(value = "andamento")
public class QueixaAndamento extends QueixaStatus{
	@Id
	@GeneratedValue
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public QueixaStatus abrirQueixa() throws AcaoNaoPermitidaException {
		throw new AcaoNaoPermitidaException("Queixa já foi aberta");
	}

	@Override
	public QueixaStatus resolverQueixa()throws AcaoNaoPermitidaException {
		throw new AcaoNaoPermitidaException("Queixa já está em andamento");
	}

	@Override
	public QueixaStatus fecharQueixa() {
		return new QueixaFechada();
	}

	@Override
	public QueixaStatusEnum tipoQueixa() {
		return QueixaStatusEnum.ANDAMENTO;
	}
	
	

}
