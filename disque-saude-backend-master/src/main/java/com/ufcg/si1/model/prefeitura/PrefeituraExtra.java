package com.ufcg.si1.model.prefeitura;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "extra")
public class PrefeituraExtra extends PrefeituraSituacao{
	
	public static final double DEZ_PORCENTO = 0.1;
	public static final double CINCO_PORCENTO = 0.05;
	
	@Override
	public SituacaoGeralQueixas calculaSituacaoGeralQueixa(double qtdQueixaAberta, int qtdQueixaTotal) {
		double relacao = qtdQueixaAberta / qtdQueixaTotal;
		if (relacao > DEZ_PORCENTO) {
			return SituacaoGeralQueixas.RUIM;
		} else if (relacao > CINCO_PORCENTO) {
				return SituacaoGeralQueixas.REGULAR;
		}else{
			return SituacaoGeralQueixas.BOM;
		}
	}
	
	

}
