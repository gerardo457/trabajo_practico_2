package ar.edu.unju.fi.ejercicio3.main;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {
    
	public static void main(String[] args) {
		
	     List<Provincia> lista = new ArrayList<>();
	 
	  	for (Provincia provincias : Provincia.values()) {
	  		lista.add(provincias);
	  		System.out.println("\nNombre: "+ provincias.name());
			System.out.println("Cantidad de habitantes: "+ provincias.getCantidad());
			System.out.println("Superficie: "+ provincias.getSuperficie()+"km²");
			System.out.println("Densidad poblacional: "+ provincias.densidadpoblacional());
		}
	 	
	}

}
