package com.ufcg.si1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ufcg.si1.model.UnidadeSaude;
import com.ufcg.si1.service.UnidadeSaudeService;
import com.ufcg.si1.service.UnidadeSaudeServiceImpl;
import com.ufcg.si1.util.CustomErrorType;

import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class UnidadeController {
	
	private static final String UNIDADEBAIRRO = "Unidade do bairro ";
	private static final String NAOENCONTRADO = " not found";
	private static final String UNIDADEID = "Unidade with id ";

	UnidadeSaudeService unidadeSaudeService = new UnidadeSaudeServiceImpl();
	
	@RequestMapping(value = "/unidade/", method = RequestMethod.GET)
    public ResponseEntity<?> getAllUnidades() {
        List<Object> unidades = unidadeSaudeService.getAll();
        if (unidades.isEmpty()) {
        	return new ResponseEntity<List>(HttpStatus.NOT_FOUND);
        	
        } else{
            List<UnidadeSaude> unidadeSaudes = new ArrayList<>();
            for (Object  saude: unidades) {
                if(saude instanceof UnidadeSaude) {
                    unidadeSaudes.add((UnidadeSaude) saude);
                }
            }
            return new ResponseEntity<>(unidadeSaudes, HttpStatus.OK);
        }
    }
	
	@RequestMapping(value = "/unidade/", method = RequestMethod.POST)
    public ResponseEntity<String> incluirUnidadeSaude(@RequestBody UnidadeSaude unidadeSaude, UriComponentsBuilder ucBuilder) {

        try {
            unidadeSaudeService.insere(unidadeSaude);
        } catch (Rep e) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        } catch (ObjetoJaExistenteException e) {
            return new ResponseEntity<String>(HttpStatus.CONFLICT);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/unidade/{id}").buildAndExpand(unidadeSaude.pegaCodigo()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
	
	@RequestMapping(value="/unidade/busca", method= RequestMethod.GET)
	public ResponseEntity<?> consultarUnidadeSaudePorBairro(@RequestParam(value = "bairro", required = true) String bairro){
	        Object unidadeProcurada = unidadeSaudeService.findByBairro(bairro);
	        
	        if (unidadeProcurada == null && !(unidadeProcurada instanceof UnidadeSaude)) {
	            return new ResponseEntity(new CustomErrorType(UNIDADEBAIRRO + bairro
	                    + NAOENCONTRADO), HttpStatus.NOT_FOUND);
	        }

	        return new ResponseEntity<UnidadeSaude>((UnidadeSaude) unidadeProcurada, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/unidade/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> consultarUnidadeSaude(@PathVariable("id") long id) {

	        Object unidadeSaude = unidadeSaudeService.findById(id);
	        if (unidadeSaude == null) {
	            return new ResponseEntity(new CustomErrorType(UNIDADEID + id
	                    + NAOENCONTRADO), HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<>(unidadeSaude, HttpStatus.OK);
	    }
	
	
}
