package com.ufcg.si1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ufcg.si1.model.Queixa;
import com.ufcg.si1.service.QueixaService;
import com.ufcg.si1.util.ObjWrapper;
import com.ufcg.si1.util.Util;

import exceptions.AcaoNaoPermitidaException;
import exceptions.IdInexistenteException;

@RestController
@RequestMapping(Util.ROTA_API)
@CrossOrigin
public class QueixaController {

	@Autowired
	QueixaService queixaService;

	public QueixaController(QueixaService queixaService) {
		this.queixaService = queixaService;

	}

	@RequestMapping(value = Util.ROTA_QUEIXA, method = RequestMethod.GET)
	public ResponseEntity<List<Queixa>> listAllQueixas() {
		List<Queixa> queixas = queixaService.findAllQueixas();

		if (queixas.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Queixa>>(queixas, HttpStatus.OK);
	}

	@RequestMapping(value = Util.ROTA_QUEIXA, method = RequestMethod.POST)
	public ResponseEntity<?> abrirQueixa(@RequestBody Queixa queixa) {

		try {
			queixaService.saveQueixa(queixa);
			return new ResponseEntity<Queixa>(queixa, HttpStatus.CREATED);
		} catch (AcaoNaoPermitidaException e) {
			return new ResponseEntity<List>(HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = Util.ROTA_CONSULTAR_QUEIXA_POR_ID, method = RequestMethod.GET)
	public ResponseEntity<?> consultarQueixa(@PathVariable("id") Long id) {
		try {
			Queixa queixaEncontrada = queixaService.encontraPorId(id);
			return new ResponseEntity<Queixa>(queixaEncontrada, HttpStatus.OK);
		} catch (IdInexistenteException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = Util.ROTA_ATUALIZAR_QUEIXA_POR_ID, method = RequestMethod.PUT)
	public ResponseEntity<?> atualizarQueixa(@PathVariable("id") Long id, @RequestBody Queixa queixa) {
		try {
			queixaService.atualizaQueixa(id, queixa);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (IdInexistenteException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = Util.ROTA_EXCLUIR_QUEIXA_POR_ID, method = RequestMethod.DELETE)
	public ResponseEntity<?> excluiQueixa(@PathVariable("id") Long id) {
		try {
			queixaService.excluiQueixaPorId(id);
			return new ResponseEntity<Queixa>(HttpStatus.OK);
		} catch (IdInexistenteException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = Util.ROTA_FECHAR_QUEIXA, method = RequestMethod.POST)
	public ResponseEntity<?> fecharQueixa(@RequestBody Queixa queixaAFechar) {
		long id = queixaAFechar.getId();
		try {
			queixaService.fecharQueixa(queixaAFechar);
		} catch (IdInexistenteException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Queixa>(queixaAFechar, HttpStatus.OK);

	}

	@RequestMapping(value = Util.ROTA_SITUACAO_GERAL_QUEIXAS, method = RequestMethod.GET)
	public ResponseEntity<?> getSituacaoGeralQueixas() {

		// dependendo da situacao da prefeitura, o criterio de avaliacao muda
		// se normal, mais de 20% abertas eh ruim, mais de 10 eh regular
		// se extra, mais de 10% abertas eh ruim, mais de 5% eh regular

		Integer situacao = queixaService.getSituacaoGeralQueixas();

		// situacao retornada
		// 0: RUIM
		// 1: REGULAR
		// 2: BOM
		return new ResponseEntity<ObjWrapper<Integer>>(new ObjWrapper<Integer>(situacao), HttpStatus.OK);
	}

}
