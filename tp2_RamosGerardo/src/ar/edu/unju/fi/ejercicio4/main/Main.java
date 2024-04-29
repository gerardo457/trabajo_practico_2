package ar.edu.unju.fi.ejercicio4.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;


public class Main {
      private static List<Jugador>jugadores;
	public static void main(String[] args) {
		byte opc;
		Scanner sc = new Scanner(System.in);
		
		do {
	    	System.out.println("\n========================================================"+
	    			       "\n 1 – Alta de jugador" +
			               "\n 2 – Mostrar datos del jugador"+
				           "\n 3 – Modificar posicion de un jugador"+
				           "\n 4 – Eliminar un jugador"+
				           "\n 5 – Salir "+
				           "\n==========================================================");
	    	              System.out.print(" Seleccione opcion: ");
	    	            try {
	    	            	opc= sc.nextByte();
						} catch (Exception e) {
							System.out.println("Tiene que ingresar las opciones que indica el menu");
	    	          		opc=5;
						}
	    	
	    	 switch(opc) {       
	    	    case 1:        
	    	    	            Altadejugador(); 	            
	    	    	break;
	    	    case 2:     
	    	    	            Mostrajugador();
	    	    	break;
	    	    case 3:        
	    	    	            Modificarjugador();   
	    	    	break;
	    	    case 4:         
	    	    	            Eliminarjugador();
	    	       	break;
	    	    case 5:   System.out.println("fin de la operacion");
	    	    	break;
	    	    default:  System.out.println("opcion no valida");
	    	        break;
	    	 }
	    	
		}while(opc!=5);
	}
	
	
	public static void Altadejugador() {
	 	
		 if(jugadores == null) {
			jugadores = new ArrayList<>();
		 }
		 
		     boolean pass;
		     Scanner sc = new Scanner(System.in);
		     System.out.print("Ingrese nombre:");
            String nombre = sc.nextLine();
            System.out.print("Ingrese apellido:");
            String apellido = sc.nextLine();
            LocalDate fechaconformato;
            do {
                try {
           	       System.out.print("Ingrese fecha de nacimiento yyyy-mm-dd :");
       	           String fechasinformato = sc.next();
       	           fechaconformato = LocalDate.parse(fechasinformato);
       	           pass=true;
	     		} catch (Exception e) {
	     			   System.out.println("ERROR, La fecha esta mal ingresada");
				       fechaconformato = LocalDate.now();
			           pass=false;
			    }
            }while(pass==false);
            
            System.out.print("Ingrese nacionalidad:");
            String nacionalidad = sc.next();
            
            float estatura;
            do {
              try {
               	 System.out.print("Ingrese estatura en (mts):");
                    String Cadestatura=sc.next();
                    estatura = Float.parseFloat(Cadestatura);
                    pass = true;
			   }catch (Exception e) {
			     System.out.println("Error, La altura ingresada no es valida");
			     pass=false;
			     estatura= 0;
			   }
            }while(pass==false);
            
            
            float peso;
            do {
                try {
               	   System.out.print("Ingrese peso:");
                      String Cadpeso = sc.next();
                      peso = Float.parseFloat(Cadpeso);
                      pass = true;
 			    }catch (Exception e) {
 			           System.out.println("Error, El peso ingresado no es valido");
 			           pass=false;
 			           peso= 0;
 			       }
            } while(pass==false);
            
            
            int op=0;
           do {
        	   try {
                   System.out.println("\n====== Posicion ======");
                   System.out.println("1- Delantero");
                   System.out.println("2- Medio");
                   System.out.println("3- Defensa");
                   System.out.println("4- Arquero");
                   System.out.print("ingrese posicion:");
                   String cadop =sc.next();
                   op = Integer.parseInt(cadop);
                   pass=true;
   			    }catch (Exception e) {
   				   pass=false;
   				   System.out.println("\nError, solo puede ingresar numeros");
   			    }finally {
   			       if(op<1 || op >4) {
   			    	   pass=false;
   			    	   System.out.println("\nIngresar los numeros que indica el menu");
   			       }
   			    }
           }while(pass==false);
           
           String pos=null;
            for (Posicion p : Posicion.values()) {
				if(p.ordinal()==op-1) {
					pos = p.name();
				 }
			}
           	
            jugadores.add(new Jugador(nombre,apellido,fechaconformato,nacionalidad,estatura,peso,Posicion.valueOf(pos)));
		}          
	
	  /*
	   * Mostrar jugadores
	   * 
	   */
	
	  public static void Mostrajugador() {
		  
		Scanner sc = new Scanner(System.in);	
		
	    if(jugadores==null) {
	       System.out.println("\nNo hay jugadores registrados");
	    }else {
	      System.out.println("\n======= Jugadores =======");
	      jugadores.forEach(j->System.out.println(j));
	    }
	}
	  
	  /*
	   * 
	   * Modificar posicion
	   * 
	   */
	  
	  public static void  Modificarjugador(){
		  
		Scanner sc = new Scanner(System.in);
		boolean pass, encontrado=false;
		int op=0;
		
		if(jugadores==null) {
		   System.out.println("\nNo hay jugadores registrados");
	    }else {
	    	 System.out.print("Ingrese nombre: ");
             String nom = sc.nextLine();
             System.out.print("Ingrese apeliido: ");
             String ape = sc.nextLine();
             
             for(int i=0;i<jugadores.size();i++) {
            	 if(nom.compareTo(jugadores.get(i).getNombre())==0 && ape.compareTo(jugadores.get(i).getApellido())==0){
            		 encontrado=true;
            		 System.out.println("\n======Modificar posicion del jugador " +nom+" "+ape+"======");
            		 
                     do {
                  	      try {
                                System.out.println("\n====== Posicion ======");
                                System.out.println("1- Delantero");
                                System.out.println("2- Medio");
                                System.out.println("3- Defensa");
                                System.out.println("4- Arquero");
                                System.out.print("ingrese posicion:");
                                String cadop =sc.next();
                                op = Integer.parseInt(cadop);
                                pass=true;
             			 }catch (Exception e) {
             			        pass=false;
             				    System.out.println("\nError, solo puede ingresar numeros");
             			 }finally {
             			       if(op<1 || op >4) {
             			    	    pass=false;
             			    	    System.out.println("\nIngresar los numeros que indica el menu");
             			        }
             			 }
                   } while(pass==false);
                     
                     String pos=null;
                     for (Posicion p : Posicion.values()) {
          			  if(p.ordinal()==op-1) {
          					pos = p.name(); }
          			 }
                     jugadores.get(i).setPos(Posicion.valueOf(pos));
            	 }
             }
                 if(encontrado==false) {
                	 System.out.println("\nNo se encontro el jugador");}
	    }
		
   }
	  /*
	   * 
	   * Eliminar jugador
	   * 
	   */
	  
	  public static void Eliminarjugador() {
		  Scanner sc = new Scanner(System.in);
		  boolean pass=false;
		    if(jugadores==null) {
			   System.out.println("\nNo hay jugadores registrados");
		    }else {
		    	 System.out.print("Ingrese nombre: ");
	             String nom = sc.nextLine();
	             System.out.print("Ingrese apeliido: ");
	             String ape = sc.nextLine();
	             
	             Iterator iterator= jugadores.iterator();
	         
	  	       while(iterator.hasNext()) {
	  	    	 Jugador e = (Jugador)iterator.next();
	  	    		
	  	    		if(e.getNombre().equals(nom) && e.getApellido().equals(ape)) {
	  	    			pass=true;
	  	    			iterator.remove();
	  	    			System.out.println("\nSe ha eliminado correctamente");
	  	    		}    		
	  	    	 }
	  	    	 if(pass==false){
	  	    		 System.out.println("\nNo se encontro el efeméride");
	  	    	 }
		    
	      }
	  }

}
