package ar.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.model.Estudiante;
import ar.model.Materia;
import ar.servicios.Estudiantes;

public class JdbcEstudiantes implements Estudiantes {

	// constructor con dependencias

	@Override
	public List<Estudiante> estudiantes(String apellido) {
		Materia m1 = new Materia("Orientacion a Objetos 1");
		Materia m4 = new Materia("AYED");
		Materia m2 = new Materia("Quimica III");
		Materia m3 = new Materia("Derecho Penal IV");

		Estudiante e1 = new Estudiante("Joaquin", "Garcia", 21456, "Lic en Sistemas", 20);
		Estudiante e2 = new Estudiante("Emilio", "Peroz", 22123, "Ing en Agronomia", 24);
		Estudiante e3 = new Estudiante("Ernesto", "Perez", 27753, "Abogacia", 22);

		e1.addMateria(m1);
		e1.addMateria(m4);
		e2.addMateria(m2);
		e3.addMateria(m3);

		var estudiantes = List.of(e1, e2, e3);

		if (apellido == null || apellido.isEmpty())
			return estudiantes;

		return estudiantes.stream().filter((e) -> {
			return e.containsApellido(apellido);
		}).collect(Collectors.toList());
	}

	@Override
	public List<Estudiante> estudiantes(Integer legajo) {
		Materia m1 = new Materia("Orientacion a Objetos 1");
		Materia m4 = new Materia("AYED");
		Materia m2 = new Materia("Quimica III");
		Materia m3 = new Materia("Derecho Penal IV");

		Estudiante e1 = new Estudiante("Joaquin", "Garcia", 21456, "Lic en Sistemas", 20);
		Estudiante e2 = new Estudiante("Emilio", "Peroz", 22123, "Ing en Agronomia", 24);
		Estudiante e3 = new Estudiante("Ernesto", "Perez", 27753, "Abogacia", 22);

		e1.addMateria(m1);
		e1.addMateria(m4);
		e2.addMateria(m2);
		e3.addMateria(m3);

		var estudiantes = List.of(e1, e2, e3);

		if (legajo == null || legajo == 0)
			return estudiantes;

		return estudiantes.stream().filter((e) -> {
			return e.containsLegajo(legajo);
		}).collect(Collectors.toList());
	}

	@Override
	public void crearEstudiante(String nombre, String apellido, int nroLegajo, String carrera,
			ArrayList<String> materias, int edad) {

		Estudiante e = new Estudiante(nombre, apellido, nroLegajo, carrera, edad);
		// e.addDireccion(direccion);
		// e.addTelefonos(telefonos);
		for (String s : materias) {
			e.addMateria(new Materia(s));
		}
		System.out.println(e.toString());

	}
}
