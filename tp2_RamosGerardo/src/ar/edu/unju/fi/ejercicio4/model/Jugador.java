package ar.edu.unju.fi.ejercicio4.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;

public class Jugador {
	private String nombre;
	private String apellido;
	private LocalDate fechadenac;
	private String nacionalidad;
	private float estatura;
	private float peso;
	private Posicion pos; 
	
	public Jugador(String nombre, String apellido, LocalDate fechadenac, String nacionalidad, float estatura,
			float peso, Posicion pos) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechadenac = fechadenac;
		this.nacionalidad = nacionalidad;
		this.estatura = estatura;
		this.peso = peso;
		this.pos = pos;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + ", Apellido: " + apellido + ", Fecha de nacimiento: " + fechadenac + ", Nacionalidad: "
				+ nacionalidad + ", Estatura: " + estatura + " mts, Peso:" + peso + "kg, Posicion: " + pos;
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

	public LocalDate getFechadenac() {
		return fechadenac;
	}

	public void setFechadenac(LocalDate fechadenac) {
		this.fechadenac = fechadenac;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public float getEstatura() {
		return estatura;
	}

	public void setEstatura(float estatura) {
		this.estatura = estatura;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public Posicion getPos() {
		return pos;
	}

	public void setPos(Posicion pos) {
		this.pos = pos;
	}
	
}

