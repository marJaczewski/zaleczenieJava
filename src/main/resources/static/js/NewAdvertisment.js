app.controller('newAdvertismentController', simpleController)

function simpleController($scope, $http, myFactory) {
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

    $scope.allCategories = "";

    $scope.idk = 0;
    $scope.temp = "";
    $scope.addAdvertisment = function () {
        //
        // zamiana nazwy kategorii na jej indentyfikator
        console.log($scope.newAdvertisment.category);

        angular.forEach(allCategories2, function (value) {

            $scope.temp = value.name;
            console.log($scope.temp);


            if ($scope.newAdvertisment.category == value.name) {
                $scope.idk = value.id;
                console.log("If działa" + value.id);
            }

        });
        $scope.newAdvertisment.category = $scope.idk;
        console.log($scope.idk);




        $http.post('http://localhost:8095/newAdvert', $scope.newAdvertisment);

    };
    $scope.simpleFunction = function () {

        var poleTextowe = document.getElementById("title")
        text = poleTextowe.value

    };

    $scope.loadCategories = function () {
        $http.get('http://localhost:8095/getAllCategories')
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
        $http.post('http://localhost:8095/api/addImage', $scope.formData, {
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

//
//
// app.directive("imgUpload", function ($http, $compile) {
//     return {
//         restrict: 'AE',
//         scope: {
//             url: "@",
//             method: "@"
//         },
//         template: '<input class="fileUpload" type="file" multiple />' +
//         '<div class="dropzone">' +
//         '<p class="msg">Click or Drag and Drop files to upload</p>' +
//         '</div>' +
//         '<div class="preview clearfix">' +
//         '<div class="previewData clearfix" ng-repeat="data in previewData track by $index">' +
//         '<img src={{data.src}}></img>' +
//         '<div class="previewDetails">' +
//         '<div class="detail"><b>Name : </b>{{data.name}}</div>' +
//         '<div class="detail"><b>Type : </b>{{data.type}}</div>' +
//         '<div class="detail"><b>Size : </b> {{data.size}}</div>' +
//         '</div>' +
//         '<div class="previewControls">' +
//         '<span ng-click="upload(data)" class="circle upload">' +
//         '<i class="fa fa-check"></i>' +
//         '</span>' +
//         '<span ng-click="remove(data)" class="circle remove">' +
//         '<i class="fa fa-close"></i>' +
//         '</span>' +
//         '</div>' +
//         '</div>' +
//         '</div>',
//         link: function (scope, elem, attrs) {
//             var formData = new FormData();
//             scope.previewData = [];
//
//             function previewFile(file) {
//                 var reader = new FileReader();
//                 var obj = new FormData().append('file', file);
//                 reader.onload = function (data) {
//                     var src = data.target.result;
//                     var size = ((file.size / (1024 * 1024)) > 1) ? (file.size / (1024 * 1024)) + ' mB' : (file.size / 1024) + ' kB';
//                     scope.$apply(function () {
//                         scope.previewData.push({
//                             'name': file.name, 'size': size, 'type': file.type,
//                             'src': src, 'data': obj
//                         });
//                     });
//                     console.log(scope.previewData);
//                 }
//                 reader.readAsDataURL(file);
//             }
//
//             function uploadFile(e, type) {
//                 e.preventDefault();
//                 var files = "";
//                 if (type == "formControl") {
//                     files = e.target.files;
//                 } else if (type === "drop") {
//                     files = e.originalEvent.dataTransfer.files;
//                 }
//                 for (var i = 0; i < files.length; i++) {
//                     var file = files[i];
//                     if (file.type.indexOf("image") !== -1) {
//                         previewFile(file);
//                     } else {
//                         alert(file.name + " is not supported");
//                     }
//                 }
//             }
//
//             elem.find('.fileUpload').bind('change', function (e) {
//                 uploadFile(e, 'formControl');
//             });
//
//             elem.find('.dropzone').bind("click", function (e) {
//                 $compile(elem.find('.fileUpload'))(scope).trigger('click');
//             });
//
//             elem.find('.dropzone').bind("dragover", function (e) {
//                 e.preventDefault();
//             });
//
//             elem.find('.dropzone').bind("drop", function (e) {
//                 uploadFile(e, 'drop');
//             });
//             scope.upload = function (obj) {
//
//
//               //   scope.selectedUploadFile;
//
//                     var formData = new FormData();
//                     formData.append('file',  obj.data);
//
//                 //
//                 //     $http.post('http://localhost:8090/postImage', formData, {
//                 //         transformRequest: angular.identity,
//                 //         headers: {'Content-Type': undefined},
//                 //
//                 //     }).success(function(){
//                 //         console.info('udalo sie');
//                 //     });
//                 // };
//
//
//
//
//
//
//
//                 $http({
//                     method: scope.method, url: scope.url, data:formData  ,
//                headers: {'Content-Type':   undefined}, transformRequest: angular.identity
//
//                 }).success(function (data) {
//
//                 });
//             }
//
//             scope.remove = function (data) {
//                 var index = scope.previewData.indexOf(data);
//                 scope.previewData.splice(index, 1);
//             }
//         }
//     }
// });