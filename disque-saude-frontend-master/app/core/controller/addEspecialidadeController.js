app.controller("addEspecialidadeController", function ($scope, $http, especialideService, $location) {
    
    $scope.adicionaEspecialidade = function(especialidade){
        especialideService.addEspecialidade(especialidade).then(function success(response){
            console.log(response.data)
        },function error(error){

        })
    }

    $scope.voltar = function () {
        $location.path("/menu_adm")
    }

});