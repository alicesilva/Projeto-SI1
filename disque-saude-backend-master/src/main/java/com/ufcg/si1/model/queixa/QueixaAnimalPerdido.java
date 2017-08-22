package com.ufcg.si1.model.queixa;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.ufcg.si1.model.Endereco;

@Entity
@DiscriminatorValue(value = "animal-perdido")
public class QueixaAnimalPerdido extends Queixa{
	
	@OneToOne(cascade=CascadeType.ALL)
	private Endereco localDoAnimalPerdido;
	
	private String tipoAnimal;
	
	public QueixaAnimalPerdido() {
		super();
	}

	public QueixaAnimalPerdido(Long id, String descricao, String comentario, String nome, String email,
			QueixaStatus status, Endereco localDoAnimalPerdido, String tipoAnimal) {
		super(id, descricao, comentario, nome, email, status);
		this.localDoAnimalPerdido = localDoAnimalPerdido;
		this.tipoAnimal = tipoAnimal;
	}

	public Endereco getLocalDoAnimalPerdido() {
		return localDoAnimalPerdido;
	}

	public void setLocalDoAnimalPerdido(Endereco localDoAnimalPerdido) {
		this.localDoAnimalPerdido = localDoAnimalPerdido;
	}

	public String getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(String tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}
}
