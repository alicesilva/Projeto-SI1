app.controller("cadastroController", function($scope, cadastroApi){


    $scope.cadastro = function(administrador){
        cadastroApi.salvarAdministrador(administrador).then(function success(response) {
                console.log("Cadastro reaizado com sucesso")
            }, function error(error) {
                console.log(error);
                console.log("Erro ao cadastrar administrador");
            });
        
    }

});