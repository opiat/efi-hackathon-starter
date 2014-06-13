'use strict';
angular.module('meetUp',['ngRoute','ngResource','meetUp.event'])
    .config(['$routeProvider', function($routeProvider){
    $routeProvider
        .when("/", {templateUrl:'partial/events.html', controller : 'EventCtrl'})
        .otherwise({redirectTo:'/'});
}]);