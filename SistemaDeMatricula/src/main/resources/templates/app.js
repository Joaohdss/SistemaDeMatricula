(function () {
const app = angular.module('pre_matricula', ['$scope',($scope)
    $scope.vm = {email='Email ccc',senha='Senha'}]);

app.controller('AppCtrl', AppCtrl);

function AppCtrl() {
    const vm = this;
    vm.msg = "oi (vindo do controller)";
  }
}());