package ar.jdbc;

import java.util.List;

import ar.model.Materia;
import ar.servicios.Materias;

public class JdbcMaterias implements Materias {

	@Override
	public List<Materia> materias() {
		Materia m1 = new Materia("Orientacion a Objetos 1");
		Materia m2 = new Materia("AYED");
		Materia m3 = new Materia("Matematica II");
		Materia m4 = new Materia("Bases de Datos 1");

		var materias = List.of(m1, m2, m3, m4);

		return materias;

	}

}
