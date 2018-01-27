app.controller('loginController', function($scope, $http, myFactory, $location){
    document.getElementById("anonymus").style.visibility = "visible";
    document.getElementById("user").style.visibility = "hidden";
    document.getElementById("admin").style.visibility = "hidden";



    $scope.loggedDetails={
    userId:0,
    role:"",
    email:""

};
    $scope.queryEmail="";
    $scope.password="";

$scope.doLogin=function(){


    $http.get($location.protocol()+'://'+$location.host()+':'+$location.port()+'/logging/'+$scope.queryEmail+'/'+$scope.password)
        .success(function(data){

$scope.loggedDetails=data;


if($scope.loggedDetails.role=="user"){
    document.getElementById("anonymus").style.visibility = "hidden";
    document.getElementById("user").style.visibility = "visible";
    document.getElementById("admin").style.visibility = "hidden";
}else if($scope.loggedDetails.role=="admin"){
    document.getElementById("anonymus").style.visibility = "hidden";
    document.getElementById("user").style.visibility = "hidden";
    document.getElementById("admin").style.visibility = "visible";
}else{
    document.getElementById("anonymus").style.visibility = "visible";
    document.getElementById("user").style.visibility = "hidden";
    document.getElementById("admin").style.visibility = "hidden";

}



            myFactory.setUser($scope.loggedDetails.userId);
            myFactory.setUserRole($scope.loggedDetails.role);
            myFactory.setLogged(true);
           myFactory.setUserEmail($scope.loggedDetails.email);

           console.log(myFactory.getUser());
            console.log(myFactory.getUserRole());
            console.log(myFactory.getUserEmail());

            alert("Zalogowano!");

            window.location.href = "#home";
        })
        .error(function (data) {
            console.log("bladLogowania");

                alert("Nie właściwe dane logowania!");

        })
};


    $scope.unLogging = function(){
        alert("Wylogowano");
        document.getElementById("anonymus").style.visibility = "visible";
        document.getElementById("user").style.visibility = "hidden";
        document.getElementById("admin").style.visibility = "hidden";
myFactory.setUser(0);
myFactory.setLogged(false);
myFactory.setUserRole("");
myFactory.setUserEmail("");


        console.log(myFactory.getUser());
        console.log(myFactory.getUserRole());
        console.log(myFactory.getUserEmail());


};



});


app.factory('myFactory', function () {
    var userId = 0;
    var logged = false;
    var userEmail;
    var userRole;

    var service = {};

    service.getUser = function () { return userId; };
    service.setUser = function (userIdService){ userId =  userIdService; };

    service.getLogged = function(){return logged};
    service.setLogged = function(loggedParam){logged=loggedParam};

    service.getUserRole = function (){return userRole};
    service.setUserRole = function (role) {userRole=role};

    service.getUserEmail = function (){return userEmail};
    service.setUserEmail = function (email){userEmail=email};
    return service;
});
