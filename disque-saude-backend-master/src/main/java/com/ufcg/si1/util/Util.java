package com.ufcg.si1.util;

public class Util {
	
	private static final String RAIZ = "/";
	private static final String API = "api";
	private static final String QUEIXA = "queixa";
	private static final String FECHAMENTO = "fechamento";
	private static final String GERAL = "geral";
	private static final String SITUACAO = "situacao";
	private static final String ID = "{id}";
	
	private static final String UNIDADES = "unidades";

	private static final String BUSCA = "busca";
	private static final String BAIRRO = "{bairro}";
	
	private static final String ESPECIALIDADE = "especialidade";
	
	
	
	
	
	public static final String ROTA_API = RAIZ + API;

	public static final String ROTA_QUEIXA = RAIZ + QUEIXA + RAIZ;
	public static final String ROTA_CONSULTAR_QUEIXA_POR_ID = ROTA_QUEIXA + ID;
	public static final String ROTA_ATUALIZAR_QUEIXA_POR_ID = ROTA_QUEIXA + ID;
	public static final String ROTA_EXCLUIR_QUEIXA_POR_ID = ROTA_QUEIXA + ID;
	public static final String ROTA_FECHAR_QUEIXA = ROTA_QUEIXA + FECHAMENTO;
	public static final String ROTA_SITUACAO_GERAL_QUEIXAS = RAIZ + GERAL + RAIZ + SITUACAO;
	

	public static final String UNIDADE = "unidade";
	public static final String ROTA_UNIDADE = RAIZ + UNIDADE + RAIZ;
	public static final String ROTA_CONSULTAR_UNIDADE_SAUDE_POR_BAIRRO = ROTA_UNIDADE + BUSCA + BAIRRO;
	public static final String ROTA_CONSULTAR_UNIDADE_SAUDE = ROTA_UNIDADE + ID;
	public static final String ROTA_CONSULTAR_ESPECIALIDADE_POR_UNIDADE_SAUDE = ESPECIALIDADE + UNIDADES;
	
	public static final String ROTA_ESPECIALIDADE = RAIZ + ESPECIALIDADE + RAIZ;
	public static final String ROTA_CONSULTAR_ESPECIALIDADE = ROTA_ESPECIALIDADE + ID;
	
	
	private static final String LOGIN = "login";
	private static final String CADASTRO = "cadastro";
	public static final String ROTA_LOGIN = RAIZ + LOGIN + RAIZ;
	public static final String ROTA_CADASTRO = RAIZ + CADASTRO + RAIZ;




	










}
