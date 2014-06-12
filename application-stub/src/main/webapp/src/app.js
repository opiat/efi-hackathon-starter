'use strict';
angular.module('meetUp',[
    'ngRoute'
]).config(['$routeProvider', function($routeProvider){
    $routeProvider
        .when("/", {templateUrl:'partial/events.html', controller : 'EventsCtrl'})
        .otherwise({redirectTo:'/'});
}]);