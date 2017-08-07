package com.ufcg.si1.service;

import com.ufcg.si1.model.Especialidade;
import java.util.List;


public interface EspecialidadeService {
	public Especialidade getEspecialidade(Long id);

    List<Especialidade> getAllEspecialidades();

    int size();

    Especialidade addEspecialidade(Especialidade esp);
    
    boolean existe(Long id);
}
