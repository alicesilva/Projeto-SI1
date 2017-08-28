app.service("unidadeService", function ($http, config) {

	var _pesquisaMediaPaciente = function (id) {
		return $http.get(config.baseUrl + "/geral/medicos/" + id);
	}

	var _addUnidadeDeSaude = function (unidade) {
		return $http.post(config.baseUrl + "/unidade/", unidade);
	}

	var _getMediaMedicoPorPaciente = function (bairro) {
		return $http.get(config.baseUrl + "/unidade/" + bairro);
	}

	var _pesquisaUnidadeSaude = function (bairro) {
		return $http.get(config.baseUrl + "/unidade/busca/" + bairro);
	}


	return {
		pesquisaMediaPaciente: _pesquisaMediaPaciente,
		getMediaMedicoPorPaciente: _getMediaMedicoPorPaciente,
		pesquisaUnidadeSaude: _pesquisaUnidadeSaude,
		addUnidadeDeSaude: _addUnidadeDeSaude
	}

});