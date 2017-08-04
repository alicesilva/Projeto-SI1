package com.ufcg.si1.service;


import java.util.Iterator;
import java.util.List;

import com.ufcg.si1.model.Queixa;

public interface QueixaService {

	List<Queixa> findAllQueixas();


    void saveQueixa(Queixa queixa);


	Queixa findById(Integer id);


	Queixa atualizaQueixa(Integer id, Queixa queixa) throws Exception;
	

	Queixa excluiQueixaPorId(Integer id) throws Exception;


    int size();

	Queixa fecharQueixa(Queixa queixaAFechar) throws Exception;
	
	Integer getSituacaoGeralQueixas();

//	boolean isUserExist(Queixa user);
	
}
