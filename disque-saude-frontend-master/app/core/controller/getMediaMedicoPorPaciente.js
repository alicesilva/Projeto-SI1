app.controller("mediaMedicoPacienteController", function ($scope, toastr, unidadeService, $location) {
     $scope.taxa

    $scope.mediaMedicoPorPaciente = function(unidadeBairro){
        unidadeService.getMediaMedicoPorPaciente(unidadeBairro).then(function success(response){
            $scope.taxa = response.data;
        },function error(error){
            toastr.error("Unidade de Saude não encontrada ou não há pacientes nesta unidade de saúde!")
        })
    }

    $scope.voltar = function () {
        $location.path("/menu_adm")
    }

});