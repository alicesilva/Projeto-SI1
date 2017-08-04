package com.ufcg.si1.controller;

import java.util.Iterator;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ufcg.si1.model.Queixa;
import com.ufcg.si1.service.QueixaService;
import com.ufcg.si1.service.QueixaServiceImpl;
import com.ufcg.si1.util.CustomErrorType;
import com.ufcg.si1.util.ObjWrapper;

import exceptions.ObjetoInvalidoException;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class QueixaController {

	QueixaService queixaService = new QueixaServiceImpl();

	@RequestMapping(value = "/queixa/", method = RequestMethod.GET)
	public ResponseEntity<List<Queixa>> listAllQueixas() {
		List<Queixa> queixas = queixaService.findAllQueixas();

		if (queixas.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Queixa>>(queixas, HttpStatus.OK);
	}

	@RequestMapping(value = "/queixa/", method = RequestMethod.POST)
	public ResponseEntity<?> abrirQueixa(@RequestBody Queixa queixa) {

		try {
			queixa.abrir();
		} catch (ObjetoInvalidoException e) {
			return new ResponseEntity<List>(HttpStatus.BAD_REQUEST);
		}
		queixaService.saveQueixa(queixa);
		return new ResponseEntity<Queixa>(queixa, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/queixa/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> consultarQueixa(@PathVariable("id") Integer id) {

		Queixa queixaEncontrada = queixaService.findById(id);
		if (queixaEncontrada == null) {
			return new ResponseEntity<>(new CustomErrorType("Queixa with id " + id + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Queixa>(queixaEncontrada, HttpStatus.OK);
	}

	@RequestMapping(value = "/queixa/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> atualizaQueixa(@PathVariable("id") Integer id, @RequestBody Queixa queixa) {
		try {
			queixaService.atualizaQueixa(id, queixa);
		} catch (Exception e) {
			return new ResponseEntity<>(new CustomErrorType("Queixa com id " + id + " não encontrada"),
					HttpStatus.NOT_FOUND);
		}
		
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/queixa/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> excluiQueixa(@PathVariable("id") Integer id) {
		try {
			queixaService.excluiQueixaPorId(id);
			} catch (Exception e) {
			return new ResponseEntity<>(new CustomErrorType("Não é possível excluir. Queixa com id " + id + " não encontrada."),
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Queixa>(HttpStatus.OK);

	}
	
    @RequestMapping(value = "/queixa/fechamento", method = RequestMethod.POST)
    public ResponseEntity<?> fecharQueixa(@RequestBody Queixa queixaAFechar) {
    	long id = queixaAFechar.getId();
        try {
			queixaService.fecharQueixa(queixaAFechar);
		} catch (Exception e) {
			return new ResponseEntity<>(new CustomErrorType("Não é possível fechar. Queixa com id " + id + " não encontrada."),
					HttpStatus.NOT_FOUND);
		}
        
		return new ResponseEntity<Queixa>(queixaAFechar, HttpStatus.OK);

    }
    
    @RequestMapping(value = "/geral/situacao", method = RequestMethod.GET)
    public ResponseEntity<?> getSituacaoGeralQueixas() {

        // dependendo da situacao da prefeitura, o criterio de avaliacao muda
        // se normal, mais de 20% abertas eh ruim, mais de 10 eh regular
        // se extra, mais de 10% abertas eh ruim, mais de 5% eh regular
        
    	Integer situacao = queixaService.getSituacaoGeralQueixas();
    	
        //situacao retornada
        //0: RUIM
        //1: REGULAR
        //2: BOM
        return new ResponseEntity<ObjWrapper<Integer>>(new ObjWrapper<Integer>(situacao), HttpStatus.OK);
    }

}
