package ar.edu.unlam.pb2.recuperatorio;

public class Vivienda {

	private String direccion;
	private String barrio;
	private String localidad;
	private String provincia;

	public Vivienda(String direccion, String barrio, String localidad, String provincia) {
	this.direccion = direccion;
	this.barrio = barrio;
	this.localidad = localidad;
	this.provincia = provincia;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

}
