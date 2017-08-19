package com.ufcg.si1.service;


import java.util.List;

import com.ufcg.si1.model.queixa.Queixa;
import com.ufcg.si1.model.queixa.QueixaStatusEnum;

import exceptions.AcaoNaoPermitidaException;
import exceptions.IdInexistenteException;

public interface QueixaService {
	
	Queixa salvarQueixa (Queixa queixa, String tipoQueixa)  throws AcaoNaoPermitidaException;


	Queixa getQueixaPorId(Long id) throws IdInexistenteException ;


	Queixa addComentarioNaQueixa(Long id, String comentario);


	Queixa modificaStatusDaQueixa(Long id, String statusEnum) throws AcaoNaoPermitidaException;

/*
	Queixa atualizaQueixa(Long id, Queixa queixa) throws IdInexistenteException;
	

	Queixa excluiQueixaPorId(Long id) throws IdInexistenteException;


    int size();

	Queixa fecharQueixa(Queixa queixaAFechar)  throws IdInexistenteException;
	
	Integer getSituacaoGeralQueixas();

//	boolean isUserExist(Queixa user);
*/	
}
