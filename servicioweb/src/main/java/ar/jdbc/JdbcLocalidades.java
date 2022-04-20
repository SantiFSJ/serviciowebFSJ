package ar.jdbc;

import java.util.List;

import ar.model.Localidad;
import ar.servicios.Localidades;

public class JdbcLocalidades implements Localidades {

 @Override
 public List<Localidad> localidades() {
  return List.of(new Localidad("Viedma"), new Localidad("General Roca"),
    new Localidad("Carmen de Patagones"), new Localidad("Bariloche"));
 }

}
