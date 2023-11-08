package ar.edu.unlam.pb2.recuperatorio;

public class Auto implements BienAsegurado{

	private Double sumaAsegurada;
	private Integer anio;
	private String modelo;
	private String marca;

	public Auto(String marca, String modelo, Integer anio, Double sumaAsegurada) {
		this.marca = marca;
		this.modelo = modelo;
		this.anio = anio;
		this.sumaAsegurada = sumaAsegurada;
	}

	public Double getSumaAsegurada() {
		return sumaAsegurada;
	}

	public void setSumaAsegurada(Double sumaAsegurada) {
		this.sumaAsegurada = sumaAsegurada;
	}

	public Integer getAnio (){
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	

}
