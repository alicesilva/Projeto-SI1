package com.ufcg.si1.model.queixa;

import exceptions.AcaoNaoPermitidaException;

public class QueixaAberta implements QueixaStatus{
	
	@Override
	public QueixaStatus abrirQueixa(Queixa queixa) throws AcaoNaoPermitidaException{
		throw new AcaoNaoPermitidaException("Queixa já esta aberta");
	}

	@Override
	public QueixaStatus resolverQueixa(Queixa queixa) {
		return new QueixaAndamento();
	}

	@Override
	public QueixaStatus fecharQueixa(Queixa queixa) {
		return new QueixaFechada();
	}
	
}
