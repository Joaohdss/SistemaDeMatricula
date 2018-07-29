(function () {
const app = angular.module('pre_matricula', []);

app.controller('AppCtrl', ['$vm', ($vm) => {


$vm.email = "Email ccc";
$vm.senha = "Senha";
$vm.contador = 0;
$vm.contar = () => $vm.contador++;

/* function AppCtrl() {
    const vm = this;
    vm.msg = "oi (vindo do controller)";
    vm.email = "Email ccc";
    vm.senha = "Senha";
    vm.contador = 0;
    vm.contar = () => contador++;
  
  }
function contador(){
    cont++;
} */
}]);
}());