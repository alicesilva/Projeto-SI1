package com.ufcg.si1.service;

import com.ufcg.si1.model.queixa.Queixa;
import com.ufcg.si1.model.queixa.QueixaAberta;
import com.ufcg.si1.model.queixa.QueixaStatusEnum;
import com.ufcg.si1.repository.QueixaRepository;
import exceptions.AcaoNaoPermitidaException;
import exceptions.IdInexistenteException;
import scala.annotation.meta.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueixaServiceImpl implements QueixaService {

	@Autowired
	QueixaRepository queixaRepository;

	/*
	 * situação normal =0 situação extra =1
	 */
	/*
	private int situacaoAtualPrefeitura = 0;*/

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
		
		if(id <0 ){
			throw new IdInexistenteException("Id inexistente");
		}
		
		Queixa queixaEncontrada = queixaRepository.findOne(id);
		
		if (queixaEncontrada == null){
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
	
	/*
	public Queixa atualizaQueixa(Long id, Queixa queixa) throws IdInexistenteException {
		Queixa queixaAtual = encontraPorId(id);
		if (queixaAtual == null) {
			throw new IdInexistenteException("Não é possível atualizar. Queixa com id " + id + " não encontrada.");
		}
		queixaAtual.setDescricao(queixa.getDescricao());
		queixaAtual.setComentario(queixa.getComentario());
		queixaRepository.save(queixaAtual);
		return queixa;
	}

	public Queixa excluiQueixaPorId(Long id) throws IdInexistenteException {
		Queixa queixaExcluida = encontraPorId(id);
		if (queixaExcluida == null) {
			throw new IdInexistenteException("Unable to delete. Queixa with id " + id + " not found.");
		}
		queixaRepository.delete(queixaExcluida);
		return queixaExcluida;
	}

	@Override
	// este metodo nunca eh chamado, mas se precisar estah aqui
	public int size() {
		return findAllQueixas().size();
	}

	public void deleteAllQueixas() {
		queixaRepository.deleteAll();
	}

	public Queixa encontraPorId(Long id) throws IdInexistenteException {
		Queixa queixa = queixaRepository.findOne(id);
		if (queixa == null){
			throw new IdInexistenteException("Não há nenhuma queixa com o id " + id);
		}
		
		return queixa;
	}

	@Override
	public Queixa fecharQueixa(Queixa queixaAFechar) throws IdInexistenteException  {
		Queixa queixa = encontraPorId(queixaAFechar.getId());
		queixa.setSituacao(SituacaoDaQueixa.FECHADA);
		queixaRepository.save(queixaAFechar);

		return queixaAFechar;
	}

	private double numeroQueixasAbertas() {

		List<Queixa> queixas = findAllQueixas();
		int contador = 0;
		Iterator<Queixa> it = queixas.iterator();
		for (Iterator<Queixa> it1 = it; it1.hasNext();) {
			Queixa q = it1.next();
			if (q.getSituacao() == SituacaoDaQueixa.ABERTA)
				contador++;
		}

		return contador;
	}

	public Integer getSituacaoGeralQueixas() {
		double calculo = (double) numeroQueixasAbertas() / size();
		if (situacaoAtualPrefeitura == 0) {
			if (calculo > 0.2) {
				return new Integer(0);
			} else {
				if (calculo > 0.1) {
					return new Integer(1);
				}
			}
		} else {
			if (calculo > 0.1) {
				return new Integer(0);
			} else {
				if (calculo > 0.05) {
					return new Integer(1);
				}
			}
		}

		return new Integer(2);
	}
	
	public void abrirQueixa(Queixa queixa) throws AcaoNaoPermitidaException {
		if (queixa.getSituacao() != SituacaoDaQueixa.ANDAMENTO)
			queixa.setSituacao(SituacaoDaQueixa.ABERTA);
		else
			throw new AcaoNaoPermitidaException("Status inválido");
	}

	public void fechar(String coment, Queixa queixa) throws AcaoNaoPermitidaException {
		if (queixa.getSituacao() == SituacaoDaQueixa.ANDAMENTO
				|| queixa.getSituacao() == SituacaoDaQueixa.ABERTA) {
			queixa.setSituacao(SituacaoDaQueixa.FECHADA);
			queixa.setComentario(coment);
		} else
			throw new AcaoNaoPermitidaException("Status Inválido");
	}*/
}
