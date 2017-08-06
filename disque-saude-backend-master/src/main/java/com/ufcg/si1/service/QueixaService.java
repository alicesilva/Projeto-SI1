package com.ufcg.si1.service;


import java.util.List;
import com.ufcg.si1.model.Queixa;

public interface QueixaService {

	List<Queixa> findAllQueixas();


    void saveQueixa(Queixa queixa);


	Queixa findById(Long id);


	Queixa atualizaQueixa(Long id, Queixa queixa) throws Exception;
	

	Queixa excluiQueixaPorId(Long id) throws Exception;


    int size();

	Queixa fecharQueixa(Queixa queixaAFechar) throws Exception;
	
	Integer getSituacaoGeralQueixas();

//	boolean isUserExist(Queixa user);
	
}
