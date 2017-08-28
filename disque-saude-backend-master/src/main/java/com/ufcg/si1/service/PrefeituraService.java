package com.ufcg.si1.service;

import java.util.List;

import com.ufcg.si1.model.prefeitura.Prefeitura;
import com.ufcg.si1.model.prefeitura.SituacaoGeralQueixas;
import com.ufcg.si1.model.queixa.Queixa;

import exceptions.AcaoNaoPermitidaException;

public interface PrefeituraService {
	
	SituacaoGeralQueixas getSituacaoGeralQueixa()throws AcaoNaoPermitidaException;
	
	List<Queixa> getQueixas();
	
	Prefeitura modificaStatus(String situacao);

}
