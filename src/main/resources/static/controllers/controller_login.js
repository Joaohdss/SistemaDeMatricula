(function () {
    const app = angular.module('pre_matricula');

    function loginAluno($scope, $http) {
        $http.post('https://sistemadematriculaufcg.herokuapp.com/api/aluno/login', {
			"email": $scope.email,
			"senha": $scope.senha,
		}).then(function (success) {
			alert("Login com sucesso!");
		}, function (error) {
			alert("Email ou senha invalido!");
		});
	};
//ACCEPTED

function loginCoordenador($scope, $http) {
    $http.post('https://sistemadematriculaufcg.herokuapp.com/api/coord/login',{
        "email": $scope.email,
        "senha": $scope.senha,
    }).then(function (success) {
        alert("Login com sucesso!");
    }, function (error) {
        alert("Email ou senha invalido!");
    });
};

    app.controller('LoginCtrl', function LoginCtrl($scope, $http) {
        $scope.email = null;
        $scope.senha = null;
        $scope.tipoCadastro = "aluno";//estado defout

        $scope.envio = function () {
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