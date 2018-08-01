(function () {
    const app = angular.module('pre_matricula');

    function cadastroDisciplina($scope, $http) {
        $http.post('http://localhost:8080/api/post', {
            id: $scope.id,
            nome: $scope.nome,
            numeroDeCreditos: $scope.numeroDeCreditos,
            cargaHoraria: $scope.cargaHoraria,
            grade: $scope.grade,
            vagas: $scope.vagas
        }).then(function (success) {
            alert("Dicsiplina cadastrado com sucesso!");
        }, function (error) {
            alert("Não foi possível realizar o cadastro da Disciplina!");
        });
    };
    app.controller('DisciplinaCtrl', function DisciplinaCtrl($scope, $http) {
        $scope.id = null;
        $scope.nome = null;
        $scope.numeroDeCreditos = null;
        $scope.cargaHoraria = null;
        $scope.grade = null;
        $scope.vagas = null;
        $scope.envio = function () {
            if ( $scope.id > 0 && $scope.numeroDeCreditos > 0 &&
                $scope.cargaHoraria > 0 &&  $scope.vagas > 0 ) {
                cadastroDisciplina($scope, $http);
            }
            else {
                alert("Dados inválidos!");
            }
        };
    });
}());