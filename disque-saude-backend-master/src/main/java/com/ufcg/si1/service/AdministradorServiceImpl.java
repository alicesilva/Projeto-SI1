package com.ufcg.si1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.si1.model.Administrador;
import com.ufcg.si1.repository.AdministradorRepository;

import exceptions.AcaoNaoPermitidaException;

@Service
public class AdministradorServiceImpl implements AdministradorService{
	
	@Autowired
	AdministradorRepository administradorRepository;
	
	@Override
	public Administrador cadastraAdministrador(Administrador administrador) throws AcaoNaoPermitidaException{
		if(administrador == null){
			throw new AcaoNaoPermitidaException("Não é possovel cadastrar adm");
		}
		
		if(!administrador.getCodigo().equals(Administrador.CODIGO)){
			throw new AcaoNaoPermitidaException("Código errado para o administrador");
		}
		
		return administradorRepository.save(administrador);	
	}

	@Override
	public Administrador getAdministradorPorEmail(String email) {
		return administradorRepository.getAdministradorPorEmail(email);
	}

}
