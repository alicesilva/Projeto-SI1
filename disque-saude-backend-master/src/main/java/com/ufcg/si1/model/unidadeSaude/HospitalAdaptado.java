package com.ufcg.si1.model.unidadeSaude;
import br.edu.ufcg.Hospital;

public class HospitalAdaptado extends UnidadeSaude {
	
	private Hospital hospital;
	private String descricao;
	private int numMedicos;
	private float numPacientes;
	
	public HospitalAdaptado(String descricao, int numMedicos, float numPacientes) {
		//super();
		this.descricao = descricao;
		this.numMedicos = numMedicos;
		this.numPacientes = numPacientes;
		this.hospital = hospital;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
