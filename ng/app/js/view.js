(function() {
  /* global angular */
  'use strict';

  var app = angular.module('app', []);

  app.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'view-app.html',
        controller: 'ViewCtrl',
        resolve: {
          loadData: appCtrl.loadData,
          prepData: appCtrl.prepData
        }
      })
      .when('/echo/:message', {
        templateUrl: 'view-app.html',
        controller: 'EchoCtrl'
      })
      .otherwise({
        // template: '???'
        redirectTo: '/'
      });
  }]);

  var errorDirective = app.directive('error', ['$rootScope', function ($rootScope) {
    return {
      restrict: 'E',
      template: '<div class="alert alert-error" ng-show="isError">Error! {{errMsg}}</div>',
      link: function (scope) {
        $rootScope.$on('$routeChangeError', function(event, current, previous, rejection) {
          scope.isError = true;
          scope.errMsg = rejection;
        });
      }
    };
  }]);

  var appCtrl = app.controller('AppCtrl', ['$rootScope', function($rootScope) {
    $rootScope.$on('$routeChangeError', function(event, current, previous, rejection) {
      console.log(rejection);
    });
  }]);


  var viewCtrl = app.controller('ViewCtrl', ['$scope', function($scope) {
    $scope.model = {
      message: 'This is my app!'
    };
  }]);

  viewCtrl.loadData = ['$q', '$timeout', function ($q, $timeout) {
    var defer = $q.defer();

    $timeout(function() {
      console.log('data loaded');
      defer.reject('network down!');
    }, 2000);

    return defer.promise;
  }];

  viewCtrl.prepData = ['$q', '$timeout', function ($q, $timeout) {
    var defer = $q.defer();

    $timeout(function() {
      console.log('data prepped');
      defer.resolve();
    }, 2000);

    return defer.promise;
  }];

  app.controller('EchoCtrl', ['$scope', '$routeParams', function($scope, $routeParams) {
    $scope.model = {
      message: $routeParams.message
    };
  }]);
})();

