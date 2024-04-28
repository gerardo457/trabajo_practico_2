package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {
	
	private static List<Efemeride>efenmerides;

	public static void main(String[] args) {
		byte opc;
		Scanner sc = new Scanner(System.in);	
		do {
	    	System.out.println("\n========================================="+
	    			       "\n 1 – Crear efeméride " +
			               "\n 2 – Mostrar efemérides "+
				           "\n 3 – Eliminar efeméride "+
				           "\n 4 – Modificar efeméride "+
				           "\n 5 – Salir "+
				           "\n=========================================");
	    	              System.out.print(" Seleccione opcion: ");
	    	              try{
	    	                opc= sc.nextByte();
	    	              } catch (Exception e) {
	    	          		   System.out.println("Tiene que ingresar las opciones que indica el menu");
	    	          		   opc=5;
	    	              }
	    	             
	    	 switch(opc){       
	    	    case 1:        CrearEfemeride();
	    	    	break;
	    	    case 2:        MostrarEfemerides();
	    	    	break;
	    	    case 3:        EliminarEfemerides();
	    	    	break;
	    	    case 4:        ModificarEfemerides();
	    	    	break;
	    	    case 5:   System.out.println("fin de la operacion");
	    	    	break;
	    	    default:  System.out.println("opcion no valida");
	    	        break;
	    	 }
	    	
		}while(opc!=5);
	}
	
	
	public static void CrearEfemeride(){
		Scanner sc = new Scanner(System.in);	
		int nmes=0;
		String cadmes=null;
		  
		
	   if(efenmerides==null) {
			   efenmerides = new ArrayList<>();
	   }
	    System.out.print("Ingrese codigo: ");
		String codigo=sc.next();
		
		do {
		    try {
		    	System.out.print("ingrese numero del mes: ");
		    	cadmes = sc.next();
		    	nmes=Integer.parseInt(cadmes);
			}catch (Exception e) {
        		  System.out.println("\nERROR, solo se puede Ingreser numeros");
	        }finally {
	    	   if(nmes <= 0 || nmes>12 ) {
	    	     System.out.println("Ingrese numeros del (1-12) para los meses");}
	         }
		}while(nmes <= 0 || nmes>12 );
		
		for (Mes mes : Mes.values()) {
			if(mes.ordinal()==nmes-1) {
				cadmes = mes.name();
			}
		}
		
		int dia=0;
		boolean passdias=false;
		
		do {
		     try {
			      System.out.print("Ingrese dia: ");
				  String caddia=sc.next();
				  dia = Integer.parseInt(caddia);
				  if(dia>0 && dia<=31) {
				    if(dia<30 && nmes==2){
				        passdias=true;
				    }else if(dia<31 && (nmes==4 || nmes==6 || nmes==9 || nmes==11)){
				    	passdias=true;
				    }else if(nmes==1 || nmes==3 || nmes==5 || nmes==7 || nmes==8 || nmes==10 || nmes==12 ){
				    	passdias=true;
				    }
				  }
				  if(passdias==false) {
					  System.out.println("\nERROR, Ingrese el numero de dias correcto para cada mes");
				  }
		     } catch (Exception e) {
		    	  System.out.println("\nERROR, Ingrese numeros para los dias");
		     }
		}while(passdias==false);
		
		System.out.print("Ingrese detalles: ");
		String detalle = sc.next();
		
		efenmerides.add(new Efemeride(codigo, Mes.valueOf(cadmes), dia, detalle));
	}

	
	public static void MostrarEfemerides(){
		if(efenmerides==null) {
			 System.out.println("\nERROR, No se han registrados efemerides");
		}else {
			efenmerides.forEach(e->System.out.println(e));
		}
	}
	
	public static void EliminarEfemerides(){
		if(efenmerides==null) {
			 System.out.println("\nERROR, No se han registrados efemerides");
		}else {
		   Scanner sc = new Scanner(System.in);
		   boolean pass=false;
		   
		   System.out.print("Ingrese codigo: ");
		   String codigo=sc.next();
		   
		   Iterator iterator= efenmerides.iterator();
	    	  
	       while(iterator.hasNext()) {
	    	 Efemeride e = (Efemeride)iterator.next();
	    		
	    		if(e.getCodigo().equals(codigo)) {
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
	
	public static void ModificarEfemerides(){
		if(efenmerides==null) {
			 System.out.println("\nERROR, No se han registrados efemerides");
		}else {
			 Scanner sc = new Scanner(System.in);
			   
			   byte opt=0;
			   boolean encontrado=false;
			   
			   
			   System.out.print("ingrese codigo: ");
			   String cod = sc.next();
			   
			   for(int i=0;i<efenmerides.size();i++) {
				  if(cod.compareTo(efenmerides.get(i).getCodigo())==0) {
					encontrado=true;
					do {
				        System.out.println("\n======== Selecciona lo que quieras modificar ========");
				        System.out.println( "\n 1 - mes"+
                                            "\n 2 - dia"+
                                            "\n 3 - detalle"+
                                            "\n 4 – salir de modificar");
                      System.out.print("Elija una opcion: ");
                    try {
                  	  opt = sc.nextByte();
				      } catch (Exception e) {
				    	  System.out.println("\nERROR, Ingrese las opciones indicadas en el menu");
				    	  opt=5;
					  }          
                      switch(opt){       
			    	      case 1:    String cadmes=null;
			    	                 int nmes=0;
			    	    	         do {
			    	  		              try {
			    	  		    	           System.out.print("ingrese numero del mes: ");
			    	  		    	           cadmes = sc.next();
			    	  		                   nmes=Integer.parseInt(cadmes);
			    	  			        } catch (Exception e) {
			    	  	            	   	   System.out.println("\nERROR, solo se puede Ingreser numeros");
			    	  			        } finally {
			    	  			    	       if(nmes <= 0 || nmes>12 ) {
			    	  			    	          System.out.println("Ingrese numeros del (1-12) para los meses");}
			    	  			        }
			    	  		          
			    	  		         } while(nmes <= 0 || nmes>12 );
			    	  		
			    	  		         for (Mes mes : Mes.values()) {
			    	  		      	    if(mes.ordinal()==nmes-1) {
			    	  				       cadmes = mes.name();
			    	  			        }
			    	  		         }
			    	  		       
			    	  		         efenmerides.get(i).setMes(Mes.valueOf(cadmes));
			    	     	break;
			    	      case 2:      
			    	    	        int dia=0;
			    			        boolean passdias=false;
			    			        nmes = efenmerides.get(i).getMes().ordinal()+1;
			    			        
			    			        do {
			    			             try {
			    			            	   
			    				                System.out.print("Ingrese dia: ");
			    					            String caddia=sc.next();
			    					            dia = Integer.parseInt(caddia);
			    					            if(dia>0 && dia<=31) {
			    					                if(dia<30 && nmes==2){
			    					                   passdias=true;
			    					                }else if(dia<31 && (nmes==4 || nmes==6 || nmes==9 || nmes==11)){
			    					    	           passdias=true;
			    					                }else if(nmes==1 || nmes==3 || nmes==5 || nmes==7 || nmes==8 || nmes==10 || nmes==12 ){
			    					    	           passdias=true;
			    					                }
			    					            } 
			    					           if(passdias==false) {
			    						          System.out.println("\nERROR, Ingrese el numero de dias correcto para cada mes");
			    					            }
			    			              }catch (Exception e) {
			    			    	           System.out.println("\nERROR, Ingrese numeros para los dias");
			    			              }
			    			       } while(passdias==false);
			    			        
			    			         efenmerides.get(i).setDía(dia);   	    	            
			    	    	break;
			    	      case 3:     
			    	    	            System.out.print("Ingrese detalles: ");
			    			            String detalle=sc.next();
			    			            
			    			            efenmerides.get(i).setDetalle(detalle);
			    	    	  
				            break;
			    	     default:  System.out.println("opcion no valida");
			    	        break;
                       }
                  
				     }while(opt!=4);
			 }
		   }
			   if(encontrado==false) {
				   System.out.println("\nNo se encontro el efemeride"); }			 
	    }
	
	 }

}


