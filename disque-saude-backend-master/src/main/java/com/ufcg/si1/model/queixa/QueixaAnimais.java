package com.ufcg.si1.model.queixa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "queixa_animais")
public class QueixaAnimais extends Queixa {

	private String tipoAnimal;

	public QueixaAnimais(Long id, String descricao, String comentario, String nome, String email, String rua, String uf,
			String cidade, QueixaStatus status, String tipoAnimal) {
		super(id, descricao, comentario, nome, email, rua, uf, cidade, status);
		this.tipoAnimal = tipoAnimal;

	}

	public QueixaAnimais() {

	}

	public String getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(String tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

	@Override
	public String showType() {
		return "animais";
	}
	
	

}
