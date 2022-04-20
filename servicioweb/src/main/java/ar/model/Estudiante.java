package ar.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Estudiante {

	private String nombre;
	private String apellido;
	private int nroLegajo;
	private String carrera;
	private List<Materia> materias;
	private int edad;

	public Estudiante(String nombre, String apellido, int nroLegajo, String carrera, int edad) {
		this.nombre = new NotNullNotEmpty(nombre).value();
		this.apellido = new NotNullNotEmpty(apellido).value();
		this.nroLegajo = new NotNullNotEmpty(nroLegajo).valueNum();
		this.carrera = new NotNullNotEmpty(carrera).value();
		this.materias = new ArrayList<>();
		this.edad = new NotNullNotEmpty(edad).valueNum();
	}

	public void addMateria(Materia materia) {
		this.materias.add(materia);
	}

	public String nombre() {
		return nombre + " " + apellido;
	}

	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", apellido=" + apellido + ",Numero Legajo=" + nroLegajo + ",carrera="
				+ carrera + ",edad=" + edad + "]";
	}

	public Map<String, Object> toMap() {
		var map = new HashMap<String, Object>(
				Map.of("nombre", nombre, "apellido", apellido, "edad", edad, "legajo", nroLegajo, "carrera", carrera));

		if (this.materias != null && this.materias.size() > 0) {
			map.put("materias", materias.stream().map((m) -> m.toMap()).collect(Collectors.toList()));
		}

		return map;
	}

	public boolean containsLegajo(Integer legajo) {
		return this.nroLegajo == legajo;
	}

	public boolean containsApellido(String apellido) {
		return this.apellido.contains(apellido);
	}
}
