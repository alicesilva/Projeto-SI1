app.service("queixaApi", function($http, config){

    var _salvarQueixas = function(queixa){
        return $http.post(config.baseUrl + "/queixa/", JSON.stringify(queixa));
    }

    var _getQueixa = function(id){
         return $http.get(config.baseUrl + "/queixa/" + id)
    }

    var _getSituacaoQueixas = function() {
        return $http.get(config.baseUrl +"/geral/situacao");
    }

    return {
        salvarQueixas : _salvarQueixas,
        getQueixa : _getQueixa,
        getSituacaoQueixas : _getSituacaoQueixas
    }
});