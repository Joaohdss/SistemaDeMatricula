(function () {
    const app = angular.module('pre_matricula');

    function cadastroAluno($scope, $http) {
		$http.post('http://localhost:8080/api/aluno/login',{
			"email": $scope.email,
			"senha": $scope.senha,
		}).then(function (success) {
            alert(success);
			alert("Login com sucesso!");
		}, function (error) {
			alert("Senha ou emial inválido!");
		});
	};

    app.controller('LoginCtrl', function LoginCtrl($scope, $http) {
        $scope.email = null;
        $scope.senha = null;
        $scope.tipoCadastro = "aluno";//estado defout

        $scope.envio = function () {
			if ($scope.senha.length > 0 || $scope.email.length > 0) {
				if ($scope.tipoCadastro === "aluno") {
					cadastroAluno($scope, $http);
				} else {
					cadastroCoordenador($scope, $http);
				}
			} else {
				alert("Email ou senha inválido!");
			}
		};
        
    });


}());