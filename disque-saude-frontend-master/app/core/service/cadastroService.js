app.service("cadastroService", function($http, config){

    var _cadastraAdm = function(administrador){
        return $http.post(config.baseUrl + "/cadastro/", JSON.stringify(administrador));
    }

    return {
        cadastraAdm : _cadastraAdm
    }

});