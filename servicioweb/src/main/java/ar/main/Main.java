package ar.main;

import ar.jdbc.JdbcEstudiantes;
import ar.jdbc.JdbcLocalidades;
import ar.web.WebAPI;

public class Main {

	public static void main(String[] args) {
		WebAPI servicio = new WebAPI(new JdbcLocalidades(), new JdbcEstudiantes(), 1234);
		servicio.start();
	}
}
