app.config(function ($routeProvider) {
    $routeProvider.when("/",{
        templateUrl: "view/home.html",
        controller : "homeController"
    }).when("/registra/queixa", {
        templateUrl: "view/registra-queixa.html",
        controller : "registraQueixaController"
    }).when("/registra/queixa_alimentar", {
        templateUrl: "view/registra-queixa-alimentar.html",
        controller : "registraQueixaController"
    }).when("/registra/queixa_animal_perdido", {
        templateUrl: "view/registra-queixa-animal.html",
        controller : "registraQueixaController"
    }).when("/pesquisaqueixa", {
        templateUrl : "view/pesquisa-queixa.html",
        controller: "pesquisaQueixaController"
    }).when("/pesquisa_unidade_saude", {
        templateUrl: "view/pesquisa-unidade-saude.html",
        controller : "pesquisaUnidadeSaudeController",
    }).when("/queixacriada/:id", {
        templateUrl : "view/queixa-criada-sucesso.html",
        controller : "registraQueixaController"
    }).when("/situacaoGeralQueixas", {
        templateUrl : "view/situacao-geral-queixas.html",
        controller : "situacaoGeralQueixasController"
    }).when("/login", {
        templateUrl : "view/login.html",
        controller : "loginController"
    }).when("/cadastro", {
        templateUrl : "view/cadastro.html",
        controller : "cadastroController"
    }).when("/menu_adm", {
        templateUrl : "view/menu-adm.html",
        controller : "admController"
     }).when("/menu_gerencia_queixas", {
        templateUrl : "view/menu-gerencia-queixas.html",
        controller : "gerenciaQueixasController"
    }).when("/add_us", {
        templateUrl : "view/add-us.html",
        controller : "addUnidadeSaudeController"
    }).when("/media_medico_paciente", {
        templateUrl : "view/media-medico-paciente.html",
        controller : "mediaMedicoPacienteController"
    }).when("/add_especialidade", {
        templateUrl : "view/add-especialidade.html",
        controller : "addEspecialidadeController"
    }).otherwise({
        redirectTo: '/'
    });
});
