app.controller("pesquisaUnidadeSaudeController", function ($scope, $http, unidadeService, toastr, $location, $routeParams) {
    $scope.unidade
    $scope.pesquisaUnidadeSaude = function(bairro){
        unidadeService.pesquisaUnidadeSaude(bairro).then(function success(response){
            console.log(response.data);
            $scope.unidade = response.data;
            if(response.data == ""){
                toastr.error("Unidade de Saúde não encontrada!")
            }
        },function error(error){
            toastr.error("Unidade de Saúde não encontrada!")
        })
    }

    $scope.voltar = function () {
        $location.path("/")
    }
});