package com.ufcg.si1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ufcg.si1.model.unidadeSaude.UnidadeSaude;
import com.ufcg.si1.service.UnidadeSaudeService;
import exceptions.EntradaException;


@RestController
@RequestMapping("/unidade/")
@CrossOrigin
public class UnidadeSaudeController {

	@Autowired
	UnidadeSaudeService unidadeSaudeService;
	
	public UnidadeSaudeController(UnidadeSaudeService unidadeSaudeService){
		this.unidadeSaudeService = unidadeSaudeService;
	}
	
	@RequestMapping(value = "busca/{bairro}" , method= RequestMethod.GET)
	public ResponseEntity<UnidadeSaude> pesquisaUnidadeSaudePorBairro(@PathVariable("bairro")String bairro){
		UnidadeSaude unidadeSaudeEncontrada;
		try {
			unidadeSaudeEncontrada = unidadeSaudeService.getUnidadeSaude(bairro);
			return new ResponseEntity<UnidadeSaude>(unidadeSaudeEncontrada, HttpStatus.OK);
		} catch (EntradaException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
