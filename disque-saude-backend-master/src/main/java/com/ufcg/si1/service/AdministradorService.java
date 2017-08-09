package com.ufcg.si1.service;

import com.ufcg.si1.model.Administrador;

public interface AdministradorService {

	Administrador cadastraAdministrador(Administrador administrador);

	Administrador searchUserToEmail(String email);

}
