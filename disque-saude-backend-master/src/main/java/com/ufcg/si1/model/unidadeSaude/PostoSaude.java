package com.ufcg.si1.model.unidadeSaude;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.ufcg.si1.model.especialidade.Especialidade;

@Entity
@DiscriminatorValue(value = "posto de saude")
public class PostoSaude extends UnidadeSaude{

	public PostoSaude() {
		super();
	}

	public PostoSaude(Long id, String descricao, Set<Especialidade> especialidades, LocalizacaoUnidadeSaude endereco,
			int numMedicos, float numPacientes) {
		super(id, descricao, especialidades, endereco, numMedicos, numPacientes);
	}
}
