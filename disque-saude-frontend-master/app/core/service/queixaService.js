app.service("queixaApi", function($http, config){

    var _salvarQueixas = function(queixa, tipoQueixa){
        return $http.post(config.baseUrl + "/queixa/", JSON.stringify(queixa, tipoQueixa));
    }

    var _getQueixa = function(id){
         return $http.get(config.baseUrl + "/queixa/" + id)
    }

    var _getSituacaoQueixas = function() {
        return $http.get(config.baseUrl +"/geral/situacao");
    }

    var _getQueixas = function() {
        return $http.get(config.baseUrl +"/queixas/");
    }

    var _addComentario = function(queixa){
        return $http.post(config.baseUrl +"/queixasComentario/", queixa);
    }

    var _modificaStatusDaQueixa = function(id, status){
        return $http.post(config.baseUrl +"/queixasStatus/" + id, status);
    }


    return {
        salvarQueixas : _salvarQueixas,
        getQueixa : _getQueixa,
        getSituacaoQueixas : _getSituacaoQueixas,
        getQueixas : _getQueixas,
        addComentario : _addComentario,
        modificaStatusDaQueixa: _modificaStatusDaQueixa
    }
});