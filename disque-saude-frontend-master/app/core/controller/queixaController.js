app.controller("queixaController", function ($scope,$http, queixaApi, toastr, $location, $routeParams) {

    $scope.registraQueixa = function (queixa) {
            queixaApi.salvarQueixas(queixa).then(function success(response) {
                toastr.success("Queixa adicionada com sucesso!");
                $location.path('/createdcomplaint/' + response.data.id);
            }, function error(error) {
                console.log(error);
                console.log("Problemas ao tentar adicionar queixa.");
            });
    }

    $scope.queixa;

    $scope.procuraQueixa = function (id) {
       queixaApi.getQueixa(id).then(function successCallback(response) {
            $scope.queixa = response.data;
        }, function errorCallback(error) {
            $scope.queixa = null;
            console.log(error);
        });
    }

    

    $scope.situacao = "";

    var getSituacaoGeralQueixas = function () {
        queixaApi.getSituacaoQueixas()
            .then(function success(response) {
                console.log(response.data.obj);

                if(response.data.obj == 0){
                    $scope.situacao = {
                        status: "RUIM",
                        color: "label-danger"
                    };

                } else if(response.data.obj == 1){

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
            }, function failed(error) {
                console.log("Erro na busca de unidades");
                console.log(error.data.errorMessage);
            });
    }

    getSituacaoGeralQueixas();

    $scope.responseComplaintId = "";
    var showMessage = function () {
        $scope.responseComplaintId = $routeParams.id;
    }

    showMessage();
});

    
