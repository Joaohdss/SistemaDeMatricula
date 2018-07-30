(function () {
	const app = angular.module('pre_matricula');

	app.controller('CadastroCtrl', function CadastroCtrl() {
		const vm = this;
		vm.email = "";
		vm.senha1 = "";
		vm.senha2 = "";
		vm.cor = "color:red";
		vm.confirmSenha = "cancelar";
		vm.nome = "";
		vm.matricula = "";
		vm.periodoEntrada = "";
		vm.tipoCadastro = "aluno";
		console.log(vm.tipoCadastro);

		setInterval(function checkSenha() {
			if ((vm.senha1.length > 0) && (vm.senha1 === vm.senha2)) {
				vm.cor = "color:green";
				vm.confirmSenha = "check_circle";
			}
			else {
				vm.cor = "color:red";
				vm.confirmSenha = "cancelar";
			}
			if (vm.matricula > 0) {
				vm.periodoEntrada = vm.matricula.charAt(1) + vm.matricula.charAt(2) + "." + vm.matricula.charAt(3);
			}
		}, 100)
	});

}());