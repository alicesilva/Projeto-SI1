app.controller("loginController", function($scope, loginService, $location, toastr){

    $scope.login = function(administrador){
        loginService.login(administrador).then(function success(response) {
                localStorage.setItem("userToken", response.data.token);
                toastr.success("Login realizado com sucesso")
                $location.path("/menu_adm");
            }, function error(error) {
                console.log(error);
                toast.error("Erro ao realizar login!");
            });
    }

    $scope.voltar = function () {
        $location.path("/");
    }

    $scope.goCadastro = function(){
         $location.path("/cadastro");
    }
    
});