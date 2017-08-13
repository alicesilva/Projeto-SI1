package com.ufcg.si1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ufcg.si1.model.prefeitura.SituacaoGeralQueixas;
import com.ufcg.si1.service.AdministradorService;
import com.ufcg.si1.service.PrefeituraService;
import com.ufcg.si1.util.ObjWrapper;
import com.ufcg.si1.util.Util;

import exceptions.AcaoNaoPermitidaException;

@RestController
@CrossOrigin
public class AdministradorController {
	
	@Autowired
	AdministradorService administradorService;
	
	@Autowired
	PrefeituraService prefeituraService;
	
	@RequestMapping(value = "/geral/situacao", method = RequestMethod.GET)
	public ResponseEntity<SituacaoGeralQueixas> getSituacaoGeralQueixas() {
		SituacaoGeralQueixas situacao;
		try {
			situacao = prefeituraService.getSituacaoGeralQueixa();
			return new ResponseEntity<>(situacao, HttpStatus.OK);
		} catch (AcaoNaoPermitidaException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	


}
