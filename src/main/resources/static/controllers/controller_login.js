(function () {
    const app = angular.module('pre_matricula');

    function loginAluno($scope, $http) {
        alert(testes);
		$http.post('http://localhost:8080/api/aluno/login',{
			"email": $scope.email,
			"senha": $scope.senha,
		}).then(function (success) {
			alert("Login com sucesso!");
		}, function (error) {
			alert(error);
		});
	};
//ACCEPTED

function loginCoordenador($scope, $http) {
    alert(testes);
    $http.post('http://localhost:8080/api/coord/login',{
        "email": $scope.email,
        "senha": $scope.senha,
    }).then(function (success) {
        alert("Login com sucesso!");
    }, function (error) {
        alert(error);
    });
};

    app.controller('LoginCtrl', function LoginCtrl($scope, $http) {
        $scope.email = null;
        $scope.senha = null;
        $scope.tipoCadastro = "aluno";//estado defout

        $scope.envio = function () {
            alert(testes);
			if ($scope.senha.length > 0 || $scope.email.length > 0) {
				if ($scope.tipoCadastro === "aluno") {
					loginAluno($scope, $http);
				} else {
					loginCoordenador($scope, $http);
				}
			} else {
				alert("Email ou senha inválido!");
			}
		};
        
    });


}());