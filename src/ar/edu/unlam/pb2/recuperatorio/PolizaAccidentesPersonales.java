package ar.edu.unlam.pb2.recuperatorio;

import java.util.HashMap;

public class PolizaAccidentesPersonales extends Poliza implements SegurosDeVida {
	private HashMap<Persona,TipoDeBeneficiario>beneficiarios;
	private Boolean tuvoAlgunAccidente;
	
	public PolizaAccidentesPersonales(Integer numeroPoliza, Persona asegurado, Double sumaAsegurada,
			Double prima) {
		super(numeroPoliza, asegurado,sumaAsegurada,prima);
		beneficiarios = new HashMap<Persona,TipoDeBeneficiario>();
		tuvoAlgunAccidente = false;
	}
	

	@Override
	public void agregarBeneficiario(Persona persona, TipoDeBeneficiario beneficiario) {
		beneficiarios.put(persona,beneficiario);
		
	}
	
	
	public Integer obtenerCantidadDeBeneficiarios() {
		return (Integer)beneficiarios.size();
	}

	public Boolean tuvoAlgunAccidente() {
		if(getSiniestro().equals(true)) {
			tuvoAlgunAccidente = true;
		}
		return tuvoAlgunAccidente;
	}
}
