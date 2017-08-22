app.controller("queixaController", function ($scope, $http, queixaApi, toastr, $location, $routeParams) {

    $scope.registraQueixa = function (queixa, tipo) {
        queixa.type = tipo;
        queixaApi.salvarQueixas(queixa).then(function success(response) {
            toastr.success("Queixa adicionada com sucesso!");
            $location.path('/queixacriada/' + response.data.id);
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
            }, function failed(error) {
                console.log("Erro na busca de unidades");
                console.log(error.data.errorMessage);
            });
    }

    getSituacaoGeralQueixas();

    $scope.respostaQueixaId = "";
    var mostrarMensagem = function () {
        $scope.respostaQueixaId = $routeParams.id;
    }

    mostrarMensagem();


    $scope.queixas = "";
    var getQueixas = function () {
        queixaApi.getQueixas()
            .then(function success(response) {
                $scope.queixas = response.data;
                console.log(response.data);
            })
    };

    getQueixas();

    $scope.voltar = function () {
        $location.path("/");

    }

    $scope.voltarMenuAdm = function () {
        $location.path("/admin_menu")
    }

    $scope.addComentario = function(id, comentario){
       var queixaASerModificada = new Object();
       queixaASerModificada.id = id;
       queixaASerModificada.comentario = comentario;
       queixaApi.addComentario(queixaASerModificada)
            .then(function success(response){
                console.log(response.data)
        });
    }

    $scope.queixaA = {
        status: null
    };
    $scope.modificaStatusDaQueixa = function(id){
        var queixaASerModificada = new Object();
        queixaASerModificada.id = id;
         queixaApi.modificaStatusDaQueixa(id, $scope.queixaA.status)
            .then(function success(response){
                console.log(response.data)
        });
    }

    $scope.registraQueixaA = function(){
        if($scope.tipo == "ALIMENTAR"){
            $location.path("/registra/queixa_alimentar");
        }else if($scope.tipo == "ANIMAL-PERDIDO"){
            $location.path("/registra/queixa_animal_perdido");
        }
        
        console.log($scope.tipo);
    }


});


