app.service("unidadeApi", function ($http, config) {

	var _pesquisaMediaPaciente = function (id) {
		return $http.get(config.baseUrl + "/geral/medicos/" + id);
	}


	var _pesquisaUnidSaude = function (bairro) {
		return $https.get(config.baseUrl + "/unidade/busca/" + bairro);
	}

	var _adicionaUnidadeDeSaude = function (unidade) {
		return $https.post(config.baseUrl + "/unidade/", unidade);
	}

	var _getMediaMedicoPaciente = function (bairro) {
		return $http.get(config.baseUrl + "/unidade/" + bairro);
	}



	return {
		pesquisaMediaPaciente: _pesquisaMediaPaciente,
		pesquisaUnidSaude: _pesquisaUnidSaude,
		adicionaUnidadeDeSaude: _adicionaUnidadeDeSaude,
		getMediaMedicoPaciente: _getMediaMedicoPaciente
	}

});