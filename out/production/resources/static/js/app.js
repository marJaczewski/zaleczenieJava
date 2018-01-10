// var app = angular.module('mainModule', ['ngRoute','ngFileUpload']);
// var app = angular.module('mainModule', ['ngRoute']).run(function($rootScope){
//     $rootScope.test="app";
// });
var app = angular.module('mainModule', ['ngRoute']);
//////////////////////////////////////////////////////////////////////////////////
angular.module('mainModule')
    .directive('fileModel', function($parse){
        return {

            restrict : 'A',
            link:function (scope, element, attrs){
                var model = $parse(attrs.fileModel);
                var modelSetter = model.assign;

                element.bind('change', function(){
                    scope.$apply(function(){
                        modelSetter(scope, element[0].files[0]);
                    });
                });
            }
        };
    });
//////////////////////////////////////////////////////////////////////////////////
angular.module('mainModule')
.directive("fileinput", [function() {
    return {
        scope: {
            fileinput: "=",
            filepreview: "="
        },
        link: function(scope, element, attributes) {
            element.bind("change", function(changeEvent) {
                scope.fileinput = changeEvent.target.files[0];
                var reader = new FileReader();
                reader.onload = function(loadEvent) {
                    scope.$apply(function() {
                        scope.filepreview = loadEvent.target.result;
                    });
                }
                reader.readAsDataURL(scope.fileinput);
            });
        }
    }
}]);

//////////////////////////////////////////////////////////////////////////////////
app.config(function($routeProvider) {
    $routeProvider

        .when('/newAdvertisment', {
            templateUrl: 'pages/NewAdvertisment.html',
            controller: 'newAdvertismentController'
        })

        .when('/adverts', {
            templateUrl: 'pages/AllAdvertisments.html',
            controller: 'allAdvertismentsController'
        })

        .when('/about', {
            templateUrl: 'pages/about.html',
            controller: 'aboutController'
        })

        .when('/home', {
            templateUrl:'pages/home.html',
            controller:'homeController'
        })


           .when('/current/:id', {
            templateUrl: 'pages/Current.html',
            controller: 'currentController'
        })


        .when('/edit', {
            templateUrl: 'pages/Edit.html',
            controller: 'editController'

        })

        .when('/newCategory', {
            templateUrl: 'pages/NewCategory.html',
            controller: 'newCategoryController'
        })

        .when('/newUser',{
            templateUrl: 'pages/NewUser.html',
            controller: 'newUserController'
        })

        .when('/login', {
            templateUrl:"/pages/login.html",
            controller:'loginController'
        })

        .otherwise({
            redirectTo: '/home',
            controller: 'homeController'
        })

    // $locationProvider.html5Mode(true);
    // $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
});

