package com.ufcg.si1.service;


import com.ufcg.si1.model.queixa.Queixa;

import exceptions.AcaoNaoPermitidaException;
import exceptions.IdInexistenteException;

public interface QueixaService {
	
	Queixa salvarQueixa (Queixa queixa)  throws AcaoNaoPermitidaException;


	Queixa getQueixaPorId(Long id) throws IdInexistenteException ;


	Queixa addComentarioNaQueixa(Long id, String comentario);


	Queixa modificaStatusDaQueixa(Long id, String statusEnum) throws AcaoNaoPermitidaException;
	
}
