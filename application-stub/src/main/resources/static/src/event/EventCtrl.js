'user strict';

var app = angular.module('meetUp.event');
app.controller('EventCtrl',['EventRepository', function(EventRepository){
    var self = this;

    self.fetchEvents = function () {
        EventRepository.events(function(data){
            self.events = data;
        });
    }
    self.fetchEvents();
}]);