package com.ufcg.si1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ufcg.si1.model.adm.Administrador;
import com.ufcg.si1.service.AdministradorService;

import exceptions.AcaoNaoPermitidaException;

@RestController
@CrossOrigin
@RequestMapping(value = "/cadastro/")
public class CadastroController {
	
	@Autowired
	AdministradorService admService;
	

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Administrador> cadastroAdministrador(@RequestBody Administrador administrador){
		try {
			Administrador admnistradorCadastrado = admService.cadastraAdministrador(administrador);
			return new ResponseEntity<>(admnistradorCadastrado, HttpStatus.CREATED);
		} catch (AcaoNaoPermitidaException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
		}
	}

}
