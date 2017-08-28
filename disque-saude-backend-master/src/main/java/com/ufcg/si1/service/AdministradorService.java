package com.ufcg.si1.service;

import com.ufcg.si1.model.adm.Administrador;

import exceptions.AcaoNaoPermitidaException;

public interface AdministradorService {

	Administrador cadastraAdministrador(Administrador administrador) throws AcaoNaoPermitidaException;

	Administrador getAdministradorEmail(String email);

}
