app.controller("homeController", function($scope, $location){
    
    $scope.goRegistraQueixa = function(){
        $location.path("/registra/queixa")    
    }

    $scope.goPesquisaQueixa = function(){
        $location.path("/pesquisaqueixa")    
    }

    $scope.goLogin = function(){
        $location.path("/login")    
    }

    $scope.goConsultaUnidadeDeSaude = function(){
        $location.path("/pesquisa_unidade_saude")    
    }



});