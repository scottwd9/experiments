var app = angular.module('imgApp', [])

.directive('mtImage', function(){
  var URL = window.url || window.webkitURL;
  // Runs during compile
  return {
    name: 'mtImage',
    // priority: 1,
    // terminal: true,
    // scope: {}, // {} = isolate, true = child, false/undefined = no change
    controller: function($scope, $element, $attrs, $transclude) {
      $scope.showFile = true;

    },
    // require: 'ngModel', // Array = multiple requires, ? = optional, ^ = check parent elements
    restrict: 'E', // E = Element, A = Attribute, C = Class, M = Comment
    template: '<div><input type="file" accept="image/*" ng-show="showFile"><img src="{{imgsrc}}" style="max-height: 500px; max-width: 500px;"></img></div>',
    // templateUrl: '',
    replace: true,
    // transclude: true,
    // compile: function(tElement, tAttrs, function transclude(function(scope, cloneLinkingFn){ return function linking(scope, elm, attrs){}})),
    link: function($scope, iElm, iAttrs, controller) {
      var inpt = iElm.find('input');
      var img = iElm.find('img');
      inpt.on('change', function() {
        var imgUrl =  URL.createObjectURL(this.files[0]);
        img.attr('src', imgUrl);
        URL.revokeObjectURL(imgUrl);
        $scope.$apply(function() {
          $scope.showFile = false;
        });
      });
    }
  };
});
