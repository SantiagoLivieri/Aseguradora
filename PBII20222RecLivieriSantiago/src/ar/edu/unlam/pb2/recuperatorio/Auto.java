package ar.edu.unlam.pb2.recuperatorio;

public class Auto implements BienAsegurado{

	private Double sumaAsegurada;
	private Integer a�o;
	private String modelo;
	private String marca;

	public Auto(String marca, String modelo, Integer a�o, Double sumaAsegurada) {
		this.marca = marca;
		this.modelo = modelo;
		this.a�o = a�o;
		this.sumaAsegurada = sumaAsegurada;
	}

	public Double getSumaAsegurada() {
		return sumaAsegurada;
	}

	public void setSumaAsegurada(Double sumaAsegurada) {
		this.sumaAsegurada = sumaAsegurada;
	}

	public Integer getA�o() {
		return a�o;
	}

	public void setA�o(Integer a�o) {
		this.a�o = a�o;
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
