app.controller('loginController', function(){




});


app.factory('myFactory', function () {
    var _user = 10;
    var service = {}

    service.getUser = function () {
        return _user
    };

    return service;
});
