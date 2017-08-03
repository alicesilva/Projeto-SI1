package com.ufcg.si1.service;

import br.edu.ufcg.Hospital;
import com.ufcg.si1.model.UnidadeSaude;
import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service("unidadeSaudeService")
public class UnidadeSaudeServiceImpl implements UnidadeSaudeService {
    private Object[] vetorUnidadeSaude;

    private int indice;

    private int geraCodigo = 0; // para gerar codigos das queixas cadastradas
    
    private static final String NAOENCONTRADA = "Não achou unidade";
    private static final String ERROINCLUSAOARRAY = "Erro ao incluir no array";
    private static final String JAEXISTE = "Objeto jah existe no array";
    private static final String MENSAGEMERRO = "Erro!";
    
    public UnidadeSaudeServiceImpl() {
        vetorUnidadeSaude = new Object[100];
        indice = 0;
    }


    @Override
    public Object procura(int codigo) throws Rep,
            ObjetoInexistenteException {
        int i = 0;
        while (i < indice) {
            if (vetorUnidadeSaude[i] instanceof UnidadeSaude){
                UnidadeSaude unidadeSaude = (UnidadeSaude) vetorUnidadeSaude[i];
                if(unidadeSaude.pegaCodigo() == codigo){
                    return vetorUnidadeSaude[i];
                }
            }else if(vetorUnidadeSaude[i] instanceof Hospital){
                Hospital hospital = (Hospital) vetorUnidadeSaude[i];
                if(hospital.getCodigo() == codigo){
                    return vetorUnidadeSaude[i];
                }
            }
            i++;
        }
        throw new ObjetoInexistenteException(NAOENCONTRADA);
    }

    @Override
    public List<Object> getAll() {
        return Arrays.asList(vetorUnidadeSaude);
    }

    @Override
    public void insere(Object unidSaude) throws Rep,
            ObjetoJaExistenteException {

        if (unidSaude == null) {
        	throw new Rep(MENSAGEMERRO);
        } else {
        
        	if (unidSaude instanceof UnidadeSaude){
        		((UnidadeSaude) unidSaude).mudaCodigo(++geraCodigo);
        	} else {
        		((Hospital) unidSaude).setCodigo(++geraCodigo);
        	}
        }

        if (indice == this.vetorUnidadeSaude.length) {
        	throw new Rep(ERROINCLUSAOARRAY);
        }

        if (unidSaude instanceof UnidadeSaude){
        	UnidadeSaude unidadeSaude = (UnidadeSaude) unidSaude;
        	if (this.existe(unidadeSaude.pegaCodigo())) {
        		throw new ObjetoJaExistenteException(JAEXISTE);
        	}
        	
        } else if (unidSaude instanceof Hospital) {
        	Hospital hospital = (Hospital) unidSaude;
        	if (this.existe(hospital.getCodigo())) {
        		throw new ObjetoJaExistenteException(JAEXISTE);
        	}
        }


        this.vetorUnidadeSaude[indice] = unidSaude;
        indice++;
    }

    @Override
    public boolean existe(int codigo) {
        int indiceAux = 0;
        boolean existe = false;

        //refatorar: while!
        for (int i = 0; i < indice; i++) {
            if (this.vetorUnidadeSaude[i] instanceof UnidadeSaude){
                UnidadeSaude unidadeSaude = (UnidadeSaude) vetorUnidadeSaude[i];
                if (unidadeSaude.pegaCodigo() == codigo){
                    indiceAux = i;
                    existe = true;
                    break;
                }
            }else if (this.vetorUnidadeSaude[i] instanceof Hospital){
                Hospital hospital = (Hospital) vetorUnidadeSaude[i];
                if (hospital.getCodigo() == codigo){
                    indiceAux = i;
                    existe = true;
                    break;
                }
            }
        }

        return existe;
    }

    public Object findById(long id) {
    	Object result = null;
        for (Object especialidade: vetorUnidadeSaude) {
            if (especialidade instanceof UnidadeSaude){
                UnidadeSaude unidadeSaude = (UnidadeSaude) especialidade;
                if (unidadeSaude != null && unidadeSaude.pegaCodigo() == id){
                    result = unidadeSaude;
                	//return unidadeSaude;
                }
            }else if (especialidade instanceof Hospital){
                Hospital hospital = (Hospital) especialidade;
                if (hospital != null && hospital.getCodigo() == id){
                	result = hospital;
                    //return hospital;
                }
            }
        }
        return result;
    }

    @Override
    public Object findByBairro(String bairro) {
    	Object result = null;
        for (Object unidSaudeBairro: vetorUnidadeSaude) {
            if (unidSaudeBairro instanceof UnidadeSaude){;
                UnidadeSaude unidadeSaude = (UnidadeSaude) unidSaudeBairro;
                if (unidadeSaude.pegaDescricao().equals(bairro)){
                    result = unidSaudeBairro;
                	//return unidSaudeBairro;
                }
            } else if (unidSaudeBairro instanceof Hospital){
                Hospital hospital = (Hospital) unidSaudeBairro;
                if (hospital.getDescricao().equals(bairro)){
                    result = unidSaudeBairro;
                	//return unidSaudeBairro;
                }
            }
        }
        return result;
    }
}
