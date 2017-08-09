app.service("loginApi", function($http, config){

    var _login = function(administrador){
        return $http.post(config.baseUrl + "/login/", JSON.stringify(administrador));
    }

    return {
        login : _login
    }

});