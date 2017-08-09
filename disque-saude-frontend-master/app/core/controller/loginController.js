app.controller("loginController", function($scope, loginApi){

    $scope.login = function(administrador){
        loginApi.login(administrador).then(function success(response) {
                localStorage.setItem("userToken", response.data.token);
                console.log("Login reaizado com sucesso")
            }, function error(error) {
                console.log(error);
                console.log("Erro ao realizar login");
            });
        
    }
});