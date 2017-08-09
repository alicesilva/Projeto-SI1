package com.ufcg.si1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.si1.model.Administrador;
import com.ufcg.si1.repository.AdministradorRepository;

@Service
public class AdministradorServiceImpl implements AdministradorService{
	
	@Autowired
	AdministradorRepository administradorRepository;
	
	@Override
	public Administrador cadastraAdministrador(Administrador administrador) {
		
		if(administrador.getCodigo().equals(Administrador.CODIGO)){
			return administradorRepository.save(administrador);
		}else{
			return null;
		}
	}

	@Override
	public Administrador searchUserToEmail(String email) {
		return administradorRepository.searchUserToEmail(email);
	}

}
