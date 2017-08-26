package com.ufcg.si1.model.prefeitura;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "caos")
public class PrefeituraCaos extends PrefeituraSituacao{

	public static final double CINCO_PORCENTO = 0.05;
	public static final double DOIS_PORCENTO = 0.02;
	
	
	@Override
	public SituacaoGeralQueixas calculaSituacaoGeralQueixa(double qtdQueixaAberta, int qtdQueixaTotal) {
		double relacao = qtdQueixaAberta / qtdQueixaTotal;
		if (relacao > CINCO_PORCENTO) {
			return SituacaoGeralQueixas.RUIM;
		} else if (relacao > DOIS_PORCENTO) {
				return SituacaoGeralQueixas.REGULAR;
		}else{
			return SituacaoGeralQueixas.BOM;
		}
	}

}
