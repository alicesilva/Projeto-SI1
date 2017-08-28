package com.ufcg.si1.service;

import com.ufcg.si1.model.especialidade.Especialidade;
import com.ufcg.si1.model.unidadeSaude.UnidadeSaude;
import com.ufcg.si1.repository.UnidadeSaudeRepository;

import exceptions.AcaoNaoPermitidaException;
import exceptions.EntradaException;
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
    	UnidadeSaude unidadeEncontrada = unidadeSaudeRepository.findOne(id);
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
	public UnidadeSaude addUnidadeSaude(UnidadeSaude unidadeSaude) throws EntradaException {
    	if(unidadeSaude == null){
    		throw new EntradaException("Unidade de Saúde Inválida!");
    	}
		return unidadeSaudeRepository.save(unidadeSaude);
	}
    
    @Override
	public float getMediaMedicoPorPaciente(String bairro) throws EntradaException, AcaoNaoPermitidaException {
		if(bairro == null || bairro.equals("")){
			throw new EntradaException("Bairro Inválido!");
		}
		UnidadeSaude unidadeSaudeEncontrada = getUnidadeSaude(bairro);
		
		if(unidadeSaudeEncontrada == null){
			throw new EntradaException("Unidade Saude Inválida!");
		}
		if(unidadeSaudeEncontrada.getNumPacientes() == 0){
			throw new AcaoNaoPermitidaException("Não há nenhum paciente nesta Unidade de Saúde");
		}
		
		float taxa = unidadeSaudeEncontrada.getNumMedicos()/unidadeSaudeEncontrada.getNumPacientes();
		return taxa;
	}
    
    @Override
    public void adicionarEspecialidade(Especialidade esp, Long id) throws IdInexistenteException {
    	UnidadeSaude unidadeSaudeEncontrada = unidadeSaudeRepository.findOne(id);
    	unidadeSaudeEncontrada.getEspecialidades().add(esp);
    }

	@Override
	public UnidadeSaude getUnidadeSaude(String bairro) throws EntradaException {
		if(bairro == null || bairro.equals("")){
			throw new EntradaException("Nome do bairro inválido!");
		}
		
		UnidadeSaude unidadeSaudeEncontrada = unidadeSaudeRepository.searchUnidadeSaudeToBairro(bairro);
		
		if(unidadeSaudeRepository == null){
			throw new EntradaException("Unidade de Saúde não encontrada!");
		}
		
		return unidadeSaudeEncontrada;
	}
}
