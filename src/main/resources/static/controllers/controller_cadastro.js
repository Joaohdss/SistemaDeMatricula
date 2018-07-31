(function () {
	const app = angular.module('pre_matricula');

	function cadastroAluno($scope, $http) {
		$http.post('http://localhost:8080/api/aluno/post',{
			"matricula":$scope.matricula,
			"nome": $scope.nome,
			"email": $scope.email,
			"periodoInicial": $scope.periodoEntrada,
			"senha": $scope.senha1,
		}).then(function (success) {
			alert("Cadastrado com sucesso!");
		}, function (error) {
			alert("Não foi possível realizar o cadastro!");
		});
	};


	app.controller('CadastroCtrl', function CadastroCtrl($scope, $http) {
		$scope.email = null;
		$scope.senha1 = null;
		$scope.senha2 = null;
		$scope.cor = "color:red";
		$scope.confirmSenha = "cancelar";
		$scope.nome = null;
		$scope.matricula = null;
		$scope.periodoEntrada = null;
		$scope.tipoCadastro = "aluno";//estado defout

		$scope.envio = function () {
			if(($scope.senha1 > 0) && ($scope.senha1 === $scope.senha2)){
				cadastroAluno($scope, $http);}
			else {
				alert("Informações inválidas!");
			}
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
			/* if ($scope.matricula > 0) {
				$scope.periodoEntrada = parseInt($scope.matricula.charAt(1) + $scope.matricula.charAt(2) + "." + $scope.matricula.charAt(3));
			} */
		}, 100)
	});

}());