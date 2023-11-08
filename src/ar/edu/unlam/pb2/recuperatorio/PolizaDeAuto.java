package ar.edu.unlam.pb2.recuperatorio;


public class PolizaDeAuto extends Poliza implements SegurosGenerales{
	private Auto auto;
	
	public PolizaDeAuto(Integer numeroDePoliza, Persona asegurado, Double sumaAsegurada, Double prima) {
		super(numeroDePoliza,asegurado,sumaAsegurada,prima);
	}

	@Override
	public void agregarBienAsegurado(BienAsegurado bienAsegurado) {
	 auto = (Auto) bienAsegurado;
	 
	}

	public Auto getAuto() {
		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	

	

	

}
