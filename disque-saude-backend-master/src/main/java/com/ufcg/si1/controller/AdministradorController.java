package com.ufcg.si1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ufcg.si1.model.especialidade.Especialidade;
import com.ufcg.si1.model.prefeitura.Prefeitura;
import com.ufcg.si1.model.prefeitura.SituacaoGeralQueixas;
import com.ufcg.si1.model.queixa.Queixa;
import com.ufcg.si1.model.unidadeSaude.UnidadeSaude;
import com.ufcg.si1.service.AdministradorService;
import com.ufcg.si1.service.EspecialidadeService;
import com.ufcg.si1.service.PrefeituraService;
import com.ufcg.si1.service.QueixaService;
import com.ufcg.si1.service.UnidadeSaudeService;

import exceptions.AcaoNaoPermitidaException;
import exceptions.EntradaException;

@RestController
@CrossOrigin
public class AdministradorController {
	
	@Autowired
	AdministradorService administradorService;
	
	@Autowired
	PrefeituraService prefeituraService;
	
	@Autowired
	QueixaService queixaService;
	
	@Autowired
	UnidadeSaudeService unidadeSaudeService;
	
	@Autowired
	EspecialidadeService especialidadeService;
	
	@RequestMapping(value = "/queixa/situacao", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SituacaoGeralQueixas> getSituacaoGeralQueixas() {
		try {
			SituacaoGeralQueixas situacao = prefeituraService.getSituacaoGeralQueixa();
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
	
	
	@RequestMapping(value = "/queixa/comentario/{id}", method = RequestMethod.POST)
	public ResponseEntity<Queixa> addComentarioNaQueixa(@PathVariable("id")Long id, @RequestBody String comentario){
		try {
			Queixa queixaModificada = queixaService.addComentarioNaQueixa(id, comentario);
			return new ResponseEntity<Queixa>(queixaModificada, HttpStatus.OK);
		} catch (EntradaException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	@RequestMapping(value = "/queixa/status/{id}", method = RequestMethod.POST)
	public ResponseEntity<Queixa> modificaStatusDaQueixa(@PathVariable("id") Long id, @RequestBody String status){
		try {
			Queixa queixaModificada = queixaService.modificaStatusDaQueixa(id, status);
			return new ResponseEntity<>(queixaModificada, HttpStatus.OK);
		} catch (AcaoNaoPermitidaException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (EntradaException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@RequestMapping(value = "/modifica/status/", method = RequestMethod.POST)
	public ResponseEntity<Prefeitura> modificaSituacaoPrefeitura(@RequestBody String situacao){
		Prefeitura prefeituraModificada = prefeituraService.modificaStatus(situacao);
		return new ResponseEntity<Prefeitura>(prefeituraModificada, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "/unidade/", method = RequestMethod.POST)
	public ResponseEntity<UnidadeSaude> adicionaUnidadeDeSaude(@RequestBody UnidadeSaude unidadeSaude){
		UnidadeSaude unidadeSaudeAdicionada;
		try {
			unidadeSaudeAdicionada = unidadeSaudeService.addUnidadeSaude(unidadeSaude);
			return new ResponseEntity<UnidadeSaude>(unidadeSaudeAdicionada, HttpStatus.CREATED);
		} catch (EntradaException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/unidade/{bairro}", method = RequestMethod.GET)
	public ResponseEntity<Float> getMediaMedicoPaciente(@PathVariable("bairro") String bairro){
		Float taxa;
		try {
			taxa = unidadeSaudeService.getMediaMedicoPorPaciente(bairro);
			return new ResponseEntity<Float>(taxa, HttpStatus.OK);
		} catch (AcaoNaoPermitidaException | EntradaException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	@RequestMapping(value = "/especialidade/", method = RequestMethod.POST)
	public ResponseEntity<Especialidade> addEspecialidade(@RequestBody Especialidade especialidade){
		Especialidade especialidadeAdicionada;
		try {
			especialidadeAdicionada = especialidadeService.addEspecialidade(especialidade);
			return new ResponseEntity<Especialidade>(especialidadeAdicionada, HttpStatus.CREATED);
		} catch (EntradaException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}
}
