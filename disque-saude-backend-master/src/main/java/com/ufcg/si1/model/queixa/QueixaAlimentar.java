package com.ufcg.si1.model.queixa;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.ufcg.si1.model.Endereco;

@Entity
@DiscriminatorValue(value = "alimentar")
public class QueixaAlimentar extends Queixa{
	
	@OneToOne(cascade=CascadeType.ALL)
	private Endereco enderecoDoEstabelecimento;

	public QueixaAlimentar() {
		super();
	}

	public QueixaAlimentar(Long id, String descricao, String comentario, String nome, String email, String rua,
			String uf, String cidade, QueixaStatus status) {
		super(id, descricao, comentario, nome, email, status);
		this.enderecoDoEstabelecimento = new Endereco(rua, uf, cidade);
	}

	public Endereco getEnderecoDoEstabelecimento() {
		return enderecoDoEstabelecimento;
	}

	public void setEnderecoDoEstabelecimento(Endereco enderecoDoEstabelecimento) {
		this.enderecoDoEstabelecimento = enderecoDoEstabelecimento;
	}
	
	
	
	

}
