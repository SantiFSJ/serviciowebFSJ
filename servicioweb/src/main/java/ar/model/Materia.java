package ar.model;

import java.util.Map;

public class Materia {
	private String nombre;

	public Materia(String nombre) {
		this.nombre = nombre;
	}

	public String nombre() {
		return this.nombre;
	}

	public Map<String, Object> toMap() {
		return Map.of("nombre", nombre);
	}

}
