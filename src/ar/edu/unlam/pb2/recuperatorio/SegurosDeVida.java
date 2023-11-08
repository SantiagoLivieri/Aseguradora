package ar.edu.unlam.pb2.recuperatorio;

public interface SegurosDeVida {

	void agregarBeneficiario(Persona parentesco, TipoDeBeneficiario tipoDeBeneficiario );
	
	public Integer obtenerCantidadDeBeneficiarios();
}
