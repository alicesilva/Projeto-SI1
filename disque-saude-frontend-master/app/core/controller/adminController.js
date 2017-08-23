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

    $scope.redirecionaPesquisaMedia = function() {
        $location.path("/pesquisamedia");
    }

    $scope.redirecionaAdicionarUS = function() {
        $location.path("/adicionaUS")
    }

    $scope.situacaoPrefeitura;
    $scope.alteraSituacaoPrefeitura = function(situacaoPrefeitura) {
        console.log(situacaoPrefeitura);
        adminApi.alterarSituacaoPrefeitura(situacaoPrefeitura).then(function success(response) {
            console.log("Alteracao realizada com sucesso")
        }, function error(error) {
                console.log(error);
                console.log("Erro ao alterar situacao da prefeitura");
                
        });
    }

});