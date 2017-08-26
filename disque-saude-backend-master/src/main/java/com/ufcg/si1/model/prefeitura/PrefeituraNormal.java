package com.ufcg.si1.model.prefeitura;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "normal")
public class PrefeituraNormal extends PrefeituraSituacao{
	
	public static final double VINTE_PORCENTO = 0.2;
	public static final double DEZ_PORCENTO = 0.1;

	@Override
	public SituacaoGeralQueixas calculaSituacaoGeralQueixa(double qtdQueixaAberta, int qtdQueixaTotal) {
		double relacao = qtdQueixaAberta / qtdQueixaTotal;
		if (relacao > VINTE_PORCENTO) {
			return SituacaoGeralQueixas.RUIM;
		} else if (relacao > DEZ_PORCENTO) {
				return SituacaoGeralQueixas.REGULAR;
		}else{
			return SituacaoGeralQueixas.BOM;
		}
	}

}
