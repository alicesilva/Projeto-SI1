app.service("queixaService", function($http, config){

    var _registraQueixa = function(queixa){
        return $http.post(config.baseUrl + "/queixa/", queixa);
    }

    var _getQueixa = function(id){
         return $http.get(config.baseUrl + "/queixa/" + id)
    }

    var _getSituacaoQueixas = function() {
        return $http.get(config.baseUrl +"/queixa/situacao");
    }

    var _getQueixas = function() {
        return $http.get(config.baseUrl +"/queixas/");
    }

    var _addComentario = function(id, comentario){
        return $http.post(config.baseUrl +"/queixa/comentario/" + id, comentario);
    }

    var _modificaStatus = function(id, status){
        return $http.post(config.baseUrl +"/queixa/status/" + id, status);
    }


    return {
        registraQueixa : _registraQueixa,
        getQueixa : _getQueixa,
        getSituacaoQueixas : _getSituacaoQueixas,
        getQueixas : _getQueixas,
        addComentario : _addComentario,
        modificaStatus: _modificaStatus
    }
});