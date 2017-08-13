package com.ufcg.si1.service;

import com.ufcg.si1.model.Administrador;

import exceptions.AcaoNaoPermitidaException;

public interface AdministradorService {

	Administrador cadastraAdministrador(Administrador administrador) throws AcaoNaoPermitidaException;

	Administrador getAdministradorPorEmail(String email);

}
