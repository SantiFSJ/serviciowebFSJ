package ar.servicios;

import java.util.ArrayList;
import java.util.List;

import ar.model.Estudiante;

public interface Estudiantes {

	List<Estudiante> estudiantes(String apellido);

	List<Estudiante> estudiantes(Integer legajo);

	void crearEstudiante(String nombre, String apellido, int nroLegajo, String carrera, ArrayList<String> materias,
			int edad);

}
