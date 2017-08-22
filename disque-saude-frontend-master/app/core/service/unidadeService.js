app.service("unidadeApi", function ($http, config) {

	var _pesquisaMediaPaciente = function (id) {
		return $http.get(config.baseUrl + "/geral/medicos/" + id);
	}


	var _pesquisaUnidSaude = function (bairro) {
		return $http.get(config.baseUrl + "/unidade/busca/" + bairro);
	}

	var _adicionaUS = function(unidade) {
		return $http.post(config.baseUrl + "/unidade/",  JSON.stringify(unidade));
	}


	return {
		pesquisaMediaPaciente: _pesquisaMediaPaciente,
		pesquisaUnidSaude: _pesquisaUnidSaude,
		adicionaUS: _adicionaUS
	}

});