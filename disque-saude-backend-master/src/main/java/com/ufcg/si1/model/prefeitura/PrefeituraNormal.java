package com.ufcg.si1.model.prefeitura;

public class PrefeituraNormal implements PrefeituraSituacao{
	
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
