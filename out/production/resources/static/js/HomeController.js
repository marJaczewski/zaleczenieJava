app.controller('homeController', simpleHomeController)


function simpleHomeController($scope, $http, $rootScope) {

    $scope.login="";
    $scope.haslo="";
$scope.filters=false;




    $scope.categories = "";
    var idCat;
    $scope.categoryName = "";




    $scope.search = "";
    $scope.dane = "";
    $scope.searchingDetails = {
        search: "",  //czyli title
        category: "",
        priceDown: "",
        priceUp: "",
        newItem: true,
        secondHand: true

    };
// ***********taka rozdzielnia*****************
    $scope.searching=function(){

        if($scope.filters==true){
            $scope.filterSearchingResults();
            console.log("Wyszukiwanie z filtrami");
            console.log("filters: "+$scope.filters);
        }
        else{
            $scope.searchingResoults();
            console.log("Wyszukiwanie bez filtrów");
            console.log("filters: "+$scope.filters);
        }
    };

// ***********taka rozdzielnia*****************

    $scope.searchingResoults = function () {


        $http.get('http://localhost:8095/getSearched/' + $scope.search)
            .then(function (result) {
                    $scope.dane = result.data;


                }, function (result) {
                    $scope.dane = "blad pobrania odfiltrowanych wyników"
                }
            );
    };

    //********************WYSZUKIWANIE Z FILTRAMI*******************

//     $scope.setNewItem=function(){
//       // if($scope.searchingDetails.newItem==true){
//       //     $scope.searchingDetails.newItem="0";}
//       //     else if ($scope.searchingDetails.newItem==false){
//       //         $scope.searchingDetails.newItem="1";  }
//
//
//
// console.log($scope.searchingDetails.newItem);
//
//
//
//     };


    $scope.setCategoryId = function () {
        console.log($scope.searchingDetails.category);

        angular.forEach($scope.categories, function (value) {

            if (value.name == $scope.categoryName) {
                idCat = value.id;
            }

        });

        $scope.searchingDetails.category = idCat;

        console.log($scope.searchingDetails.category);
    };


    $scope.filterSearchingResults = function () {

        console.log("czy nowy: "+$scope.searchingDetails.newItem);
        console.log("czy stary: "+$scope.searchingDetails.secondHand);

        $scope.searchingDetails.search = $scope.search;

        //*********INTERPRETACJA NULL'I W FILTRACH*********************

        if (!$scope.searchingDetails.priceDown){
            $scope.searchingDetails.priceDown=0;
        }

        if (!$scope.searchingDetails.priceUp ){
            $scope.searchingDetails.priceUp=9999999;
        }

        //*********INTERPRETACJA NULL'I W FILTRACH*********************


       // $scope.searchingDetails.search = "ford";
         //$scope.searchingDetails.category = 1;
       // $scope.searchingDetails.priceDown = 200;
       // $scope.searchingDetails.priceUp = 20000;
      //    $scope.searchingDetails.newItem = true;
       //  $scope.searchingDetails.secondHand = 0;


        $http.get('http://localhost:8095/getFilterSearched/'
            + $scope.searchingDetails.search + "/"
            + $scope.searchingDetails.category + "/"
            + $scope.searchingDetails.priceDown + "/"
            + $scope.searchingDetails.priceUp + "/"
            + $scope.searchingDetails.newItem + "/"
            + $scope.searchingDetails.secondHand
        )

            .then(function (result) {
                    $scope.dane = result.data;


                }, function (result) {
                    $scope.dane = "blad pobrania odfiltrowanych wyników"
                }
            );


    };
    //********************WYSZUKIWANIE Z FILTRAMI*******************
    //*********************************** robocze************************
    $scope.loadCategories = function () {
        $http.get('http://localhost:8095/getAllCategories')
            .then(function (result) {

                    $scope.categories = result.data;
                    console.log($scope.categories);
                }, function (result) {

                    $scope.categories = ["blad zaladowania kategorii"];
                }
            );


    };


    //*********************************** robocze************************

};
