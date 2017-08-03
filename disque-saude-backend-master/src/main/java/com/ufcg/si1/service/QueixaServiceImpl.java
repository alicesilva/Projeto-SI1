package com.ufcg.si1.service;

import com.ufcg.si1.model.Queixa;
import com.ufcg.si1.util.CustomErrorType;
import com.ufcg.si1.util.ObjWrapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;



@Service
public class QueixaServiceImpl implements QueixaService {

    private static final AtomicLong counter = new AtomicLong();

    private static List<Queixa> queixas;

    /* situação normal =0
    situação extra =1
     */
    private int situacaoAtualPrefeitura = 0;

    static {
        queixas = populateDummyQueixas();
    }

    private static List<Queixa> populateDummyQueixas() {
        List<Queixa> queixas = new ArrayList<Queixa>();

        queixas.add(new Queixa(counter.incrementAndGet(), "Passei mal com uma coxinha",
                Queixa.FECHADA, "", "Jose Silva",
                "jose@gmail.com", "rua dos tolos", "PE", "Recife"));


        queixas.add(new Queixa(counter.incrementAndGet(),
                "Bacalhau estragado, passamos mal!", Queixa.FECHADA, "",
                "Ailton Sousa", "ailton@gmail.com", "rua dos bobos", "PB",
                "Joao Pessoa"));

        queixas.add(new Queixa(counter.incrementAndGet(), "Nossa rua estah muito suja", Queixa.FECHADA, "",
                "Jose Silva", "jose@gmail.com", "rua dos tolos", "PE", "Recife"));


        queixas.add(new Queixa(counter.incrementAndGet(), "iluminacao horrivel, muitos assaltos", Queixa.FECHADA, "",
                "Ailton Sousa", "ailton@gmail.com", "rua dos bobos", "PB",
                "Joao Pessoa"));

        return queixas;
    }

    public List<Queixa> findAllQueixas() {
        return queixas;
    }

    public void saveQueixa(Queixa queixa) {
        queixa.setId(counter.incrementAndGet());
        queixas.add(queixa);
    }


    public Queixa atualizaQueixa(long id, Queixa queixa) throws Exception {
        Queixa queixaAtual = findById(id);
        if (queixaAtual == null) {
            throw new Exception("Unable to upate. Queixa with id " + id + " not found.");
        }
    	int index = queixas.indexOf(queixa);
    	queixaAtual.setDescricao(queixa.getDescricao());
        queixaAtual.setComentario(queixa.getComentario());
        queixas.set(index, queixa);
        return queixa;
    }

    public Queixa excluiQueixaPorId(long id) throws Exception {
    	Queixa queixaExcluida = findById(id);
    	if (queixaExcluida == null) {
            throw new Exception("Unable to delete. Queixa with id " + id + " not found.");
        }
        for (Iterator<Queixa> iterator = queixas.iterator(); iterator.hasNext(); ) {
            Queixa queixaAtual = iterator.next();
            if (queixaAtual.getId() == id) {
                iterator.remove();
            }
        }
        return queixaExcluida;
        

    @Override
    //este metodo nunca eh chamado, mas se precisar estah aqui
    public int size() {
        return queixas.size();
    }

    @Override
    public Iterator<Queixa> getIterator() {
        return queixas.iterator();
    }

    public void deleteAllUsers() {
        queixas.clear();
    }

    public Queixa findById(long id) {
        for (Queixa queixa : queixas) {
            if (queixa.getId() == id) {
                return queixa;
            }
        }
        return null;
    }


	@Override
	public Queixa fecharQueixa(Queixa queixaAFechar) throws Exception {
		long id = queixaAFechar.getId();
		queixaAFechar.situacao = Queixa.FECHADA;
		atualizaQueixa(id, queixaAFechar);
		return queixaAFechar;
	}
	
	 private double numeroQueixasAbertas() {
	        int contador = 0;
	        Iterator<Queixa> it = getIterator();
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
