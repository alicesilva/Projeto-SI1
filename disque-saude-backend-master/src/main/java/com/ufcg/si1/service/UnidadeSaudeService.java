package com.ufcg.si1.service;

import java.util.List;
import java.util.Set;

import com.ufcg.si1.model.especialidade.Especialidade;
import com.ufcg.si1.model.unidadeSaude.UnidadeSaude;

import exceptions.AcaoNaoPermitidaException;
import exceptions.EntradaException;
import exceptions.IdInexistenteException;


public interface UnidadeSaudeService {
	Set<Especialidade> getEspecialidades(Long id) throws IdInexistenteException;

	List<UnidadeSaude> getAllUnidadesSaude();

	UnidadeSaude addUnidadeSaude(UnidadeSaude unidadeSaude) throws EntradaException;
	
	float getMediaMedicoPorPaciente(String bairro) throws EntradaException, AcaoNaoPermitidaException;

	void adicionarEspecialidade(Especialidade esp, Long id)  throws IdInexistenteException;

	UnidadeSaude getUnidadeSaude(String bairro) throws EntradaException;
}
