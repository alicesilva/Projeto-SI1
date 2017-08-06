package com.ufcg.si1.service;

import java.util.List;
import java.util.Set;
import com.ufcg.si1.model.Especialidade;
import com.ufcg.si1.model.UnidadeSaude;


public interface UnidadeSaudeService {
	Set<Especialidade> getEspecialidades(Long id);

	List<UnidadeSaude> getAllUnidadesSaude();

	UnidadeSaude insere(UnidadeSaude unidadeSaude);

	boolean existeUnidadeSaude(Long id);

	UnidadeSaude findById(long id);

	void adicionarEspecialidade(Especialidade esp, Long id);
}
