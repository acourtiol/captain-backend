var app = angular.module('app', ['ngRoute', 'ngAnimate', 'ngResource']);

app.config(function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl : 'partials/home.html',
            controller  : 'homeCtrl'
        })
        .when('/account/login', {
            templateUrl : 'partials/account/login.html',
            controller  : 'accountLoginCtrl'
        })
        .otherwise({
            redirectTo : '/'
        });
});