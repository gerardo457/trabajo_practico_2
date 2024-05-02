package ar.edu.unju.fi.ejercicio5.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio5.model.Productos;
import ar.edu.unju.fi.model.Producto;
import ar.edu.unju.fi.model.Producto.categoria;
import ar.edu.unju.fi.model.Producto.origenFabricacion;

public class Main {
    public static List <Productos>prod;
    public static List <Productos> seleccionproductos;
    
    public static void main(String[] args) {
		precargardatos();
		
		byte opc;
		Scanner sc = new Scanner(System.in);
		
		do {
	    	System.out.println("\n========================================================"+
			               "\n 1 – Mostrar productos"+
				           "\n 2 – Realizar compra"+
				           "\n 3 – Salir "+
				           "\n==========================================================");
	    	              System.out.print(" Seleccione opcion: ");
	    	            try {
	    	            	opc= sc.nextByte();
						} catch (Exception e) {
							System.out.println("Tiene que ingresar las opciones que indica el menu");
	    	          		opc=3;
						}
	    	
	    	 switch(opc) {       
	    	    case 1:          
	    	    	         mostrarproductos();	    	    	                      
	    	    	break;
	    	    case 2:          
	    	    	          compra();   	    	         
	    	    	break;
	    	    case 3:   System.out.println("fin de la operacion");
	    	    	break;
	    	    default:  System.out.println("opcion no valida");
	    	        break;
	    	 }
	    	
		}while(opc!=3);
	}
	
	public static void precargardatos(){
		 if(prod==null) {
		   prod = new ArrayList<>();
		 }
		
		prod.add(new Productos(new Producto("1","nobletv",214000,origenFabricacion.valueOf("ARGENTINA"),categoria.valueOf("ELECTROHOGAR")),true));	
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
	
	public static void mostrarproductos() {
	   seleccionproductos= new ArrayList<>();
	   boolean compra=false;
	   byte opc;
	   Scanner sc = new Scanner(System.in);
	  
	   do {
		   System.out.println("\n========== PRODUCTOS =========");
		   prod.forEach(p->System.out.println(p));
		   System.out.println("\n========================================================"+
	                          "\n 1 – Agregar al carrito"+
		                      "\n 2 – Volver al menu"+
		                       "\n==========================================================");
	              System.out.print(" Seleccione opcion: ");
	            try {
	            	String opccad=sc.next();
	            	opc= Byte.parseByte(opccad);
				} catch (Exception e) {
					System.out.println("\nERROR, Tienes que ingresar las opciones que indica el menu");
					opc=3;
				}
	            
	            switch(opc) {
	            
	            case 1:  
	            	      boolean existe=false;
	            	      System.out.print("ingrese codigo del producto que quiere comprar: ");
	                      String seleccion = sc.next();
	                      for(int i=0;i<prod.size();i++) {
	                    	  if(seleccion.compareTo(prod.get(i).getProductos().getCodigo())==0) {
	                    		 existe=true;
	                    		 if(prod.get(i).isDisponible()==true) {
	                    		    seleccionproductos.add(prod.get(i));
	                    		    System.out.println("\n===== se agrego al carrito ======");
	                    		 }else {
	                    			System.out.println("\n===== el producto no se encuentra disponible ======");
	                    		 }
	                    	  }
	                      }
	                      
	                      if(existe==false) {
	                    	  System.out.println("\n===== El codigo ingresado no es valido =====");
	                      }
	                      
	            	break;
	            case 2:   System.out.println("\nVolviendo al menu...");
	                      compra=true;
	            	break;
	            default:  System.out.println("Opcion incorrecta");
	            }
		    
	   }while(compra==false);
	}
	
	public static void compra() {
		   byte opc;
		   Scanner sc = new Scanner(System.in);
	  if(seleccionproductos==null) {
	     System.out.println("\nPrimero seleccione lo que quiere comprar");}
	  else {
	    System.out.println("\n========================================================"+
                           "\n 1 – Pago efectivo"+
                           "\n 2 – Pago tarjeta"+
                           "\n==========================================================");
        System.out.print(" Seleccione opcion: ");
         try {
                String opccad =sc.next();
        	    opc= Byte.parseByte(opccad);
	     } catch (Exception e) {
        		System.out.println("Tiene que ingresar las opciones que indica el menu");
	        	opc=3;
         }
       
           
         switch(opc) {
          case 1:
             	   PagoEfectivo efectivo = new PagoEfectivo(LocalDate.now(),0);

        	       for(int i=0;i<seleccionproductos.size();i++) {
        	    	   efectivo.realizarPago(seleccionproductos.get(i).getProductos().getPreciounitario());
                   }
        	       efectivo.imprimirRecibo();
        	       seleccionproductos.clear();
         	break;
         case 2:  
        	       System.out.print("ingrese numero de tarjeta: ");
        	       String num= sc.next();
        	 
        	       PagoTarjeta tarjeta = new PagoTarjeta(num, LocalDate.now(),0);

	               for(int i=0;i<seleccionproductos.size();i++) {
	    	           tarjeta.realizarPago(seleccionproductos.get(i).getProductos().getPreciounitario());
                     }
	               tarjeta.imprimirRecibo();
	               seleccionproductos.clear();
         	break;
         default:  System.out.println("Opcion incorrecta");
         }
           
	   }
	
	}
	
	
}