app.service("unidadeApi", function ($http, config) {

	var _pesquisaMediaPaciente = function (id) {
		return $http.get(config.baseUrl + "/geral/medicos/" + id);
	}


	var _pesquisaUnidSaude = function (bairro) {
		return $http.get(config.baseUrl + "/unidade/busca/" + bairro);
	}



	return {
		pesquisaMediaPaciente: _pesquisaMediaPaciente,
		pesquisaUnidSaude: _pesquisaUnidSaude
	}

});