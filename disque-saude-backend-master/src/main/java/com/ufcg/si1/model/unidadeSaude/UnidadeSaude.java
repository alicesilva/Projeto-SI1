package com.ufcg.si1.model.unidadeSaude;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.ufcg.si1.model.Especialidade;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "type")
@JsonSubTypes({ 
	@JsonSubTypes.Type(value = PostoSaude.class, name = "POSTO DE SAUDE"),
	@JsonSubTypes.Type(value = HospitalAdapter.class, name = "HOSPITAL")
	})
public class UnidadeSaude {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String descricao;
	
	@ManyToMany
	private Set<Especialidade> especialidades;
	
	@OneToOne(cascade=CascadeType.ALL)
	private LocalizacaoUnidadeSaude endereco;
	
	private int numMedicos;
	
	private float numPacientes;

	public UnidadeSaude() {
		super();
	}

	public UnidadeSaude(Long id, String descricao, Set<Especialidade> especialidades, LocalizacaoUnidadeSaude endereco,
			int numMedicos, float numPacientes) {
		this.id = id;
		this.descricao = descricao;
		this.especialidades = especialidades;
		this.endereco = endereco;
		this.numMedicos = numMedicos;
		this.numPacientes = numPacientes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(Set<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}

	public LocalizacaoUnidadeSaude getEndereco() {
		return endereco;
	}

	public void setEndereco(LocalizacaoUnidadeSaude endereco) {
		this.endereco = endereco;
	}

	public int getNumMedicos() {
		return numMedicos;
	}

	public void setNumMedicos(int numMedicos) {
		this.numMedicos = numMedicos;
	}

	public float getNumPacientes() {
		return numPacientes;
	}

	public void setNumPacientes(float numPacientes) {
		this.numPacientes = numPacientes;
	}
	
	
	
	

}