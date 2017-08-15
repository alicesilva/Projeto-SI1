app.controller("cadastroController", function($scope, cadastroApi, $location){


    $scope.cadastro = function(administrador){
        cadastroApi.salvarAdministrador(administrador).then(function success(response) {
                console.log("Cadastro reaizado com sucesso")
                alert("Cadastro reaizado com sucesso");
                $location.path("/login");
            }, function error(error) {
                console.log(error);
                console.log("Erro ao cadastrar administrador");
            });
        
    }


    $scope.voltar = function () {
        $location.path("/");

    }

});