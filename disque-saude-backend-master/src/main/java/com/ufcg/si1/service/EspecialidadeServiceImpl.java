package com.ufcg.si1.service;

import com.ufcg.si1.model.especialidade.Especialidade;

import com.ufcg.si1.repository.EspecialidadeRepository;

import exceptions.EntradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EspecialidadeServiceImpl implements EspecialidadeService {

	@Autowired
	EspecialidadeRepository  especialidadeRepository;

    public EspecialidadeServiceImpl(EspecialidadeRepository especialidadeRepository) {
    	this.especialidadeRepository = especialidadeRepository;
    }
    
    @Override
    public Especialidade addEspecialidade(Especialidade especialidade)throws EntradaException{
    	if(especialidade == null){
    		throw new EntradaException("Especialidade Inválida!");
    	}
    	return especialidadeRepository.save(especialidade);
    }


}
