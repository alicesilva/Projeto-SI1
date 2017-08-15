app.controller("adminController", function($scope, $location){

    $scope.getSituacaoGeralQueixas = function(){
        $location.path("/situacaoGeralQueixas")
    }

    $scope.gerenciarQueixas = function(){
        $location.path("/queixas")
    }


    $scope.voltar = function () {
        $location.path("/");

    }

});