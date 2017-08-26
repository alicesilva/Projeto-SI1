app.config(function ($routeProvider) {
    $routeProvider.when("/",{
        templateUrl: "view/menu-geral.html",
        controller : "menuController"
    }).when("/registra/queixa", {
        templateUrl: "view/registra-queixa.html",
        controller : "queixaController"
    }).when("/registra/queixa_alimentar", {
        templateUrl: "view/registra-queixa-alimentar-geral.html",
        controller : "queixaController"
    }).when("/registra/queixa_animal_perdido", {
        templateUrl: "view/registra-queixa-animal.html",
        controller : "queixaController"
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
    }).when("/login", {
        templateUrl : "view/login.html",
        controller : "loginController"
    }).when("/cadastro", {
        templateUrl : "view/cadastro.html",
        controller : "cadastroController"
    }).when("/admin_menu", {
        templateUrl : "view/admin-menu.html",
        controller : "adminController"
     }).when("/queixas", {
        templateUrl : "view/queixas.html",
        controller : "queixaController"
    }).when("/us", {
        templateUrl : "view/add-us.html",
        controller : "unidadeController"
    }).when("/media-medico-paciente", {
        templateUrl : "view/media-medico-paciente.html",
        controller : "unidadeController"
    }).when("/add-especialidade", {
        templateUrl : "view/add-especialidade.html",
        controller : "especialidadeController"
    }).otherwise({
        redirectTo: '/'
    });
});
