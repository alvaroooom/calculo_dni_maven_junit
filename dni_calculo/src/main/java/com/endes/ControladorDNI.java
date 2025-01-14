package com.endes;

import java.util.function.BooleanSupplier;

public class ControladorDNI {

	private final char[] LETRAS = {'T', 'R', 'W', 'A', 'G', 'M' ,'Y', 'F', 'P', 'D', 'X', 'B','N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 	'K', 'E'};
	private final int DIVISOR_DNI = 23;
	private final int LONGITUD_NUMERO_DNI = 8;
	private final int LONGITUD_DNI_COMPLETO = 9;
	
	/**
	 * Calcula la letra correspondiente a un número de DNI
	 * @param numeroDNI Cadena con el número del DNI (8 dígitos)
	 * @return la letra correspondiente al DNI
	 * @throws IllegalArgumentException Si el número tiene un formato inválido
	 */
	
	private char calcularLetra(String numeroDNI) {
		if(numeroDNI == null || numeroDNI.length() != LONGITUD_NUMERO_DNI || !numeroDNI.matches("\\d+")) {
			throw new IllegalArgumentException("El número del DNI no es válido");
		}
		int numero = Integer.parseInt(numeroDNI);
		int resto = numero % DIVISOR_DNI;
		return LETRAS[resto];
	}
	/**
	 * Verifica si un DNI completo es válido 
	 * @param dniCompleto DNI completo con 8 dígitos y 1 letra
	 * @return true si el DNi es válido, false si es en caso contrario
	 */
	
	public boolean esValido(String dniCompleto) {
		if(dniCompleto == null || dniCompleto.length() != LONGITUD_DNI_COMPLETO) {
			return false;
		}
		try {
			String numero = dniCompleto.substring(0, LONGITUD_NUMERO_DNI);
			char letraProporcionada = Character.toUpperCase(dniCompleto.charAt(8));
			return letraProporcionada == calcularLetra(numero);
			
		}catch(IllegalArgumentException exception) {
			return false;
		}
	}
	/**
	 * Genera un DNI aleatorio válido
	 * @return un DNI válido en formato cadena
	 */
	/*
	public String generarAleatorioDNI() {
		int numeroAleatorio = (int) (Math.random() * 10000000);
		String numeroDNI = String.format("%08d", numeroAleatorio);
		char Letra = calcularLetra(numeroDNI);
	}*/
}
