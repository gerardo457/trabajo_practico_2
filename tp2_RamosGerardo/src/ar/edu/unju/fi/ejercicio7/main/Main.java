package ar.edu.unju.fi.ejercicio7.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio5.model.Productos;
import ar.edu.unju.fi.model.Producto;
import ar.edu.unju.fi.model.Producto.categoria;
import ar.edu.unju.fi.model.Producto.origenFabricacion;

public class Main {
     static List<Productos>prod;
	public static void main(String[] args) {
        
		byte opc;
		Scanner sc = new Scanner(System.in);
		
		precargardatos();
		
		do {
	    	System.out.println("\n========================================================"+
	    			       "\n 1 – Mostrar productos" +
			               "\n 2 – Mostrar los productos faltantes "+
				           "\n 3 – Incrementar los precios de los productos en un 20%"+
				           "\n 4 – Mostrar los productos que corresponden a la categoría Electrohogar y estén disponibles para la venta"+
				           "\n 5 – Ordenar los productos por precio de forma descendente"+
				           "\n 6 - Mostrar los productos con los nombres en mayúsculas"+
				           "\n 7 – Salir"+
				           "\n==========================================================");
	    	              System.out.print(" Seleccione opcion: ");
	    	            try {
	    	            	opc= sc.nextByte();
						} catch (Exception e) {
							System.out.println("Tiene que ingresar las opciones que indica el menu");
	    	          		opc=7;
						}
	    	
	    	 switch(opc) {       
	    	    case 1:        mostrarproductostrue();
	    	    	                        
	    	    	break;
	    	    case 2:        mostrarproductosfalse();
	    	    	            
	    	    	break;
	    	    case 3:        incrementarprecios();
	    	    	          
	    	    	break;
	    	    case 4:        mostrarelectrohogar();
	    	    	           
	    	       	break;
	    	    case 5:        ordenar();
	    	           
	    	       	break;
	    	    case 6:         mayusculas();
	    	           
	    	       	break;
	    	    case 7:   System.out.println("fin de la operacion");
	    	    	break;
	    	    default:  System.out.println("opcion no valida");
	    	        break;
	    	 }
	    	
		}while(opc!=7);
	}
	
	public static void precargardatos(){
		 if(prod==null) {
		   prod = new ArrayList<>();
		 }
		
		prod.add(new Productos(new Producto("1","noblextv",214000,origenFabricacion.valueOf("ARGENTINA"),categoria.valueOf("ELECTROHOGAR")),true));	
	    prod.add(new Productos(new Producto("2","redmi9",250000,origenFabricacion.valueOf("CHINA"),categoria.valueOf("TELEFONIA")),true));
	    prod.add(new Productos(new Producto("3","samsung S21",940000,origenFabricacion.valueOf("ARGENTINA"),categoria.valueOf("TELEFONIA")),true));	
	    prod.add(new Productos(new Producto("4","impresora hp",450000,origenFabricacion.valueOf("CHINA"),categoria.valueOf("INFORMATICA")),true));
	    prod.add(new Productos(new Producto("5","heladera tcl",644500,origenFabricacion.valueOf("CHINA"),categoria.valueOf("ELECTROHOGAR")),true));	
	    prod.add(new Productos(new Producto("6","NOTEBOOK ASUS",250000,origenFabricacion.valueOf("CHINA"),categoria.valueOf("INFORMATICA")),true));
	    prod.add(new Productos(new Producto("7","Tablet noblex",84500,origenFabricacion.valueOf("ARGENTINA"),categoria.valueOf("INFORMATICA")),false));	
	    prod.add(new Productos(new Producto("8","hidrolavadora",129999,origenFabricacion.valueOf("CHINA"),categoria.valueOf("HERRAMIENTAS")),false));
	    prod.add(new Productos(new Producto("9","placa de video",614000,origenFabricacion.valueOf("CHINA"),categoria.valueOf("ELECTROHOGAR")),true));	
	    prod.add(new Productos(new Producto("10","tostadora",34000,origenFabricacion.valueOf("URUGUAY"),categoria.valueOf("ELECTROHOGAR")),false));	
	    prod.add(new Productos(new Producto("11","teclado rgb",45650,origenFabricacion.valueOf("CHINA"),categoria.valueOf("INFORMATICA")),true));
	    prod.add(new Productos(new Producto("12","microndas",244500,origenFabricacion.valueOf("CHINA"),categoria.valueOf("ELECTROHOGAR")),true));	
	    prod.add(new Productos(new Producto("13","mouse",25400,origenFabricacion.valueOf("CHINA"),categoria.valueOf("INFORMATICA")),true));
	    prod.add(new Productos(new Producto("14","microfono",24500,origenFabricacion.valueOf("ARGENTINA"),categoria.valueOf("INFORMATICA")),false));	
	    prod.add(new Productos(new Producto("15","escalera",39999,origenFabricacion.valueOf("BRASIL"),categoria.valueOf("HERRAMIENTAS")),true));
	}
	
	public static void mostrarproductostrue() {
		Consumer<Productos> mostrar = p->System.out.println(p);
		
		Predicate<Productos> filterproductostrue = t -> t.isDisponible()==true;
		
		prod.stream().filter(filterproductostrue).forEach(mostrar);
	}
	
	public static void mostrarproductosfalse() {
        Predicate<Productos> filterproductostrue = t -> !t.isDisponible();	
		prod.stream().filter(filterproductostrue).forEach(System.out::println);
	}
	
	public static void incrementarprecios(){
		
		Function<Productos, Productos> aumento = (p)->{
			float res = p.getProductos().getPreciounitario()+ p.getProductos().getPreciounitario()*0.2f;
			p.getProductos().setPreciounitario(res);
			return p;
		}; 
		List<Productos>productosIncrementados= new ArrayList<>();
		
		productosIncrementados= prod.stream().map(aumento).collect(Collectors.toList());
		
	}
	
	public static void mostrarelectrohogar() {
		
		Predicate<Productos> filterelectrohogar = t -> t.isDisponible()==true && t.getProductos().getCategoria().equals(categoria.valueOf("ELECTROHOGAR"));
		
		prod.stream().filter(filterelectrohogar).forEach(System.out::println);
	}
	
	public static void ordenar() {
	    
		prod.sort(Comparator.comparing(p-> p.getProductos().getPreciounitario()));
		
		Collections.reverse(prod);
	
	}
	
	public static void mayusculas() {
		
		Function<Productos,Productos> mayus = (m)->{
			String nombre=m.getProductos().getDescripcion().toUpperCase();
			m.getProductos().setDescripcion(nombre);
			return m;
		};
		
		prod.stream().map(mayus).forEach(System.out::println);
	}
}
