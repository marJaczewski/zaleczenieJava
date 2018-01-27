app.controller('newUserController', function($scope, $http, $location){

  $scope.user={
      imie:"",
      nazwisko:"",
      address:"",
      email:"",
      telefon:"",
      haslo:""
  };



    $scope.submit_success = false;
    $scope.call = function () {
        $scope.server = angular.copy($scope.user);
        $scope.submit_success = true;

        $http.post($location.protocol()+'://'+$location.host()+':'+$location.port()+'/free/addUser', $scope.user);


    }




});