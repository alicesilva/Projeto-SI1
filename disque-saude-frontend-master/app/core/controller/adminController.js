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

    $scope.redirecionaPesquisaMedia = function() {
        $location.path("/pesquisamedia");
    }

    $scope.redirecionaAdicionarUS = function() {
        $location.path("/adicionaUS")
    }



});