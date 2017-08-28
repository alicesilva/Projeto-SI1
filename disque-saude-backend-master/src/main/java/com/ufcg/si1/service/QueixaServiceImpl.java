package com.ufcg.si1.service;

import com.ufcg.si1.model.queixa.Queixa;
import com.ufcg.si1.repository.QueixaRepository;
import exceptions.AcaoNaoPermitidaException;
import exceptions.EntradaException;
import exceptions.IdInexistenteException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueixaServiceImpl implements QueixaService {

	@Autowired
	QueixaRepository queixaRepository;

	public QueixaServiceImpl(QueixaRepository queixaRepository) {
		this.queixaRepository = queixaRepository;
	}

	@Override
	public Queixa addQueixa(Queixa queixa) throws AcaoNaoPermitidaException {
		if(queixa == null){
			throw new AcaoNaoPermitidaException("Impossivel registrar queixa");
			
		}else{
			queixa.abrir();
			return queixaRepository.save(queixa);
		}
	}

	public Queixa getQueixaId(Long id) throws IdInexistenteException {

		if (id < 0 || id == null) {
			throw new IdInexistenteException("Id inexistente");
		}

		Queixa queixaEncontrada = queixaRepository.findOne(id);

		if (queixaEncontrada == null) {
			throw new IdInexistenteException("Não há nenhuma queixa com o id " + id);
		}

		return queixaEncontrada;
	}

	@Override
	public Queixa addComentarioNaQueixa(Long id, String comentario) throws EntradaException{
		if(id < 0 || id == null || comentario == "" || comentario == null){
			throw new EntradaException("Erro ao adicionar comentário");
		}
		
		Queixa queixaEncontrada = queixaRepository.findOne(id);
		queixaEncontrada.setComentario(comentario);
		return queixaRepository.save(queixaEncontrada);
		
	}

	@Override
	public Queixa modificaStatusDaQueixa(Long id, String status) throws EntradaException, AcaoNaoPermitidaException {
		if(id < 0 || id == null || status == "" || status == null){
			throw new EntradaException("Erro ao modificar status da queixa");
		}
		Queixa queixaEncontrada = queixaRepository.findOne(id);
		if(status.equals("ABERTA")){
			queixaEncontrada.abrir();
		}else if(status.equals("ANDAMENTO")){
			queixaEncontrada.resolver();
		}else{
			queixaEncontrada.fechar();
		}
		
		return queixaRepository.save(queixaEncontrada);
	}
}
