package com.ufcg.si1.service;

import java.util.List;
import java.util.Set;
import com.ufcg.si1.model.Especialidade;
import com.ufcg.si1.model.unidadeSaude.UnidadeSaude;

import exceptions.IdInexistenteException;


public interface UnidadeSaudeService {
	Set<Especialidade> getEspecialidades(Long id) throws IdInexistenteException;

	List<UnidadeSaude> getAllUnidadesSaude();

	UnidadeSaude insere(UnidadeSaude unidadeSaude);

	boolean existeUnidadeSaude(Long id);

	UnidadeSaude encontraPorId(long id)  throws IdInexistenteException;

	void adicionarEspecialidade(Especialidade esp, Long id)  throws IdInexistenteException;

	UnidadeSaude getUnidadeSaude(String bairro);

	UnidadeSaude adicionaUnidadeSaude(UnidadeSaude unidadeSaude);

	float getMediaMedicoPaciente(String bairro);
}
