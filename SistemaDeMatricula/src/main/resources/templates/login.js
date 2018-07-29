(function () {
const app = angular.module('pre_matricula');

app.controller('Contador',Contador)


function Contador(){
    vm.contador = 0;
    vm.contador++;
};

}());