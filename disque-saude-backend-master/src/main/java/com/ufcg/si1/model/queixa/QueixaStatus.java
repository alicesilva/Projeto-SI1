package com.ufcg.si1.model.queixa;

import exceptions.AcaoNaoPermitidaException;

public interface QueixaStatus{
	
	QueixaStatus abrirQueixa(Queixa queixa) throws AcaoNaoPermitidaException;
	
	QueixaStatus resolverQueixa(Queixa queixa) throws AcaoNaoPermitidaException;
	
	QueixaStatus fecharQueixa(Queixa queixa)  throws AcaoNaoPermitidaException;
	
	

}
