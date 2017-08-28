package com.ufcg.si1.service;


import com.ufcg.si1.model.queixa.Queixa;

import exceptions.AcaoNaoPermitidaException;
import exceptions.EntradaException;
import exceptions.IdInexistenteException;

public interface QueixaService {
	
	Queixa addQueixa (Queixa queixa)  throws AcaoNaoPermitidaException;


	Queixa getQueixaId(Long id) throws IdInexistenteException ;


	Queixa addComentarioNaQueixa(Long id, String comentario)  throws EntradaException;


	Queixa modificaStatusDaQueixa(Long id, String statusEnum) throws EntradaException, AcaoNaoPermitidaException;
}
