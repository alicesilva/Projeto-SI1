app.controller("registraQueixaController", function ($scope, $http, queixaService, toastr, $location, $routeParams) {

    $scope.registraQueixaTipo = function(){
        if($scope.tipo == "ALIMENTAR"){
            $location.path("/registra/queixa_alimentar");
        }else if($scope.tipo == "ANIMAL-PERDIDO"){
            $location.path("/registra/queixa_animal_perdido");
        }
    }

    $scope.registraQueixa = function (queixa, tipo) {
        queixa.type = tipo;
        queixaService.registraQueixa(queixa).then(function success(response) {
            toastr.success("Queixa adicionada com sucesso!");
            $location.path('/queixacriada/' + response.data.id);
        }, function error(error) {
            console.log(error);
            toastr.error("Erro ao registrar a queixa!")
        });
    }

    $scope.respostaQueixaId = "";
    var mostrarMensagem = function () {
        $scope.respostaQueixaId = $routeParams.id;
    }

    mostrarMensagem();

    $scope.voltar = function () {
        $location.path("/")
    }

});
