package com.ufcg.si1.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.si1.model.prefeitura.Prefeitura;
import com.ufcg.si1.model.prefeitura.PrefeituraCaos;
import com.ufcg.si1.model.prefeitura.PrefeituraExtra;
import com.ufcg.si1.model.prefeitura.PrefeituraNormal;
import com.ufcg.si1.model.prefeitura.SituacaoGeralQueixas;
import com.ufcg.si1.model.queixa.Queixa;
import com.ufcg.si1.model.queixa.QueixaStatusEnum;
import com.ufcg.si1.repository.PrefeituraRepository;
import com.ufcg.si1.repository.QueixaRepository;

import exceptions.AcaoNaoPermitidaException;

@Service
public class PrefeituraServiceImpl implements PrefeituraService{
	
	@Autowired
	QueixaRepository queixaRepository;
	
	@Autowired
	PrefeituraRepository prefeituraRepository;
	
	Prefeitura prefeitura;
	
	@PostConstruct
	public void initPrefeitura(){
		prefeitura = new Prefeitura();
		prefeitura.setSituacaoPrefeitura(new PrefeituraNormal());
		prefeituraRepository.save(prefeitura);
	}
	
	public SituacaoGeralQueixas getSituacaoGeralQueixa()throws AcaoNaoPermitidaException{
		int qtdQueixasTotal = (int) queixaRepository.count();
		double qtdQueixasAbertas = (double)qtdQueixaAbertas();
		
		if(qtdQueixasTotal == 0){
			throw new AcaoNaoPermitidaException("O sistema não possui nenhuma queixa registrada!");
		}
		return prefeitura.calculaSituacaoGeralQueixa(qtdQueixasAbertas, qtdQueixasTotal);
	}
	
	public int qtdQueixaAbertas(){
		int count = 0;
		List<Queixa> queixas = queixaRepository.findAll();
		for(int i = 0; i < queixas.size(); i ++){
			if(queixas.get(i).getStatus().tipoQueixa().equals(QueixaStatusEnum.ABERTA)){
				count ++;
			}
		}
		return count;
	}
	
	public List<Queixa> getQueixas(){
		return queixaRepository.findAll();
	}
	
	
	public Prefeitura modificaStatus(String situacao) {
		if(situacao.equals("Normal")){
			prefeitura.setSituacaoPrefeitura(new PrefeituraNormal());
		}else if(situacao.equals("Extra")){
			prefeitura.setSituacaoPrefeitura(new PrefeituraExtra());
			
		}else{
			prefeitura.setSituacaoPrefeitura(new PrefeituraCaos());
		}
		
		prefeituraRepository.save(prefeitura);
		
		return this.prefeitura;
	}

}
