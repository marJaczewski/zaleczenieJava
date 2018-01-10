app.controller('currentController', function ($scope, $location, $routeParams, $http, $rootScope) {

    $scope.singleAdvertisement = "";
    $scope.currentIdentyfikator = "";






    $scope.$on('$viewContentLoaded', function () {

        $http.get('http://localhost:8095/current/' + $routeParams.id)
       // $http.get($location.protocol()+'://'+$location.host()+':'+$location.port()+'/current/'+ $routeParams.id)
             .then(function (result) {
                    $scope.singleAdvertisement = result.data;
                }, function (result) {
                    $scope.singleAdvertisement = "blad pobrania odfiltrowanych wyników";
                }
            );


    });



    //****************tymczasowo***********************
    $scope.show=function(){

        $http.get('http://localhost:8095/current/' + $routeParams.id)

            .then(function (result) {
                    $scope.singleAdvertisement = result.data;
                }, function (result) {
                    $scope.singleAdvertisement = "blad pobrania odfiltrowanych wyników";
                }
            );

    };
    //****************tymczasowo***********************

});

