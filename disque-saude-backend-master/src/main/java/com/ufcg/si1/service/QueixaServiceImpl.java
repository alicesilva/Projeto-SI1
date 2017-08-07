package com.ufcg.si1.service;

import com.ufcg.si1.model.Queixa;
import com.ufcg.si1.repository.QueixaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Iterator;
import java.util.List;



@Service
public class QueixaServiceImpl implements QueixaService {
    
	@Autowired
	QueixaRepository  queixaRepository;
	
    /* situação normal =0
    situação extra =1
     */
    private int situacaoAtualPrefeitura = 0;
    
    public QueixaServiceImpl(QueixaRepository queixaRepository){
    	this.queixaRepository = queixaRepository;
    }

    public List<Queixa> findAllQueixas() {
        return queixaRepository.findAll();
    }

    public void saveQueixa(Queixa queixa) {
        queixaRepository.save(queixa);
    }


    public Queixa atualizaQueixa(Long id, Queixa queixa) throws Exception {
        Queixa queixaAtual = findById(id);
        if (queixaAtual == null) {
            throw new Exception("Unable to upate. Queixa with id " + id + " not found.");
        }
    	queixaAtual.setDescricao(queixa.getDescricao());
        queixaAtual.setComentario(queixa.getComentario());
        queixaRepository.save(queixaAtual);
        return queixa;
    }

    public Queixa excluiQueixaPorId(Long id) throws Exception {
    	Queixa queixaExcluida = findById(id);
    	if (queixaExcluida == null) {
            throw new Exception("Unable to delete. Queixa with id " + id + " not found.");
        }
        queixaRepository.delete(queixaExcluida);
        return queixaExcluida;
    }
        

    @Override
    //este metodo nunca eh chamado, mas se precisar estah aqui
    public int size() {
        return findAllQueixas().size();
    }

    public void deleteAllQueixas() {
        queixaRepository.deleteAll();
    }

    public Queixa findById(Long id) {
    	return queixaRepository.findOne(id);
    }


	@Override
	public Queixa fecharQueixa(Queixa queixaAFechar) throws Exception {
		Queixa queixa = findById(queixaAFechar.getId());
		queixa.situacao = Queixa.FECHADA;
		queixaRepository.save(queixaAFechar);
		
		return queixaAFechar;
	}
	
	 private double numeroQueixasAbertas() {
		 
		 List<Queixa> queixas = findAllQueixas();
	        int contador = 0;
	        Iterator<Queixa> it = queixas.iterator();
	        for (Iterator<Queixa> it1 = it; it1.hasNext(); ) {
	            Queixa q = it1.next();
	            if (q.getSituacao() == Queixa.ABERTA)
	                contador++;
	        }

	        return contador;
	    }
	 
	 public Integer getSituacaoGeralQueixas(){
		 double calculo = (double)numeroQueixasAbertas() / size();
		 if (situacaoAtualPrefeitura == 0) {
	            if (calculo > 0.2) {
	                return new Integer(0);
	            } else {
	                if (calculo > 0.1) {
	                    return new Integer(1);
	                }
	            }
	        }else {
	            if (calculo > 0.1) {
	                return new Integer(0);
	            }else{
	                if (calculo > 0.05) {
	                    return new Integer(1);
	                }
	            }
	        }
		 
		 return new Integer(2);
	 }

}
