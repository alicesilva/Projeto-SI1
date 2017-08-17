package com.ufcg.si1.model.unidadeSaude;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.ufcg.si1.model.Especialidade;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PostoSaude.class, name = "posto")
})
@Entity
public class UnidadeSaude {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@ManyToMany
	private Set<Especialidade> especialidades;
    
    @OneToOne(cascade=CascadeType.ALL)
    private LocalizacaoUnidadeSaude endereco;
    
    private TipoUnidadeSaude tipo;
    
    private int numeroMedicos;
    
    private int numeroPacientesDia;

    
    public UnidadeSaude(long id, Set<Especialidade> especialidades, TipoUnidadeSaude tipo,
			int numeroMedicos, int numeroPacientesDia, LocalizacaoUnidadeSaude endereco) {
		this.id = id;
		this.especialidades = especialidades;
		this.tipo = tipo;
		this.numeroMedicos = numeroMedicos;
		this.numeroPacientesDia = numeroPacientesDia;
		this.endereco = endereco;
	}

	public UnidadeSaude(){
    }
    
    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	public TipoUnidadeSaude getTipo() {
		return tipo;
	}

	public void setTipo(TipoUnidadeSaude tipo) {
		this.tipo = tipo;
	}

	public int getNumeroMedicos() {
		return numeroMedicos;
	}

	public void setNumeroMedicos(int numeroMedicos) {
		this.numeroMedicos = numeroMedicos;
	}
	

	public int getNumeroPacientesDia() {
		return numeroPacientesDia;
	}

	public void setNumeroPacientesDia(int numeroPacientesDia) {
		this.numeroPacientesDia = numeroPacientesDia;
	}

	public void setEspecialidades(Set<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}

	public Set<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public LocalizacaoUnidadeSaude getEndereco() {
		return endereco;
	}

	public void setEndereco(LocalizacaoUnidadeSaude endereco) {
		this.endereco = endereco;
	}
	
	
}
