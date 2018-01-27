  app.controller('editController',   function ($scope, $http, myFactory,$location ) {

    $scope.idUzytkownika=myFactory.getUser();
var identity;

var allCategories2;
    $scope.pointer;

      $scope.edittedAdvertisment = {
          title: "",
          description: "",
          category: 0,
          user:0,
          price:"",
          ifNew: 0
      };
      $scope.advertToDelete;

      $scope.setAdvertToDelete=function(val){
          $scope.advertToDelete=val;
      };

//*****************************OBSŁUGA ZMIANY OBRAZU**********************************

      $scope.selectedUploadFile;
      $scope.uploadFile=function(){
          $scope.formData = new FormData();
          $scope.formData.append('file', $scope.selectedUploadFile);



          $http.post($location.protocol()+'://'+$location.host()+':'+$location.port()+'/api/addImage', $scope.formData, {
              transformRequest: angular.identity,
              headers: {'Content-Type': undefined},

          }).success(function(){
              console.info('udalo sie');
          });
      };

      $scope.removePhoto=function(){
          $scope.selectedUploadFile=null;
          $scope.filepreview=null;

      };


      $scope.showImage=function(){
          if(this.files&&this.files[0]){
              var obj = new FileReader();
              obj.onload = function(data){
                  var image = document.getElementById("image");
                  image.src = data.target.result;
                  image.style.display="block";


              };
              obj.readAsDataURL(this.files[0]);

          }
      };
$scope.hidePhoto=false;
      $scope.toHidePhoto=function(){
          $scope.hidePhoto=true;
      };


//*****************************/OBSŁUGA ZMIANY OBRAZU**********************************


    $scope.pokazMojeOgloszenia=function(){

        $http.get($location.protocol()+'://'+$location.host()+':'+$location.port()+'/userAdverts/' + $scope.idUzytkownika)

            .then(function (result) {
                    $scope.dane = result.data;
                }, function (result) {
                    $scope.singleAdvertisement = "blad pobrania odfiltrowanych wyników";
                }
            );


    };



      $scope.loadCategories = function () {
          $http.get($location.protocol()+'://'+$location.host()+':'+$location.port()+'/getAllCategories')
              .then(function (result) {

                      $scope.allCategories = result.data;

                  }, function (result) {

                      $scope.categories = ["blad zaladowania kategoriiii"];
                  }
              );

          allCategories2 = $scope.allCategories;
      };


      $scope.getAdvert=function(advertId){
          $http.get($location.protocol()+'://'+$location.host()+':'+$location.port()+'/current/' + advertId)

              .then(function (result) {
                      $scope.singleAdvertisment = result.data;
                  }, function (result) {
                      $scope.singleAdvertisment = "blad pobrania odfiltrowanych wyników";
                  }
              );
      };


    $scope.deleteAdvertisment=function(identity){
        $scope.pointer=identity;

//*******************usuwanie rekordu**********************
$http.post($location.protocol()+'://'+$location.host()+':'+$location.port()+'/deleteAdvert',$scope.pointer);
//*******************usuwanie rekordu**********************



        this.pokazMojeOgloszenia();
    };

    $scope.editAdvertisment=function(identity){

        $scope.uploadFile();


        $scope.pointer=identity;

        this.setCategoryId();
        $scope.edittedAdvertisment.user=$scope.idUzytkownika;

         if ($scope.edittedAdvertisment.title == ""){$scope.edittedAdvertisment.title=$scope.singleAdvertisment[0].title;}

        if($scope.edittedAdvertisment.description== "")$scope.edittedAdvertisment.description=$scope.singleAdvertisment[0].description;
        if($scope.edittedAdvertisment.price== "")$scope.edittedAdvertisment.price=$scope.singleAdvertisment[0].price;


         $scope.edittedAdvertisment.enclosingDate= $scope.singleAdvertisment[0].enclosingDate;

if($scope.hidePhoto==false){
   $http.post($location.protocol()+'://'+$location.host()+':'+$location.port()+'/api/addImage2',$scope.singleAdvertisment[0].image);


    // $scope.formData = new FormData();
    // $scope.formData.append('file', $scope.singleAdvertisment[0].image);
    // $http.post('http://localhost:8095/api/addImage2', $scope.formData, {
    //     transformRequest: angular.identity,
    //     headers: {'Content-Type': undefined},
    //
    // }).success(function(){
    //     console.info('udalo sie');
    // });
};







        $http.post($location.protocol()+'://'+$location.host()+':'+$location.port()+'/deleteAdvert',$scope.pointer);

        $http.post($location.protocol()+'://'+$location.host()+':'+$location.port()+'/newAdvert',$scope.edittedAdvertisment);

       // this.pokazMojeOgloszenia();

    };


      $scope.categories = "";
      var idCat;
      $scope.categoryName = "";

      $scope.setCategoryId = function () {


          angular.forEach($scope.allCategories, function (value) {

              if (value.name == $scope.categoryName) {
                  idCat = value.id;
              }

          });

         $scope.edittedAdvertisment.category=idCat;


      };





  });






