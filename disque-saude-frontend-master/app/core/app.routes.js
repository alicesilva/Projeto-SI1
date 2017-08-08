app.config(function ($routeProvider) {
    $routeProvider.when("/",{
        templateUrl: "view/pesquisa.html"
    }).when("/queixa/registra", {
        templateUrl: "view/registra-queixa.html",
        controller : "queixaController",
    }).when("/pesquisaqueixa", {
        templateUrl : "view/pesquisa-queixa.html",
        controller: "queixaController"
    }).when("/pesquisa_unidade_saude", {
        templateUrl: "view/pesquisa-unidade-saude.html",
        controller : "unidadeController",
    }).when("/pesquisamedia",{
        templateUrl : "view/pesquisa-media-por-paciente.html",
        controller: "unidadeController"
    }).when("/queixacriada/:id", {
        templateUrl : "view/pagina-sucesso.html",
        controller : "queixaController"
    }).when("/situacaoGeralQueixas", {
        templateUrl : "view/situacao-geral-queixas.html",
        controller : "queixaController"

    }).when("/loginEcadastro", {
        templateUrl : "loginEcadastro/loginEcadastro.html"
    })
        
    }).otherwise({
        redirectTo: '/'
    });
});
