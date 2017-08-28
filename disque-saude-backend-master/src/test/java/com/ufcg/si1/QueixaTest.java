package com.ufcg.si1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ufcg.si1.model.Endereco;
import com.ufcg.si1.model.queixa.Queixa;
import com.ufcg.si1.model.queixa.QueixaAberta;
import com.ufcg.si1.model.queixa.QueixaAlimentar;
import com.ufcg.si1.model.queixa.QueixaAndamento;
import com.ufcg.si1.model.queixa.QueixaAnimalPerdido;
import com.ufcg.si1.model.queixa.QueixaFechada;
import com.ufcg.si1.model.queixa.QueixaStatus;

import exceptions.AcaoNaoPermitidaException;

public class QueixaTest {
	
	private Queixa queixaAnimal1;
	private Queixa queixaAnimal2;
	private Queixa queixaAlimentar1;
	private Queixa queixaAlimentar2;
	private QueixaStatus aberta;
	private QueixaStatus andamento;
	private QueixaStatus fechada;
	private Endereco endereco1;
	private Endereco endereco2;

	@Before
	public void setUp() {
		aberta = new QueixaAberta();
		andamento = new QueixaAndamento();
		fechada = new QueixaFechada();
		
		endereco1 = new Endereco("florida", "PB", "Campina Grande");
		endereco2 = new Endereco("carrossel", "PB", "Campina Grande");
		
		queixaAnimal1 = new QueixaAnimalPerdido((long) 1, "encontrei um cachorro ferido", "", "jose",
				"jose.carlos@hotmail.com", aberta, endereco1, "cachorro");
		queixaAnimal2 = new QueixaAnimalPerdido((long) 2, "encontrei um gato ferido", "", "maria",
				"maria.henriques@hotmail.com", andamento, endereco2, "gato");
		queixaAlimentar1 = new QueixaAlimentar((long) 3, "estou com muita dor de barriga", "", "gabriel",
				"gabriel.coutinho@ccc.ufcg.edu.br", "vicente", "SP", "Araraquara", fechada);
		queixaAlimentar2 = new QueixaAlimentar((long) 4, "estou vomitando", "", "gabriel",
				"gabriel.alves@ccc.ufcg.edu.br", "walls", "SP", "Araraquara", aberta);

	}

	@Test
	public void abrirQueixaTest() {
		try {
			queixaAnimal1.abrir();
			fail();
		} catch (AcaoNaoPermitidaException e) {
			assertEquals(e.getMessage(), "Queixa já esta aberta");
		}
		
		try {
			queixaAnimal2.abrir();
			fail();
		} catch (AcaoNaoPermitidaException e) {
			assertEquals(e.getMessage(), "Queixa já foi aberta");
		}
		
		try {
			queixaAlimentar1.abrir();
			fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Queixa já foi fechada");
		}
		
		try {
			queixaAlimentar2.abrir();
			fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Queixa já esta aberta");
		}
	}
	
	
	@Test
	public void resolverQueixaTest() {
		try {
			queixaAnimal1.resolver();
			assertTrue(queixaAnimal1.getStatus() instanceof QueixaAndamento); 
		} catch (AcaoNaoPermitidaException e) {
			fail();
		}
		
		try {
			queixaAnimal2.resolver();
			fail();
		} catch (AcaoNaoPermitidaException e) {
			assertEquals(e.getMessage(), "Queixa já está em andamento");
		}
		
		try {
			queixaAlimentar1.resolver();
			fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Queixa já foi fechada");
		}
		
		try {
			queixaAlimentar2.resolver();
			assertTrue(queixaAnimal1.getStatus() instanceof QueixaAndamento); 
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void fecharQueixaTest() {
		try {
			queixaAnimal1.fechar();
			assertTrue(queixaAnimal1.getStatus() instanceof QueixaFechada); 
		} catch (AcaoNaoPermitidaException e) {
			fail();
		}
		
		try {
			queixaAnimal2.fechar();
			assertTrue(queixaAnimal1.getStatus() instanceof QueixaFechada); 
		} catch (AcaoNaoPermitidaException e) {
			fail();
		}
		
		try {
			queixaAlimentar1.fechar();
			fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Queixa já foi fechada");
		}
		
		try {
			queixaAlimentar2.fechar();
			assertTrue(queixaAnimal1.getStatus() instanceof QueixaFechada); 
		} catch (Exception e) {
			fail();
		}
	}
	

}
