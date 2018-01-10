app.controller('newUserController', function($scope, $http){

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

        $http.post('http://localhost:8095/api/addUser', $scope.user);


    }




});