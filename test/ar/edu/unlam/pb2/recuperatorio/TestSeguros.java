package ar.edu.unlam.pb2.recuperatorio;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSeguros{

	@Test
	public void queSePuedaEmitirUnaPolizaDeAutos() {
		final Integer NUMERO_DE_POLIZA = 1;
		final Double SUMA_ASEGURADA = 2000000.0, PRIMA = 5000.0, PREMIO = 6000.0;
		
		Persona asegurado = new Persona("Camila", 45987345, 24);
		Auto auto = new Auto("Ford", "Fiesta", 2010, SUMA_ASEGURADA);
		SegurosGenerales poliza = new PolizaDeAuto(NUMERO_DE_POLIZA, asegurado, SUMA_ASEGURADA, PRIMA);
		poliza.agregarBienAsegurado(auto);
	
		assertEquals(NUMERO_DE_POLIZA, ((Poliza)poliza).getNumeroDePoliza());
		assertEquals(auto, ((PolizaDeAuto)poliza).getAuto());
		assertEquals(asegurado, ((Poliza)poliza).getAsegurado());
		assertEquals(PREMIO, ((Poliza)poliza).getPremio());
	}
	
	@Test
	public void queSePuedaEmitirUnaPolizaDeVida() {
		final Integer NUMERO_DE_POLIZA = 1;
		final Double SUMA_ASEGURADA = 2000000.0, PRIMA = 5000.0, PREMIO = 6000.0;
		
		Persona asegurado = new Persona("Camila", 45987345, 24);
		Persona hijo = new Persona("Arturo", 65456231, 2);
		Persona conyuge = new Persona("Arturo", 65456231, 2);
		
		SegurosDeVida poliza = new PolizaAccidentesPersonales(NUMERO_DE_POLIZA, asegurado, SUMA_ASEGURADA, PRIMA);
		poliza.agregarBeneficiario(hijo, TipoDeBeneficiario.HIJO);
		poliza.agregarBeneficiario(conyuge, TipoDeBeneficiario.CONYUGE);
	
		
		assertEquals((Integer)2, poliza.obtenerCantidadDeBeneficiarios());
		assertEquals(asegurado, ((Poliza)poliza).getAsegurado());
		assertEquals(PREMIO, ((Poliza)poliza).getPremio());
	}
	
	
	@Test
	public void queSePuedaEmitirUnaPolizaDeCombinadoFamiliar() {
		final Integer NUMERO_DE_POLIZA = 1;
		final Double SUMA_ASEGURADA = 20000000.0, PRIMA = 50000.0, PREMIO = 60000.0;
		
		Vivienda casa = new Vivienda("Florencio Varela 1800", "San Justo", "La Matanza", "Buenos Aires");
		Persona asegurado = new Persona("Camila", 45987345, 24);
		Persona hijo = new Persona("Arturo", 65456231, 2);
		Persona hija = new Persona("Maia", 65445231, 4);
		Persona conyuge = new Persona("Arturo", 65456231, 2);
		
		PolizaCombinadoFamiliar poliza = new PolizaCombinadoFamiliar(NUMERO_DE_POLIZA, asegurado, SUMA_ASEGURADA, PRIMA);
		poliza.agregarBeneficiario(hijo, TipoDeBeneficiario.HIJO);
		poliza.agregarBeneficiario(hija, TipoDeBeneficiario.HIJA);
		poliza.agregarBeneficiario(conyuge, TipoDeBeneficiario.CONYUGE);
		poliza.agregarBienAsegurado(casa);
	
		assertEquals((Integer)3, poliza.obtenerCantidadDeBeneficiario());
		assertEquals(asegurado, poliza.getAsegurado());
		assertEquals(PREMIO, poliza.getPremio());
	}
	
	@Test
	public void queSePuedanAdministrarDistintosTiposDePolizas() {
		Integer numeroDePoliza = 1;
		CompaniaDeSeguro libra = new CompaniaDeSeguro("Libra");
	
		libra.agregarPoliza(new PolizaDeAuto(1, new Persona("Camila", 45987345, 24), 2000000.0, 5000.0));
		libra.agregarPoliza(new PolizaDeAuto(2, new Persona("Juan", 2745123, 24), 1500000.0, 4000.0));
		libra.agregarPoliza(new PolizaAccidentesPersonales(3, new Persona("Pedro", 455647345, 24), 2000000.0, 5000.0));
		libra.agregarPoliza(new PolizaCombinadoFamiliar(4, new Persona("Natalia", 45987345, 24), 2000000.0, 5000.0));
		libra.agregarPoliza(new PolizaDeAuto(4, new Persona("Victor", 652354, 24), 2000000.0, 5000.0));
		
		
		assertEquals((Integer)4, libra.obtenerLaCantidadDePolizasEmitidas());
	}
	

	
	@Test
	public void queSePuedaDenunciarElRoboDeUnAuto() throws PolizaInexistente {
		Integer numeroDePoliza = 1;
		CompaniaDeSeguro libra = new CompaniaDeSeguro("Libra");
		libra.agregarPoliza(new PolizaAccidentesPersonales(numeroDePoliza, new Persona("Pedro", 455647345, 24), 2000000.0, 5000.0));

		
		libra.denunciarSiniestro(1);
		
		assertTrue((libra.getPoliza(numeroDePoliza)).fueRobado());
		
	}
	
		
	@Test
	public void queSePuedaDenunciarUnSiniestroParaUnaPolizaDeVida() throws PolizaInexistente {
		Integer numeroDePoliza = 1;
		CompaniaDeSeguro libra = new CompaniaDeSeguro("Libra");
	
		libra.agregarPoliza(new PolizaAccidentesPersonales(numeroDePoliza, new Persona("Pedro", 455647345, 24), 2000000.0, 5000.0));
		
		libra.denunciarSiniestro(1);
		
		assertTrue(((PolizaAccidentesPersonales) libra.getPoliza(1)).tuvoAlgunAccidente());
		
	}
	
	@Test (expected = PolizaInexistente.class)
	public void verificarQueNoSePuedaDenunciarUnSiniestroParaUnaPolizaQueNoExista() throws PolizaInexistente {
		Integer numeroDePoliza = 1;
		CompaniaDeSeguro libra = new CompaniaDeSeguro("Libra");
	
		libra.agregarPoliza(new PolizaDeAuto(numeroDePoliza++, new Persona("Camila", 45987345, 24), 2000000.0, 5000.0));
		libra.agregarPoliza(new PolizaDeAuto(numeroDePoliza++, new Persona("Juan", 2745123, 24), 1500000.0, 4000.0));
		libra.agregarPoliza(new PolizaAccidentesPersonales(numeroDePoliza++, new Persona("Pedro", 455647345, 24), 2000000.0, 5000.0));
		libra.agregarPoliza(new PolizaCombinadoFamiliar(numeroDePoliza++, new Persona("Natalia", 45987345, 24), 2000000.0, 5000.0));

		libra.denunciarSiniestro(5);

	}

}

/*
 Enunciado
Una compañía de seguros es una empresa que se encarga de vender pólizas de
seguros.
Una póliza es un contrato entre un “Asegurado” y una “Compañía”, que establece
que ante la ocurrencia de un “Siniestro”, la compañía le debe pagar al asegurado el
importe de la suma asegurada acordada.
Hay distintos tipos de pólizas de seguro, pero en general pertenecen a dos grandes
grupos (no excluyentes entre sí):
Pólizas de Vida: Se asegura una persona, y en general el que cobra el seguro no es el
mismo asegurado.
Pólizas de seguros generales: Se asegura un bien, y en general el que cobra el
seguro ante un siniestro es el mismo asegurado.
Es importante señalar que existen pólizas que pueden ser tanto de vida (porque se
asegura a la persona) como general (porque se asegura el bien). Un ejemplo de esto
son las pólizas de combinado familiar que se puede asegurar la casa por robo, pero
también a las personas que viven en ella.
Otros conceptos relevantes:
Suma asegurada: Valor que está en juego. Ante un siniestro es el importe que la
compañía debe abonar ya sea al asegurado o a los beneficiarios según corresponda.
Prima: Importe que el asegurado le paga a la compañía para contratar el seguro.
Premio: Es la suma de la prima más los impuestos.
Beneficiario: Son los destinatarios del pago del seguro ante un siniestro, para el
caso de los seguros de vida. Pueden ser mas de uno. En nuestro ejemplo el pago se
divide en partes iguales.
 */
