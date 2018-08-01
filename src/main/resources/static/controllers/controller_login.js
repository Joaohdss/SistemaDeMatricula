(function () {
    const app = angular.module('pre_matricula');

    function cadastroAluno($scope, $http) {
		$http.post('http://localhost:8080/api/aluno/login',{
			"email": $scope.email,
			"senha": $scope.senha,
		}).then(function (success) {
			alert("Login com sucesso!");
		}, function (error) {
			alert("Senha ou emial inválido!");
		});
	};

    app.controller('Login', function ($scope, $http) {
        $scope.email = null;
        $scope.senha = null;
        $scope.tipoCadastro = "aluno";//estado defout

        $scope.envio = function () {
            if ($scope.senha > 0 || $scope.email > 0) {
                loginAluno($scope, $http);
            }
            else {
                alert("Email ou senha inválido!");
            }
        };
    });


}());