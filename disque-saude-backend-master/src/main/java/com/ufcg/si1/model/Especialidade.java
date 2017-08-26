package com.ufcg.si1.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.ufcg.si1.model.unidadeSaude.UnidadeSaude;

@Entity
public class Especialidade {
	@Id
	@GeneratedValue
    private Long id;

	private String descricao;
	
	@ManyToMany
	private Set<UnidadeSaude> unidadesSaude;

    public Especialidade(String descricao, Long id, Set<UnidadeSaude> unidadesSaude) {
        this.descricao = descricao;
        this.id = id;
        this.unidadesSaude = unidadesSaude;
        
    }

    public Especialidade(){

    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<UnidadeSaude> getUnidadesSaude() {
		return unidadesSaude;
	}

	public void setUnidadesSaude(Set<UnidadeSaude> unidadesSaude) {
		this.unidadesSaude = unidadesSaude;
	}
}
