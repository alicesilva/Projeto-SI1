app.controller("situacaoGeralQueixasController", function ($scope, queixaService, toastr, $location) {
    $scope.situacao = "";

    var getSituacaoGeralQueixas = function () {
        queixaService.getSituacaoQueixas()
            .then(function success(response) {
                console.log(response.data);

                if (response.data == "RUIM") {
                    $scope.situacao = {
                        status: "RUIM",
                        color: "label-danger"
                    };

                } else if (response.data == "REGULAR") {

                    $scope.situacao = {
                        status: "REGULAR",
                        color: "label-primary"
                    };
                } else {
                    $scope.situacao = "";
                    $scope.situacao = {
                        status: "BOM",
                        color: "label-success"
                    };

                }
            }, function error(error) {
                toastr.error("O sistema não possui nenhuma queixa registrada!")
                console.log(error.data.errorMessage);
            });
    }

    getSituacaoGeralQueixas();

    $scope.voltar = function () {
        $location.path("/menu_adm")
    }
});