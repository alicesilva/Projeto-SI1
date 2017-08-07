package com.ufcg.si1.service;


import java.util.List;
import com.ufcg.si1.model.Queixa;

import exceptions.AcaoNaoPermitidaException;
import exceptions.IdInexistenteException;

public interface QueixaService {

	List<Queixa> findAllQueixas();


    void saveQueixa(Queixa queixa)  throws AcaoNaoPermitidaException;


	Queixa encontraPorId(Long id) throws IdInexistenteException ;


	Queixa atualizaQueixa(Long id, Queixa queixa) throws IdInexistenteException;
	

	Queixa excluiQueixaPorId(Long id) throws IdInexistenteException;


    int size();

	Queixa fecharQueixa(Queixa queixaAFechar)  throws IdInexistenteException;
	
	Integer getSituacaoGeralQueixas();

//	boolean isUserExist(Queixa user);
	
}
