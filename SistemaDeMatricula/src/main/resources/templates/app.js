(function () {
const app = angular.module('pre_matricula', []);

app.controller('AppCtrl', AppCtrl);

function AppCtrl() {
    const vm = this;
    vm.msg = "oi (vindo do controller)";
    vm.email = "Email ccc";
    vm.senha = "Senha";
  }
}());