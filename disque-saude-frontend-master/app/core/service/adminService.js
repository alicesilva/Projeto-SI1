app.service("adminApi", function($http, config){

    var _alterarSitacaoPrefeitura = function(situacao){
        return $http.put(config.baseUrl + "/situacaoPrefeitura/", JSON.stringify(situacao));
    }

    return {
        alterarSituacaoPrefeitura : _alterarSitacaoPrefeitura
    }

});