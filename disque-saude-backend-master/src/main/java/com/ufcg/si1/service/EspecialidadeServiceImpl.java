package com.ufcg.si1.service;

import com.ufcg.si1.model.Especialidade;

import com.ufcg.si1.repository.EspecialidadeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class EspecialidadeServiceImpl implements EspecialidadeService {

	@Autowired
	EspecialidadeRepository  especialidadeRepository;

    public EspecialidadeServiceImpl(EspecialidadeRepository especialidadeRepository) {
    	this.especialidadeRepository = especialidadeRepository;
    }

    @Override
    public Especialidade getEspecialidade(Long id){
    	return especialidadeRepository.findOne(id);
    }

    @Override
    public List<Especialidade> getAllEspecialidades(){
        return especialidadeRepository.findAll();
    }

    @Override
    public int size() {
        return getAllEspecialidades().size();
    }

    @Override
    public Especialidade addEspecialidade(Especialidade esp){
    	return especialidadeRepository.save(esp);
    }

    @Override
    public boolean existe(Long id) {
    	return especialidadeRepository.exists(id);
    	
    }


}
