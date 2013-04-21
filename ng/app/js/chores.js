var app = angular.module('chores', []);

function ChoreCtrl($scope) {
  $scope.logChore = function(choreDone) {
    console.log(choreDone + ' is done');
  };
}

app.directive('kid', function() {
  return {
    scope: {
      done: "&"
    },
    restrict: 'E',
    template: '<div><input type="text" ng-model="myChore"> {{myChore}} <button ng-click="done({chore:myChore})">done!</button></div>'
  };
});
