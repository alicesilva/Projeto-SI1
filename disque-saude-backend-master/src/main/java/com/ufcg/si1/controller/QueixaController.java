package com.ufcg.si1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
public class QueixaController {

	@Autowired
	QueixaService queixaService;

	public QueixaController(QueixaService queixaService) {
		this.queixaService = queixaService;
	}

	
	@RequestMapping(value = "/queixa/", method = RequestMethod.POST)
	public ResponseEntity<Queixa> registrarQueixa(@RequestBody Queixa queixa) {

		try {
			Queixa queixaRegistrada = queixaService.salvarQueixa(queixa);
			return new ResponseEntity<>(queixaRegistrada, HttpStatus.CREATED);
		} catch (AcaoNaoPermitidaException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
	
	@RequestMapping(value = "/queixa/{id}", method = RequestMethod.GET)
	public ResponseEntity<Queixa> consultarQueixa(@PathVariable("id") Long id) {
		try {
			Queixa queixaEncontrada = queixaService.getQueixaPorId(id);
			return new ResponseEntity<>(queixaEncontrada, HttpStatus.OK);
		} catch (IdInexistenteException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

}
