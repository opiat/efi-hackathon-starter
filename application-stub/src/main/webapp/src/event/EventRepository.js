'use strict'
var repository = angular.module('meetUp.event');

repository.factory('EventRepository',['$resource', function($resource){
    var eventUrl = '/events/:option';

    var eventResource = $resource(eventUrl, {option : '@option'} , {
        post: {method: 'POST'},
        list: {method: 'GET', isArray: true}
    });

    var Event = {};

    Event.events = function(callback){
        eventResource.list({option:''},callback);
    };

    return Event;
}]);
