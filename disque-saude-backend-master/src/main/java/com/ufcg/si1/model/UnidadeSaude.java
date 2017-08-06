package com.ufcg.si1.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PostoSaude.class, name = "posto")
})
@Entity
public class UnidadeSaude {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String descricao;
    
    @ManyToMany
	private Set<Especialidade> especialidades;

    public UnidadeSaude(String descricao, Long id, Set<Especialidade> especialidades) {
    	this.id = id;
        this.descricao = descricao;
        this.especialidades = especialidades;
    }
    public UnidadeSaude(){
    }
    
    public long getId() {
		return id;
	}
	public void setId(long id) {
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
}
