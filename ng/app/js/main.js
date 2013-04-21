var myApp = angular.module('myApp', []);
myApp.factory('Data', function () {
  return "Hello";
});

myApp.directive('enter', function () {
  //restrict defaults to 'A'
  //if only using link function, can just return a function
  return function (scope, element, attrs) {
    element.bind("mouseenter", function () {
      element.addClass(attrs.enter);
    });
  };
});

myApp.directive('leave', function () {
  return {
    restrict: "A",
    link: function (scope, element, attrs) {
      element.bind("mouseleave", function () {
        element.removeClass(attrs.leave);
      });
    }
  };
});

myApp.directive('clearname', function () {
  return function (scope, element, attrs) {
    element.bind('mouseenter', function () {
      scope.$apply(attrs.clearname);
    });
  };
});

myApp.filter('reverse', function () {
  return function (text) {
    return text.split("").reverse().join("");
  };
});

function GreetingCtrl ($scope, Data) {
  $scope.greeting = Data;
  $scope.name = '';

  $scope.gblah = function () {
    $scope.name = '';
  };
}

function RevCtrl ($scope, Data) {
  $scope.greeting = Data;
  $scope.name = '';
  $scope.rblah = function () {
    $scope.name = '';
  };
}
