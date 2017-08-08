app.config(function ($routeProvider) {
    $routeProvider.when("/",{
        templateUrl: "view/search.html"

    }).when("/complaint/register", {
        templateUrl: "view/registerComplaint.html",
        controller : "queixaController",

    }).when("/searchcomplaint", {
        templateUrl : "view/search_complaint.html",
        controller: "queixaController"

    }).when("/search_health_unit", {
        templateUrl: "view/searchHealthUnit.html",
        controller : "searchHealthUnitCtrl",

    }).when("/searchaverage",{
        templateUrl : "view/search_average_per_patient.html",
        controller: "searchAverangeCtrl"

    }).when("/createdcomplaint/:id", {
        templateUrl : "view/successPage.html",
        controller : "queixaController"

    }).when("/generalSituationComplaints", {
        templateUrl : "view/generalSituationComplaints.html",
        controller : "queixaController"

    }).when("/loginEcadastro", {
        templateUrl : "loginEcadastro/loginEcadastro.html"
    })
        
    }).otherwise({
        redirectTo: '/'
    });
});
