app.controller("addUnidadeSaudeController", function ($scope, $http, toastr, unidadeService, $location) {

     $scope.adicionaUnidadeDeSaude = function(unidade){
        unidadeService.addUnidadeDeSaude(unidade).then(function success(response){
            console.log(response.data)
            toastr.success("Unidade de Saúde adicionada!")
        },function error(error){
            toastr.error("Erro ao adicionar Unidade de Saúde!")
        })
     }

    $scope.voltar = function () {
        $location.path("/menu_adm")
    }
});