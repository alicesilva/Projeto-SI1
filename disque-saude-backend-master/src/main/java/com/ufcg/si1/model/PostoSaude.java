package com.ufcg.si1.model;

import java.util.Set;

public class PostoSaude extends UnidadeSaude{

    public PostoSaude(long id, Set<Especialidade> especialidades, TipoUnidadeSaude tipoUnidadeSaude, int numeroMedicos,
			int numeroPacientesPorDia, LocalizacaoUnidadeSaude endereco) {
		super(id, especialidades, tipoUnidadeSaude, numeroMedicos, numeroPacientesPorDia, endereco);
	}

	public PostoSaude(){
        super();
    }

}
