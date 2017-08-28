package com.ufcg.si1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ufcg.si1.model.queixa.Queixa;
import com.ufcg.si1.service.QueixaService;
import exceptions.AcaoNaoPermitidaException;
import exceptions.IdInexistenteException;

@RestController
@CrossOrigin
@RequestMapping(value = "/queixa/")
public class QueixaController {

	@Autowired
	QueixaService queixaService;

	public QueixaController(QueixaService queixaService) {
		this.queixaService = queixaService;
	}

	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Queixa> registrarQueixa(@RequestBody Queixa queixa) {

		try {
			Queixa queixaRegistrada = queixaService.addQueixa(queixa);
			return new ResponseEntity<>(queixaRegistrada, HttpStatus.CREATED);
		} catch (AcaoNaoPermitidaException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Queixa> consultarQueixa(@PathVariable("id") Long id) {
		try {
			Queixa queixaEncontrada = queixaService.getQueixaId(id);
			return new ResponseEntity<>(queixaEncontrada, HttpStatus.OK);
		} catch (IdInexistenteException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
}
