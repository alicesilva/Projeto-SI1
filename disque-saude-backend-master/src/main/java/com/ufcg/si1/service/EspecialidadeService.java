package com.ufcg.si1.service;

import exceptions.EntradaException;

import com.ufcg.si1.model.especialidade.Especialidade;


public interface EspecialidadeService {
	
    Especialidade addEspecialidade(Especialidade especialidade) throws EntradaException;
}
