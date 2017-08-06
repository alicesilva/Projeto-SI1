package com.ufcg.si1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Especialidade {
	@Id
	@GeneratedValue
    private int codigo;

    private String descricao;

    public Especialidade(String descricao) {
        this.codigo = 0; // gerado no repositorio
        this.descricao = descricao;
    }

    public Especialidade(){

    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int cod) {
        this.codigo = cod;
    }
}
