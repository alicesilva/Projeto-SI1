package com.ufcg.si1.service;

import com.ufcg.si1.model.Especialidade;
import com.ufcg.si1.model.UnidadeSaude;
import com.ufcg.si1.repository.UnidadeSaudeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;


@Service
public class UnidadeSaudeServiceImpl implements UnidadeSaudeService {
   
	@Autowired
	UnidadeSaudeRepository unidadeSaudeRepository;

    public UnidadeSaudeServiceImpl(UnidadeSaudeRepository unidadeSaudeRepository) {
        this.unidadeSaudeRepository = unidadeSaudeRepository;
    }

    @Override
    public Set<Especialidade> getEspecialidades(Long id){
    	UnidadeSaude unidadeEncontrada = findById(id);
    	return unidadeEncontrada.getEspecialidades();
    }
    
    @Override
    public List<UnidadeSaude> getAllUnidadesSaude() {
        return unidadeSaudeRepository.findAll();
    }
    
    @Override
    public UnidadeSaude insere(UnidadeSaude unidadeSaude){
    	return unidadeSaudeRepository.save(unidadeSaude);
    }
    
    @Override
    public boolean existeUnidadeSaude(Long id) {
    	return unidadeSaudeRepository.exists(id);
        
    }
    
    @Override
    public UnidadeSaude findById(long id) {
    	return unidadeSaudeRepository.findOne(id);
    }
    
    @Override
    public void adicionarEspecialidade(Especialidade esp, Long id) {
    	UnidadeSaude unidadeSaudeEncontrada = findById(id);
    	unidadeSaudeEncontrada.getEspecialidades().add(esp);
    }
}
