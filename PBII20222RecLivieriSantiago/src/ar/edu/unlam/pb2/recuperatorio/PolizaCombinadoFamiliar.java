package ar.edu.unlam.pb2.recuperatorio;
import java.util.HashMap;

public class PolizaCombinadoFamiliar extends Poliza implements SegurosDeVida {
	private HashMap<Persona,TipoDeBeneficiario>beneficiarios;
	private Vivienda vivienda;
	public PolizaCombinadoFamiliar(Integer numeroDePoliza, Persona asegurado, Double sumaAsegurada, Double prima) {
		super(numeroDePoliza, asegurado, sumaAsegurada, prima);
		beneficiarios = new HashMap<Persona,TipoDeBeneficiario>();
	}

	@Override
	public void agregarBeneficiario(Persona persona, TipoDeBeneficiario beneficiario) {
		beneficiarios.put(persona, beneficiario);
		
	}
	
	public void agregarBienAsegurado(Vivienda casa) {
		vivienda = (Vivienda)casa;
	}

	public Integer obtenerCantidadDeBeneficiario() {
		return beneficiarios.size();
	}
	public Vivienda getVivienda() {
		return vivienda;
	}

	@Override
	public Integer obtenerCantidadDeBeneficiarios() {
		return null;
	}

	

	
}