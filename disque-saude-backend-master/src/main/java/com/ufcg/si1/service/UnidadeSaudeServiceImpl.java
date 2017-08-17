package com.ufcg.si1.service;

import com.ufcg.si1.model.Especialidade;
import com.ufcg.si1.model.unidadeSaude.UnidadeSaude;
import com.ufcg.si1.repository.UnidadeSaudeRepository;

import exceptions.IdInexistenteException;

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
    public Set<Especialidade> getEspecialidades(Long id) throws IdInexistenteException{
    	UnidadeSaude unidadeEncontrada = encontraPorId(id);
    	if (unidadeEncontrada == null){
    		throw new IdInexistenteException("Não há nenhuma especialidade com id " + id); 
    	}
    	
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
    public UnidadeSaude encontraPorId(long id) throws IdInexistenteException  {
    	UnidadeSaude unidadeSaude = unidadeSaudeRepository.findOne(id);
    	if (unidadeSaude == null){
    		throw new IdInexistenteException("Não há nenhuma unidade de saúde com id " + id);
    	}
    	return unidadeSaude;
    }
    
    @Override
    public void adicionarEspecialidade(Especialidade esp, Long id) throws IdInexistenteException {
    	UnidadeSaude unidadeSaudeEncontrada = encontraPorId(id);
    	unidadeSaudeEncontrada.getEspecialidades().add(esp);
    }

	@Override
	public UnidadeSaude getUnidadeSaude(String bairro) {
		return unidadeSaudeRepository.searchUnidadeSaudeToBairro(bairro);
	}
}
