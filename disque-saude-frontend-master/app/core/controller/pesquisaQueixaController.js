app.controller("pesquisaQueixaController", function ($scope, queixaService, $location) {
    $scope.queixa;

    $scope.procuraQueixa = function (id) {
        queixaService.getQueixa(id).then(function success(response) {
            $scope.queixa = response.data;
        }, function error(error) {
            $scope.queixa = null;
            console.log(error);
        });
    }

    $scope.voltar = function () {
        $location.path("/")
    }

});