package com.ufcg.si1.model.queixa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import exceptions.AcaoNaoPermitidaException;

@Entity
@DiscriminatorValue(value = "fechada")
public class QueixaFechada extends QueixaStatus{

	@Override
	public QueixaStatus abrirQueixa() throws AcaoNaoPermitidaException {
		throw new AcaoNaoPermitidaException("Queixa já foi fechada");
	}

	@Override
	public QueixaStatus resolverQueixa() throws AcaoNaoPermitidaException {
		throw new AcaoNaoPermitidaException("Queixa já foi fechada");
	}

	@Override
	public QueixaStatus fecharQueixa() throws AcaoNaoPermitidaException{
		throw new AcaoNaoPermitidaException("Queixa já foi fechada");
	}

	@Override
	public QueixaStatusEnum tipoQueixa() {
		return QueixaStatusEnum.FECHADA;
	}
	
	

}
