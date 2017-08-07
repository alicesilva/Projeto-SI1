package com.ufcg.si1.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.ufcg.si1.model.Especialidade;
import com.ufcg.si1.model.PostoSaude;
import com.ufcg.si1.model.UnidadeSaude;
import com.ufcg.si1.service.QueixaService;
import com.ufcg.si1.service.UnidadeSaudeService;
import com.ufcg.si1.service.UnidadeSaudeServiceImpl;
import com.ufcg.si1.util.CustomErrorType;
import com.ufcg.si1.util.ObjWrapper;

import br.edu.ufcg.Hospital;
import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class UnidadeSaudeController {
	
	private static final String UNIDADEBAIRRO = "Unidade do bairro ";
	private static final String NAOENCONTRADO = " not found";
	private static final String UNIDADEID = "Unidade with id ";

	@Autowired
	UnidadeSaudeService unidadeSaudeService;
	
	public UnidadeSaudeController(UnidadeSaudeService unidadeSaudeService){
		this.unidadeSaudeService = unidadeSaudeService;
	}
	
	@RequestMapping(value = "/unidade/", method = RequestMethod.GET)
    public ResponseEntity<?> getAllUnidades() {
        List<UnidadeSaude> unidadesSaude = unidadeSaudeService.getAllUnidadesSaude();
        if (unidadesSaude.isEmpty()) {
        	return new ResponseEntity<List<UnidadeSaude>>(HttpStatus.NOT_FOUND);	
        } else{
            return new ResponseEntity<>(unidadesSaude, HttpStatus.OK);
        }
    }
	
	@RequestMapping(value = "/unidade/", method = RequestMethod.POST)
    public ResponseEntity<UnidadeSaude> incluirUnidadeSaude(@RequestBody UnidadeSaude unidadeSaude, UriComponentsBuilder ucBuilder) {
        UnidadeSaude unidadeSaudeAdicionada = unidadeSaudeService.insere(unidadeSaude);
        return new ResponseEntity<UnidadeSaude>(unidadeSaudeAdicionada, HttpStatus.CREATED);
    }
	
	@RequestMapping(value="/unidade/busca", method= RequestMethod.GET)
	public void consultarUnidadeSaudePorBairro(@RequestParam(value = "bairro", required = true) String bairro){
	}
	
	@RequestMapping(value = "/unidade/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> consultarUnidadeSaude(@PathVariable("id") long id) {

	        UnidadeSaude unidadeSaude = unidadeSaudeService.findById(id);
	        if (unidadeSaude == null) {
	            return new ResponseEntity<>(new CustomErrorType(UNIDADEID + id
	                    + NAOENCONTRADO), HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<>(unidadeSaude, HttpStatus.OK);
	    }
	
	
	@RequestMapping(value = "/especialidade/unidades", method = RequestMethod.GET)
    public ResponseEntity<Set<Especialidade>> consultaEspecialidadeporUnidadeSaude(@RequestBody Long id) {
      Set<Especialidade> especialidades = unidadeSaudeService.getEspecialidades(id);
      return new ResponseEntity<>(especialidades, HttpStatus.OK);
    }
	
	
	@RequestMapping(value = "/geral/medicos/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> calcularMediaMedicoPacienteDia(@PathVariable("id") long id) {

        Object unidade = unidadeSaudeService.findById(id);

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
    }
	
	
}
