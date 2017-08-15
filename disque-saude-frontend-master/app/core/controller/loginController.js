app.controller("loginController", function($scope, loginApi, $location, $rootScope){

    $rootScope.logado = false;

    $scope.login = function(administrador){
        loginApi.login(administrador).then(function success(response) {
                localStorage.setItem("userToken", response.data.token);
                console.log("Login reaizado com sucesso")
                $location.path("/admin_menu");
                $rootScope.logado = true;
            }, function error(error) {
                console.log(error);
                console.log("Erro ao realizar login");
                $rootScope.logado = false;
            });
        
    }

    $scope.voltar = function () {
        $location.path("/");

    }
    
});