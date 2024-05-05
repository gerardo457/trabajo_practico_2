package ar.edu.unju.fi.ejercicio6.model;

public class FelinoSalvaje {
	private String Nombre;
	private Byte Edad;
	private float Peso;
	
	public FelinoSalvaje(String nombre, Byte edad, float peso) {
		Nombre = nombre;
		Edad = edad;
		Peso = peso;
	}
	
	@Override
	public String toString() {
		return "FelinoSalvaje [Nombre=" + Nombre + ", Edad=" + Edad + ", Peso=" + Peso + "]";
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public Byte getEdad() {
		return Edad;
	}

	public void setEdad(Byte edad) {
		Edad = edad;
	}

	public float getPeso() {
		return Peso;
	}

	public void setPeso(float peso) {
		Peso = peso;
	}
	
	
	
}
