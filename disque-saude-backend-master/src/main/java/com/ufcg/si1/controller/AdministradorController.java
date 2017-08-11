package com.ufcg.si1.controller;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ufcg.si1.model.Administrador;
import com.ufcg.si1.service.AdministradorService;
import com.ufcg.si1.util.Util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(Util.ROTA_API)
@CrossOrigin
public class AdministradorController {
	
	@Autowired
	AdministradorService administradorService;
	
	
	@RequestMapping(value = Util.ROTA_CADASTRO, method = RequestMethod.POST)
	public ResponseEntity<Administrador> cadastroAdministrador(@RequestBody Administrador administrador){
		Administrador admnistradorCadastrado = administradorService.cadastraAdministrador(administrador);
		
		return new ResponseEntity<Administrador>(admnistradorCadastrado, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = Util.ROTA_LOGIN, method= RequestMethod.POST)
	public LoginResponse autenticar(@RequestBody Administrador administrador) throws ServletException{
		
		if (administrador.getEmail() ==null || administrador.getSenha()==null){
			throw new ServletException("Email and password required!");
		}
		
		 Administrador admAutenticado = administradorService.searchUserToEmail(administrador.getEmail());
		
		if (admAutenticado==null){
			throw new ServletException("User not found!");
		}
		
		//if (!admAutenticado.getPassword().equals(userSystem.getPassword())){
			//throw new ServletException("Invalid email or password.");
		//}
		
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
