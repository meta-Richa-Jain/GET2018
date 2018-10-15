var userManagementApp = angular.module("userManagementApp", []);

userManagementApp.controller('userListController', userListController);

function userListController($scope, $http) {
    $http.get('user-data.json').then(function (response) {
        $scope.users = response.data;
    });

    $scope.totalUser = 3;

    $scope.addUser = function () {
        $scope.users.push({
            'id': $scope.totalUser + 1,
            'name': $scope.name,
            'contact': $scope.contact,
            'location': $scope.address
        });
    }

    $scope.editUser = function () {
        $scope.users.forEach(user => {
            if (user.id === $scope.id) {
                user.name = $scope.editedName;
                user.contact= $scope.editedContact;
                user.location= $scope.editedLocation;
            }
        });
    }

    $scope.setUserData = function(id) {
        $scope.users.forEach(user => {
            if (id === user.id) {
                $scope.id = user.id;
                $scope.editedName = user.name;
                $scope.editedContact = user.contact;
                $scope.editedLocation = user.location;
            }
        });

    };

    $scope.clearAll = function () {
        $scope.name = '';
        $scope.contact = '';
        $scope.location = '';
    };
}
