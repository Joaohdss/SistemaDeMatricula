(function () {
    const app = angular.module('pre_matricula');

    function cadastroDisciplina($scope, $http) {
        $http.post('https://sistemadematriculaufcg.herokuapp.com/api/post', {
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

        $scope.envio = () => {
            if ($scope.id > 0 && $scope.numeroDeCreditos > 0 &&
                $scope.cargaHoraria > 0 && $scope.vagas > 0) {
                cadastroDisciplina($scope, $http);
            }
            else {
                alert("Dados inválidos!");
            }
        };
        //---------------Adicionar lista Disciplinas-----------------------------
        $scope.url_lista = null;
        $scope.listDisciplinas = [];

        $scope.cadastroLista = () => {
            $scope.listDisciplinas.map(materia => cadastroDisciplina(materia, $http) );
        }
        
        $scope.addLista = () => {
            if ($scope.url_lista == null) { alert("Insira uma URL!"); }
            else {
                $http.get($scope.url_lista)
                .then(responser =>  $scope.listDisciplinas = responser.data);
            }
        };
        
      
    
    });
}());
