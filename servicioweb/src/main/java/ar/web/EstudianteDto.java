package ar.web;

import java.util.ArrayList;

public class EstudianteDto {

	private String nombre;
	private String apellido;
	private int nroLegajo;
	private String carrera;
	private ArrayList<String> materias;
	private int edad;

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getNroLegajo() {
		return nroLegajo;
	}

	public void setNroLegajo(int nroLegajo) {
		this.nroLegajo = nroLegajo;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public ArrayList<String> getMaterias() {
		return materias;
	}

	public void setMaterias(ArrayList<String> materias) {
		this.materias = materias;
	}

}
