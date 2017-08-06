package com.ufcg.si1.service;

import com.ufcg.si1.model.Especialidade;
import com.ufcg.si1.repository.EspecialidadeRepository;


import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class EspecialidadeServiceImpl implements EspecialidadeService {

	@Autowired
	EspecialidadeRepository  especialidadeRepository;

    private int indice;

    private int geraCodigo = 0; // para gerar codigos

    public EspecialidadeServiceImpl() {
    	//vetor = new Especialidade[100];
        indice = 0;
    }

    @Override
    public Especialidade procura(int codigo) throws Rep,
            ObjetoInexistenteException {
    	List<Especialidade> especialidades = especialidadeRepository.findAll();
    	for (Especialidade especialidade : especialidades) {
			if (especialidade.getCodigo() == codigo){
				return especialidade;
			}
		}
    	
    	/*int i = 0;

        while (i < indice) {
            if (vetor[i].getCodigo() == codigo) {
                return vetor[i];
            }

            i++;
        }*/

        throw new ObjetoInexistenteException("Erro Especialidade");
    }

    @Override
    public List getListaEspecialidade()
            throws Rep, ObjetoInexistenteException {
        return especialidadeRepository.findAll();
        //return Arrays.asList(vetor);
    }

    @Override
    public int size() {
        return this.indice;
    }

    @Override
    public Especialidade getElemento(int posicao) {
        return especialidadeRepository.findOne(posicao);
        
    	/*
    	if (posicao < indice)
            return this.vetor[posicao];
        else
            return null;*/
    }

    @Override
    public void insere(Especialidade esp) throws Rep,
            ObjetoJaExistenteException {

        esp.setCodigo(++geraCodigo);
        
        /*

        if (indice == this.vetor.length) {
            throw new Rep("Erro ao incluir no array");
        }*/

        if (this.existe(esp.getCodigo())) {
            throw new ObjetoJaExistenteException("Objeto jah existe no array");
        }

        /*this.vetor[indice] = esp; */
        especialidadeRepository.save(esp);
        indice++;
    }

    @Override
    public boolean existe(int codigo) {
    	
    	
    	List<Especialidade> especialidades = especialidadeRepository.findAll();
    	for (Especialidade especialidade : especialidades) {
			if (especialidade.getCodigo() == codigo){
				return true;
			}
		}
    	return false;
    	
        /*int indiceAux = 0;
        boolean existe = false;

        for (int i = 0; i < indice; i++) {
            if (this.vetor[i].getCodigo() == codigo) {
                indiceAux = i;
                existe = true;

                break;
            }
        }

        return existe;*/
    	
    }

    public Especialidade findById(long id) {
    	List<Especialidade> especialidades = especialidadeRepository.findAll();
    	for (Especialidade especialidade : especialidades) {
			if (especialidade.getCodigo() == id){
				return especialidade;
			}
		}
    	return null;
    	
    	/* for (Especialidade esp: vetor) {
            if (esp.getCodigo() == id) {
                return esp;
            }
        }
        return null;*/
    }


}
