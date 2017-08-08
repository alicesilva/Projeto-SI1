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

import com.ufcg.si1.model.Especialidade;
import com.ufcg.si1.service.EspecialidadeService;

import exceptions.IdInexistenteException;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EspecialidadeController {

	@Autowired
	EspecialidadeService especialidadeService;

	public EspecialidadeController(EspecialidadeService especialidadeService) {
		this.especialidadeService = especialidadeService;
	}

	@RequestMapping(value = "/especialidade/", method = RequestMethod.POST)
	public ResponseEntity<Especialidade> addEspecialidade(@RequestBody Especialidade esp) {
		Especialidade especialidadeAdicionada = especialidadeService.addEspecialidade(esp);
		return new ResponseEntity<Especialidade>(especialidadeAdicionada, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/especialidade/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> consultarEspecialidade(@PathVariable("id") Long id) {
		try {
			Especialidade especialidadeEncontrada = especialidadeService.getEspecialidade(id);
			return new ResponseEntity<Especialidade>(especialidadeEncontrada, HttpStatus.OK);
		} catch (IdInexistenteException e) {
			return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
		}

	}

}
