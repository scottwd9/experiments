'use strict';

angular.module('wds-todos', []);

function TodoCtrl($scope) {
  $scope.todos = [
    {text: 'learn angular', done: false},
    {text: 'build app', done:false}
  ];

  $scope.totalTodos = function() {
    return $scope.todos.length;
  };

  $scope.addTodo = function() {
    if (!$scope.formTodoText) {
      return;
    }
    $scope.todos.push({text: $scope.formTodoText, done: false});
    $scope.formTodoText = '';
  };

  $scope.clearCompleted = function() {
    $scope.todos = _.filter($scope.todos, function(todo) {
      return !todo.done;
    });
  };

}
