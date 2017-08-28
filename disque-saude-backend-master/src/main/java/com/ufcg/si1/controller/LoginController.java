package com.ufcg.si1.controller;

import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ufcg.si1.model.adm.Administrador;
import com.ufcg.si1.service.AdministradorService;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin
@RequestMapping(value = "/login/")
public class LoginController {
	
	@Autowired
	AdministradorService admService;
	
	@RequestMapping(method= RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public LoginResponse autenticar(@RequestBody Administrador administrador) throws ServletException{
		
		if (administrador.getEmail() == null || administrador.getSenha()==null){
			throw new ServletException("Email e senha requeridos!");
		}
		
		 Administrador admAutenticado = admService.getAdministradorEmail(administrador.getEmail());
		
		if (admAutenticado==null){
			throw new ServletException("Usuário não encontrado!");
		}
		
		if (!admAutenticado.getSenha().equals(administrador.getSenha())){
			throw new ServletException("Senha ou email inválido!");
		}
		
		String token=  Jwts.builder()
				.setSubject(admAutenticado.getNome())
				.signWith(SignatureAlgorithm.HS512, "banana")
				.compact();
		
		
		return	new LoginResponse(token);
	}
	
	private class LoginResponse{
		public String token;
		 
		public LoginResponse(String token ){
			this.token=token; 
		 }
		
	}
	

}
