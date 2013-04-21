var app = angular.module('zippy-app', []);

app.directive('zippy', function () {
  return {
    restrict: 'E',
    scope: {
      title: '@'
    },
    transclude: true,
    templateUrl: 'tz-inline.html',
    link: function (scope) {
      scope.isContentVisible = false;

      scope.$watch("title", function (value) {
        if (value.length > 8) {
          alert('too long');
        }
      });

      scope.toggleContent = function () {
        scope.isContentVisible = !scope.isContentVisible;
      };
    }
  };
});

app.directive('dumbpass', function ($templateCache) {
  var validElement = angular.element('<div>{{model.input}}</div>');

  this.link = function(scope) {
    scope.$watch('model.input', function (value) {
      if (value === 'password') {
        alert('bad password');
      }
    });
  };

  return {
    restrict: 'E',
    replace: true,
    templateUrl: 'pwdinput.html',
    // template: $templateCache.get('pwdinput.html'),
    compile: function (templateElement) {
      templateElement.append(validElement);
      return link;
    }
  };
});
