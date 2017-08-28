app.controller("admController", function($scope, $location, prefeituraService, toastr){

    $scope.getSituacaoGeralQueixas = function(){
        $location.path("/situacaoGeralQueixas")
    }

    $scope.gerenciarQueixas = function(){
        $location.path("/menu_gerencia_queixas")
    }

    $scope.adicionarUnidadeDeSaude = function(){
        $location.path("/add_us")
    }

    $scope.getMediaMedicoPorPaciente = function(){
        $location.path("/media_medico_paciente")
    }

    $scope.adicionarEspecialidade = function(){
        $location.path("/add_especialidade")
    }

    $scope.logout = function () {
        $location.path("/");

    }

    $scope.modificaStatusPrefeitura = function(novoStatus){
        prefeituraService.modificaStatusPrefeitura(novoStatus).then(function sucess(response){
            toastr.success("Status da Prefeitura modificado para: " + novoStatus + " !")
        },function error(error){

        })
    }



});