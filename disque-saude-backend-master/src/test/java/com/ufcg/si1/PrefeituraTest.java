package com.ufcg.si1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ufcg.si1.model.prefeitura.Prefeitura;
import com.ufcg.si1.model.prefeitura.PrefeituraCaos;
import com.ufcg.si1.model.prefeitura.PrefeituraExtra;
import com.ufcg.si1.model.prefeitura.PrefeituraNormal;
import com.ufcg.si1.model.prefeitura.PrefeituraSituacao;
import com.ufcg.si1.model.prefeitura.SituacaoGeralQueixas;

public class PrefeituraTest {
	
	private Prefeitura prefeitura;
	private PrefeituraSituacao situacaoCaos;
	
	@Before
	public void setUp() {
		this.situacaoCaos = new PrefeituraCaos();
		this.prefeitura = new Prefeitura((long)1, situacaoCaos);
	}
	
	@Test
	public void calculaSituacaoCaosTest() {
		assertEquals(prefeitura.calculaSituacaoGeralQueixa(4, 6), SituacaoGeralQueixas.RUIM);
		assertEquals(prefeitura.calculaSituacaoGeralQueixa(4, 100), SituacaoGeralQueixas.REGULAR);
		assertEquals(prefeitura.calculaSituacaoGeralQueixa(4, 210), SituacaoGeralQueixas.BOM);
	}
	
	@Test
	public void calculaSituacaoExtraTest() {
		PrefeituraSituacao situacaoExtra = new PrefeituraExtra();
		prefeitura.setSituacaoPrefeitura(situacaoExtra);
		assertEquals(prefeitura.calculaSituacaoGeralQueixa(10, 80), SituacaoGeralQueixas.RUIM);
		assertEquals(prefeitura.calculaSituacaoGeralQueixa(10, 120), SituacaoGeralQueixas.REGULAR);
		assertEquals(prefeitura.calculaSituacaoGeralQueixa(10, 300), SituacaoGeralQueixas.BOM);
	}

	@Test
	public void calculaSituacaoNormalTest() {
		PrefeituraSituacao situacaoNormal = new PrefeituraNormal();
		prefeitura.setSituacaoPrefeitura(situacaoNormal);
		assertEquals(prefeitura.calculaSituacaoGeralQueixa(2, 9), SituacaoGeralQueixas.RUIM);
		assertEquals(prefeitura.calculaSituacaoGeralQueixa(2, 12), SituacaoGeralQueixas.REGULAR);
		assertEquals(prefeitura.calculaSituacaoGeralQueixa(2, 23), SituacaoGeralQueixas.BOM);
	}
	
}
