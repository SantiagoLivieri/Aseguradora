package ar.edu.unlam.pb2.recuperatorio;

import java.util.HashSet;
import java.util.Objects;

public class CompaniaDeSeguro {
	private HashSet<Poliza>polizas;
	private String nombre;
	
public CompaniaDeSeguro(String nombre) {
		this.nombre = nombre;
		polizas = new HashSet<Poliza>();
	}

public HashSet<Poliza> getPolizas() {
	return polizas;
}

public void setPolizas(HashSet<Poliza> polizas) {
	this.polizas = polizas;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

@Override
public int hashCode() {
	return Objects.hash(nombre);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	CompaniaDeSeguro other = (CompaniaDeSeguro) obj;
	return Objects.equals(nombre, other.nombre);
}

public void agregarPoliza(Poliza poliza) {
	polizas.add(poliza);
	
}

public Integer obtenerLaCantidadDePolizasEmitidas() {
	return polizas.size();
}

public Poliza getPoliza(Integer numeroPoliza) {
	Poliza polizaObtenida = null;
	for (Poliza poliza : polizas) {
		if(poliza.getNumeroDePoliza().equals(numeroPoliza)) {
			polizaObtenida = poliza;
		}
	}
	return polizaObtenida;
}

public void denunciarSiniestro(int i) {
	
	
}

}