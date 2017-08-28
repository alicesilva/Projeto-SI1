app.controller("cadastroController", function($scope, cadastroService, $location, toastr){


    $scope.cadastro = function(administrador){
        cadastroService.cadastraAdm(administrador).then(function success(response) {
                toastr.success("Cadastro realizado com sucesso")
                $location.path("/login");
            }, function error(error) {
                console.log(error);
                toastr.error("Erro ao cadastrar administrador")
            });
        
    }

});