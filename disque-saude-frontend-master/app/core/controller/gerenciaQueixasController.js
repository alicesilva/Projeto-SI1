app.controller("gerenciaQueixasController", function ($scope, queixaService, $location, toastr) {
    $scope.queixas = "";
    var getQueixas = function () {
        queixaService.getQueixas()
            .then(function success(response) {
                $scope.queixas = response.data;
                console.log(response.data);
            })
    };

    getQueixas();

    $scope.addComentario = function(id, comentario){
       queixaService.addComentario(id, comentario)
            .then(function success(response){
                console.log(response.data)
        }, function error(error){
             toastr.error("Erro ao adicionar comentário!")
        });
    }

    $scope.modificaStatusDaQueixa = function(id, status){
         queixaService.modificaStatus(id, status)
            .then(function success(response){
                console.log(response.data)
        }, function error(error){
             toastr.error("Erro ao modificar o status da queixa!")
        });
    }

    $scope.voltar = function () {
        $location.path("/menu_adm")
    }


});