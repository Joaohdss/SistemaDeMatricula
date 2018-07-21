package com.SistemaDeMatricula.SistemaDeMatricula.util;

public class Util {
	 
	 private static final String PADRAO_CPF = "\\d{3}.\\d{3}.\\d{3}-\\d{2}";
	 public static final String FORMATO_DATA = "dd/MM/yyyy";
	 
	 private Util() {
	 }
	 
	 public static boolean validaCpf(String cpf) {
	        return cpf.matches(PADRAO_CPF);
	 }
}
