package ar.model;

import java.util.Map;

public class Direccion {

 private String direccion;
 
 public Direccion(String direccion) {
  this.direccion = direccion;
 }
 
 public String direccion() {
  return direccion;
 }
 
 public Map<String, String> toMap() {
  return Map.of("direccion", direccion);
 }

 @Override
 public String toString() {
  return "Direccion [direccion=" + direccion + "]";
 }
}
