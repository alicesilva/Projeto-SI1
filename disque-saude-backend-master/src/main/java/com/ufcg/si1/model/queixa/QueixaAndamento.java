package com.ufcg.si1.model.queixa;

import exceptions.AcaoNaoPermitidaException;

public class QueixaAndamento implements QueixaStatus{
	
	@Override
	public QueixaStatus abrirQueixa(Queixa queixa) throws AcaoNaoPermitidaException {
		throw new AcaoNaoPermitidaException("Queixa já foi aberta");
	}

	@Override
	public QueixaStatus resolverQueixa(Queixa queixa)throws AcaoNaoPermitidaException {
		throw new AcaoNaoPermitidaException("Queixa já está em andamento");
	}

	@Override
	public QueixaStatus fecharQueixa(Queixa queixa) {
		return new QueixaFechada();
	}
	
	

}
