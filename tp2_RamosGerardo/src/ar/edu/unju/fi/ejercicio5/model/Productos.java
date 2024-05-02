package ar.edu.unju.fi.ejercicio5.model;

import ar.edu.unju.fi.model.Producto;

public class Productos {
   private Producto productos;  // del ejercicio1
   private boolean disponible;
   
public Productos(Producto productos, boolean disponible) {
	this.productos = productos;
	this.disponible = disponible;
}

@Override
public String toString() {
	return productos + ", disponible: " + disponible;
}

public Producto getProductos() {
	return productos;
}

public void setProductos(Producto productos) {
	this.productos = productos;
}

public boolean isDisponible() {
	return disponible;
}

public void setDisponible(boolean disponible) {
	this.disponible = disponible;
}



}
