
app.controller("searchHealthUnitCtrl", function ($scope, $http) {

    $scope.units = [];

    $scope.searchHU = function (neighborhood) {
        $http.get("http://localhost:5000/SpringBootRestApi/api/unidade/busca?bairro=" + neighborhood)
            .then(function success(response) {
                $scope.units = [];
                $scope.units.push(response.data);
                console.log("Foram encontradas Unidades de saúde");
                console.log(response.data);
            }, function failed(error) {
                console.log("Erro na busca de unidades");
                console.log(error.data.errorMessage);
            });
    }
});