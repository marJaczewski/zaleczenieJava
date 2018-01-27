app.controller('newCategoryController', newCategorySimpleController)
function newCategorySimpleController($scope, $http, $location){

$scope.newCategory={

    name:""
};

$scope.addCategory=function(){

    $http.post($location.protocol()+'://'+$location.host()+':'+$location.port()+'/newCategory', $scope.newCategory);


};

};