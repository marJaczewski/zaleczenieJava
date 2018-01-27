app.controller('newAdvertismentController', simpleController)

function simpleController($scope, $http, myFactory, $location) {
    $scope.napis = "";
    var allCategories2;

    $scope.newAdvertisment = {
        title: "",
        description: "",
        category: 0,
        user:0,
        price:"",
        ifNew: 0
    };

    $scope.newAdvertisment.user=myFactory.getUser();

    $scope.mail=myFactory.getUserEmail();

    $scope.allCategories = "";

    $scope.idk = 0;
    $scope.temp = "";
    $scope.addAdvertisment = function () {
        $scope.uploadFile();
        // zamiana nazwy kategorii na jej indentyfikator
        console.log($scope.newAdvertisment.category);

        angular.forEach(allCategories2, function (value) {

            $scope.temp = value.name;
            console.log($scope.temp);


            if ($scope.newAdvertisment.category === value.name) {
                $scope.idk = value.id;
                console.log("If działa" + value.id);
            }

        });
        $scope.newAdvertisment.category = $scope.idk;
        console.log($scope.idk);




        $http.post($location.protocol()+'://'+$location.host()+':'+$location.port()+'/newAdvert', $scope.newAdvertisment);

    };
    $scope.simpleFunction = function () {

        var poleTextowe = document.getElementById("title")
        text = poleTextowe.value

    };

    $scope.loadCategories = function () {
        $http.get($location.protocol()+'://'+$location.host()+':'+$location.port()+'/getAllCategories')
            .then(function (result) {

                    $scope.allCategories = result.data;

                }, function (result) {

                    $scope.categories = ["blad zaladowania kategorii"];
                }
            );

        allCategories2 = $scope.allCategories;
    };




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


}
