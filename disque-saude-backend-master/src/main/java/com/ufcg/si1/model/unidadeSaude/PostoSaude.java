package com.ufcg.si1.model.unidadeSaude;

import java.util.Set;

import com.ufcg.si1.model.Especialidade;

public class PostoSaude extends UnidadeSaude{

    public PostoSaude(long id, Set<Especialidade> especialidades, TipoUnidadeSaude tipoUnidadeSaude, int numeroMedicos,
			int numeroPacientesPorDia, LocalizacaoUnidadeSaude endereco) {
		super(id, especialidades, tipoUnidadeSaude, numeroMedicos, numeroPacientesPorDia, endereco);
	}

	public PostoSaude(){
        super();
    }

}
