package com.ufcg.si1.service;


import java.util.Iterator;
import java.util.List;

import com.ufcg.si1.model.Queixa;

public interface QueixaService {

	List<Queixa> findAllQueixas();


    void saveQueixa(Queixa queixa);


	Queixa findById(long id);

	Queixa atualizaQueixa(long id, Queixa queixa) throws Exception;


	Queixa excluiQueixaPorId(long id) throws Exception;

    int size();

	Iterator<Queixa> getIterator();


	Queixa fecharQueixa(Queixa queixaAFechar) throws Exception;
	
	Integer getSituacaoGeralQueixas();


//	boolean isUserExist(Queixa user);
	
}
