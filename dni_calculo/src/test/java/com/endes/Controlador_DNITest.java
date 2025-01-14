/**
 * 
 */
package com.endes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 
 */
class Controlador_DNITest {
	
	ControladorDNI controlador;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		//System.out.println("@BeforeAll");
	}


	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		//System.out.println("@BeforeEach");
		controlador = new ControladorDNI();
	}

	
	//Prueba para verificar que el cálculo de la letra del DNI es correcto
	@Test
	void testEsValidoDNI() {
		//Caso de prueba válido
		String dniCorrecto = "11111111H";
		assertTrue(controlador.esValido(dniCorrecto));
	}
	
	@Test
	@DisplayName("Validación de entradas con letra incorrecta")
	void testEsFalsoDNI() {
		//Caso de prueba no válido
		String dniFalso = "11111111R";
		assertFalse(controlador.esValido(dniFalso));
	}
	
	//Prueba para manejar las entradas nulas, longitud incorrecta y caracteres invalidos
	
	@Test
	@DisplayName("Prueba de dni válido")
	void testEsValido_DNIEntradasInvalidas () {
		assertFalse(controlador.esValido(null), "Un DNI nulo fue reconocido como válido");
		
	}
	
	@Test
	@DisplayName("Un DNI demasiado corto")
	void testDNIcorto() {
		assertFalse(controlador.esValido("11111H"), "El DNI es demasiado corto");
	}
	
	@Test
	@DisplayName("DNI con caracteres no numéricos")
	void testDNIconCaracteresNoNumericos() {
		assertFalse(controlador.esValido("+2+3111+H"), "El DNI contiene caracteres numericos");
	}
}
