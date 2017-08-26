app.service("adminApi", function($http, config){

    var _modificaStatusPrefeitura = function(novoStatus){
        return $http.post(config.baseUrl + "/modifica-status/", novoStatus);
    }

    return {
        modificaStatusPrefeitura : _modificaStatusPrefeitura
    }

});