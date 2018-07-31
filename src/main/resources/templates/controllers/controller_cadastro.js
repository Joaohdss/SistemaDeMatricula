(function () {
	const app = angular.module('pre_matricula');

	function cadastroAluno($scope, $http){
		console.log("chegou na função");
		$http({
			method: 'POST' ,
			"matricula":$scope.matricula,
			"nome": $scope.nome,
			"email": $scope.email,
			"periodoInicial": $scope.periodoEntrada,
			"senha": $scope.senha1,
			"disciplinasPreMatriculadas":null,
			url: 'http://localhost:8080/api/aluno/post'
		});
		$scope.tipoCadastro = "cadastrado";

	};


	app.controller('CadastroCtrl', function CadastroCtrl($scope,$http) {
		//const vm = this;
		$scope.email = null;
		$scope.senha1 = null;
		$scope.senha2 = null;
		$scope.cor = "color:red";
		$scope.confirmSenha = "cancelar";
		$scope.nome = null;
		$scope.matricula = null;
		$scope.periodoEntrada = null;
		$scope.tipoCadastro = "aluno";//estado defaout

		$scope.envio = function () {
			cadastroAluno($scope,$http);
			console.log("passou pelo atributo");
		};

		setInterval(function checkSenha() {
			if (($scope.senha1 > 0) && ($scope.senha1 === $scope.senha2)) {
				$scope.cor = "color:green";
				$scope.confirmSenha = "check_circle";
			}
			else {
				$scope.cor = "color:red";
				$scope.confirmSenha = "cancelar";
			}
			if ($scope.matricula > 0) {
				$scope.periodoEntrada = $scope.matricula.charAt(1) + $scope.matricula.charAt(2) + "." + $scope.matricula.charAt(3);
			}
		}, 100)
	});

}());