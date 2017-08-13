package com.ufcg.si1.controller;

import java.util.List;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ufcg.si1.model.Especialidade;
import com.ufcg.si1.model.UnidadeSaude;
import com.ufcg.si1.service.UnidadeSaudeService;
import com.ufcg.si1.util.Util;
import exceptions.IdInexistenteException;


@RestController
@RequestMapping(Util.ROTA_API)
@CrossOrigin
public class UnidadeSaudeController {

	@Autowired
	UnidadeSaudeService unidadeSaudeService;
	
	public UnidadeSaudeController(UnidadeSaudeService unidadeSaudeService){
		this.unidadeSaudeService = unidadeSaudeService;
	}
	
	@RequestMapping(value = Util.ROTA_UNIDADE, method = RequestMethod.GET)
    public ResponseEntity<?> getAllUnidades() {
        List<UnidadeSaude> unidadesSaude = unidadeSaudeService.getAllUnidadesSaude();
        if (unidadesSaude.isEmpty()) {
        	return new ResponseEntity<List<UnidadeSaude>>(HttpStatus.NOT_FOUND);	
        } else{
            return new ResponseEntity<>(unidadesSaude, HttpStatus.OK);
        }
    }
	
	@RequestMapping(value = Util.ROTA_UNIDADE, method = RequestMethod.POST)
    public ResponseEntity<UnidadeSaude> incluirUnidadeSaude(@RequestBody UnidadeSaude unidadeSaude, UriComponentsBuilder ucBuilder) {
        UnidadeSaude unidadeSaudeAdicionada = unidadeSaudeService.insere(unidadeSaude);
        return new ResponseEntity<UnidadeSaude>(unidadeSaudeAdicionada, HttpStatus.CREATED);
    }
	
	@RequestMapping(value = Util.ROTA_CONSULTAR_UNIDADE_SAUDE_POR_BAIRRO, method= RequestMethod.GET)
	public ResponseEntity<UnidadeSaude> consultarUnidadeSaudePorBairro(@PathVariable("bairro")String bairro){
		UnidadeSaude unidadeSaudeEncontrada = unidadeSaudeService.getUnidadeSaude(bairro);
		return new ResponseEntity<UnidadeSaude>(unidadeSaudeEncontrada, HttpStatus.OK);
	}
	
	@RequestMapping(value = Util.ROTA_CONSULTAR_UNIDADE_SAUDE, method = RequestMethod.GET)
	public ResponseEntity<?> consultarUnidadeSaude(@PathVariable("id") long id) {

		try {
			UnidadeSaude unidadeSaude = unidadeSaudeService.encontraPorId(id);
			return new ResponseEntity<>(unidadeSaude, HttpStatus.OK);
		} catch (IdInexistenteException e) {
			return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
		}
	       
	}
	
	
	@RequestMapping(value = Util.ROTA_CONSULTAR_ESPECIALIDADE_POR_UNIDADE_SAUDE, method = RequestMethod.GET)
    public ResponseEntity<?> consultaEspecialidadeporUnidadeSaude(@RequestBody Long id) {
      Set<Especialidade> especialidades;
	try {
		especialidades = unidadeSaudeService.getEspecialidades(id);
		return new ResponseEntity<>(especialidades, HttpStatus.OK);
	} catch (IdInexistenteException e) {
		return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
	}
      
    }
	
	
	/*@RequestMapping(value = "/geral/medicos/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> calcularMediaMedicoPacienteDia(@PathVariable("id") long id) {
		try {
			Object unidade = unidadeSaudeService.encontraPorId(id);
			if(unidade == null){
	            return new ResponseEntity<ObjWrapper<Double>>(HttpStatus.NOT_FOUND);
	        }

	        double c = 0.0;
	        if (unidade instanceof PostoSaude)
	            c = ((PostoSaude) unidade).getAtendentes()
	                    / ((PostoSaude) unidade).taxaDiaria();
	        else if (unidade instanceof Hospital){
	            c = ((Hospital) unidade).getNumeroMedicos()
	                    / ((Hospital) unidade).getNumeroPacientesDia();
	        }
	        return new ResponseEntity<ObjWrapper<Double>>(new ObjWrapper<Double>(new Double(c)), HttpStatus.OK);
		} catch (IdInexistenteException e) {
			return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
		}*/
        

        
    //}
	
	
}
