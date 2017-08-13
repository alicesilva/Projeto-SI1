package com.ufcg.si1.model.queixa;

import exceptions.AcaoNaoPermitidaException;

public class QueixaFechada implements QueixaStatus{
	
	@Override
	public QueixaStatus abrirQueixa(Queixa queixa) throws AcaoNaoPermitidaException {
		throw new AcaoNaoPermitidaException("Queixa já foi fechada");
	}

	@Override
	public QueixaStatus resolverQueixa(Queixa queixa) throws AcaoNaoPermitidaException {
		throw new AcaoNaoPermitidaException("Queixa já foi fechada");
	}

	@Override
	public QueixaStatus fecharQueixa(Queixa queixa) throws AcaoNaoPermitidaException{
		throw new AcaoNaoPermitidaException("Queixa já foi fechada");
	}
	
	

}
