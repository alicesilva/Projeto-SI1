package com.ufcg.si1.model.unidadeSaude;

import java.util.Set;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.ufcg.si1.model.Especialidade;
@Entity
@DiscriminatorValue(value = "hospital")
public class HospitalAdapter extends UnidadeSaude {

	public HospitalAdapter() {
		super();
	}

	public HospitalAdapter(Long id, String descricao, Set<Especialidade> especialidades,
			LocalizacaoUnidadeSaude endereco, int numMedicos, float numPacientes) {
		super(id, descricao, especialidades, endereco, numMedicos, numPacientes);
	}
}
