package ar.edu.unlam.pb2.recuperatorio;

import java.util.Objects;

public class Poliza  {

	private Integer numeroDePoliza;
	private Persona asegurado;
	private Double sumaAsegurada;
	private Double prima;
	private final Double PREMIO_IMP = 1.2;
	private Boolean siniestro;

	

	public Poliza(Integer numeroDePoliza, Persona asegurado, Double sumaAsegurada, Double prima) {
		this.numeroDePoliza = numeroDePoliza;
		this.asegurado = asegurado;
		this.sumaAsegurada = sumaAsegurada;
		this.prima = prima;
		this.siniestro = false;
	}

	public Integer getNumeroDePoliza() {
		return numeroDePoliza;
	}

	public void setNumeroDePoliza(Integer numeroDePoliza) {
		this.numeroDePoliza = numeroDePoliza;
	}

	public Persona getAsegurado() {
		return asegurado;
	}

	public void setAsegurado(Persona asegurado) {
		this.asegurado = asegurado;
	}

	public Double getSumaAsegurada() {
		return sumaAsegurada;
	}

	public void setSumaAsegurada(Double sumaAsegurada) {
		this.sumaAsegurada = sumaAsegurada;
	}

	public Double getPrima() {
		return prima;
	}

	public void setPrima(Double prima) {
		this.prima = prima;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroDePoliza);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Poliza other = (Poliza) obj;
		return Objects.equals(numeroDePoliza, other.numeroDePoliza);
	}

	public Double getPremio() {
		return getPrima()*PREMIO_IMP;
	}
	
	protected Boolean getSiniestro() {
		return siniestro;
	}

	public Boolean fueRobado() {
		return false;
	}

	public Boolean tuvoAlgunAccidente() {
		return false;
	}
}
