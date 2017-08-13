package com.ufcg.si1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ufcg.si1.model.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Long>{

	@Query(value="Select u from Administrador u where u.email=:pemail ")
	public Administrador getAdministradorPorEmail(@Param("pemail") String email);
}
