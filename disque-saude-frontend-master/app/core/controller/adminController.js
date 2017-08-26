app.controller("adminController", function($scope, $location, adminApi){

    $scope.getSituacaoGeralQueixas = function(){
        $location.path("/situacaoGeralQueixas")
    }

    $scope.gerenciarQueixas = function(){
        $location.path("/queixas")
    }

    $scope.voltar = function () {
        $location.path("/");

    }

    $scope.modificaStatusPrefeitura = function(novoStatus){
        adminApi.modificaStatusPrefeitura(novoStatus).then(function sucess(response){
            console.log(response.data)
        },function error(error){

        })
    }



});