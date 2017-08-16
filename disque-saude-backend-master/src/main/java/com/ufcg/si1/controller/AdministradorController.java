package com.ufcg.si1.controller;

import java.util.List;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ufcg.si1.model.prefeitura.SituacaoGeralQueixas;
import com.ufcg.si1.model.queixa.Queixa;
import com.ufcg.si1.service.AdministradorService;
import com.ufcg.si1.service.PrefeituraService;
import com.ufcg.si1.service.QueixaService;


import exceptions.AcaoNaoPermitidaException;

@RestController
@CrossOrigin
public class AdministradorController {
	
	@Autowired
	AdministradorService administradorService;
	
	@Autowired
	PrefeituraService prefeituraService;
	
	@Autowired
	QueixaService queixaService;
	
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
	
	@RequestMapping(value = "/queixas/", method = RequestMethod.GET)
	public ResponseEntity<List<Queixa>> queixas() {
		List<Queixa> queixas = prefeituraService.getQueixas();
		return new ResponseEntity<List<Queixa>>(queixas, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/queixasComentario/", method = RequestMethod.POST)
	public void addComentarioNaQueixa(@RequestBody Queixa queixa ){
		System.out.println("Chamou aqui");
	}
	
	
	
	


}
