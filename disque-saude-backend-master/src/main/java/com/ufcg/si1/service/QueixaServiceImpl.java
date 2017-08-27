package com.ufcg.si1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.si1.model.queixa.Queixa;
import com.ufcg.si1.repository.QueixaRepository;

import exceptions.AcaoNaoPermitidaException;
import exceptions.IdInexistenteException;

@Service
public class QueixaServiceImpl implements QueixaService {

	@Autowired
	QueixaRepository queixaRepository;

	public QueixaServiceImpl(QueixaRepository queixaRepository) {
		this.queixaRepository = queixaRepository;
	}

	@Override
	public Queixa salvarQueixa(Queixa queixa) throws AcaoNaoPermitidaException {
		if(queixa == null){
			throw new AcaoNaoPermitidaException("Impossivel registrar queixa");
			
		}else{
			queixa.abrir();
			queixaRepository.save(queixa);
			return queixa;
		}
	}

	public Queixa getQueixaPorId(Long id) throws IdInexistenteException {

		if (id < 0) {
			throw new IdInexistenteException("Id inexistente");
		}

		Queixa queixaEncontrada = queixaRepository.findOne(id);

		if (queixaEncontrada == null) {
			throw new IdInexistenteException("Não há nenhuma queixa com o id " + id);
		}

		return queixaEncontrada;
	}

	@Override
	public Queixa addComentarioNaQueixa(Long id, String comentario) {

		Queixa queixa = queixaRepository.findOne(id);
		queixa.setComentario(comentario);
		queixaRepository.save(queixa);
		
		return queixa;
		
	}

	@Override
	public Queixa modificaStatusDaQueixa(Long id, String status) throws AcaoNaoPermitidaException {
		Queixa queixaEncontrada = queixaRepository.findOne(id);
		if(status.equals("Abrir")){
			queixaEncontrada.abrir();
		}else if(status.equals("Resolver")){
			queixaEncontrada.resolver();
		}else{
			queixaEncontrada.fechar();
		}
		
		queixaRepository.save(queixaEncontrada);
		
		return queixaEncontrada;
	}
}
