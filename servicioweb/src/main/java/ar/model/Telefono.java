package ar.model;

import java.util.Map;

public class Telefono {

 private String numero;

 public Telefono(String numero) {
  this.numero = numero;
 }

 public String numero() {
  return numero;
 }

 public Map<String, String> toMap() {
  return Map.of("numero", numero);
 }

 @Override
 public String toString() {
  return "Telefono [numero=" + numero + "]";
 }

}
