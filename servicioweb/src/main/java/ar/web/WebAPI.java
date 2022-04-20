package ar.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ar.model.Estudiante;
import ar.model.Localidad;
import ar.model.PersonaException;
import ar.servicios.Estudiantes;
import ar.servicios.Localidades;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class WebAPI {

	private Estudiantes estudiantes;
	private Localidades localidades;
	private int webPort;

	public WebAPI(Localidades localidades, Estudiantes estudiantes, int webPort) {
		this.estudiantes = estudiantes;
		this.localidades = localidades;
		this.webPort = webPort;
	}

	public void start() {
		Javalin app = Javalin.create(config -> {
			config.enableCorsForAllOrigins();
		}).start(this.webPort);
		app.get("/Estudiantes", traerEstudiantes());
		app.get("/EstudianteLegajo", traerEstudiantePorLegajo());
		// app.get("/localidades", traerLocalidades());
		app.post("/estudiantes", crearEstudiante());

		app.exception(PersonaException.class, (e, ctx) -> {
			ctx.json(Map.of("result", "error", "message", e.getMessage()));
			// log error in a stream...
		});

		app.exception(Exception.class, (e, ctx) -> {
			ctx.json(Map.of("result", "error", "message", "Ups... algo se rompió.: " + e.getMessage()));
			// log error in a stream...
		});
	}

	private Handler traerLocalidades() {
		return ctx -> {
			var localidades = this.localidades.localidades();
			var list = new ArrayList<Map<String, Object>>();
			for (Localidad l : localidades) {
				list.add(l.toMap());
			}
			ctx.json(Map.of("result", "success", "localidades", list));
		};
	}

	private Handler crearEstudiante() {
		return ctx -> {

			EstudianteDto dto = ctx.bodyAsClass(EstudianteDto.class);

			this.estudiantes.crearEstudiante(dto.getNombre(), dto.getApellido(), dto.getNroLegajo(), dto.getCarrera(),
					dto.getMaterias(), dto.getEdad());

			ctx.json(Map.of("result", "success"));
		};
	}

	private Handler traerEstudiantes() {
		return ctx -> {

			String apellido = ctx.queryParam("Apellido");
			List<Estudiante> estudiantes = this.estudiantes.estudiantes(apellido);

			var list = new ArrayList<Map<String, Object>>();

			for (Estudiante e : estudiantes) {
				list.add(e.toMap());
			}

			ctx.json(Map.of("result", "success", "estudiantes", list));

		};
	}

	private Handler traerEstudiantePorLegajo() {
		return ctx -> {

			String nroLegajo = ctx.queryParam("legajo");

			List<Estudiante> estudiantes = this.estudiantes.estudiantes(Integer.parseInt(nroLegajo));

			var list = new ArrayList<Map<String, Object>>();

			for (Estudiante e : estudiantes) {
				list.add(e.toMap());
			}

			ctx.json(Map.of("result", "success", "estudiantes", list));

		};
	}
}
