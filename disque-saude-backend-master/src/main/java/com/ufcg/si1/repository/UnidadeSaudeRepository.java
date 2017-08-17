package com.ufcg.si1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ufcg.si1.model.unidadeSaude.UnidadeSaude;

public interface UnidadeSaudeRepository extends JpaRepository<UnidadeSaude, Long>{
	
	@Query(value="Select u from UnidadeSaude u where u.endereco.bairro=:pbairro ")
	public UnidadeSaude searchUnidadeSaudeToBairro(@Param("pbairro") String bairro);
}
