package com.ufcg.si1.model.prefeitura;

public class PrefeituraCaos implements PrefeituraSituacao{

	public static final double CINCO_PORCENTO = 0.5;
	public static final double DOIS_PORCENTO = 0.2;
	
	
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
