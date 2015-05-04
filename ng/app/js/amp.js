angular.module('wdsamp', [])
    .factory('loginHttpInterceptor',['$q','$location',function($q,$location){
        return {
            response: function (result) {
                console.log(result);
                return result;
            }
        };
    }])
    .config(function($httpProvider) {
        $httpProvider.interceptors.push(function(){
        return {
            response: function (result) {
                console.log(result);
                return result;
            }
        };
    });
    })
    .run(function($http) {
        $http.get('http://google.com')
    })


