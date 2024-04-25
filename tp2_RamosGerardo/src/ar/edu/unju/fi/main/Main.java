package ar.edu.unju.fi.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.model.Producto;
import ar.edu.unju.fi.model.Producto.categoria;
import ar.edu.unju.fi.model.Producto.origenFabricacion;

public class Main {
	private static List<Producto> productos;
  
	public static void main(String[] args) {
		   
				byte opc;
				Scanner sc = new Scanner(System.in);	
				do {
			    	System.out.println("\n========================================="+
			    			       "\n 1 – Crear Producto " +
					               "\n 2 – Mostrar productos "+
						           "\n 3 – Modificar producto "+
						           "\n 4 – Salir "+
						           "\n=========================================");
			    	              System.out.print(" Seleccione opcion: ");
			    	              try{
			    	                opc= sc.nextByte();
			    	              } catch (Exception e) {
			    	          		   System.out.println("Tiene que ingresar las opciones que indica el menu");
			    	          		   opc=4;
			    	              }
			    	             
			    	 switch(opc){       
			    	    case 1:        Crearproducto();
			    	    	break;
			    	    case 2:        Mostrarproducto();  
			    	    	break;
			    	    case 3:        Modificarproducto();
			    	    	break;
			    	    case 4:   System.out.println("fin de la operacion");
			    	    	break;
			    	    default:  System.out.println("opcion no valida");
			    	        break;
			    	 }
			    	
				}while(opc!=4);
			}
	
	   /*
	    * 
	    *
	   */
	   public static void Crearproducto(){
		   if(productos==null) {
			   productos = new ArrayList<>();
		   }
		   Scanner sc = new Scanner(System.in);
		   boolean pass=false;
		   byte opcion = 0;
		   
		   System.out.print("ingrese el codigo del producto: ");
		   String codigo = sc.next();
		   
		   System.out.print("ingrese descripcion: ");
		   String descripcion = sc.next();
		   
		   float precio=0;
		   do {
	        	 try {
			           pass=true;
			           System.out.print("ingrese precio unitario: ");
			           String preciocad = sc.next();
			           precio = Float.parseFloat(preciocad); 
		         } catch (Exception e) {
	          		System.out.println("\nERROR, Ingrese datos validos");
			        pass=false;
		         }
		   }while(pass==false);
		 
		   do { 
	        	try {    
	        		     pass=true;
	        		     System.out.println("\n===== Origen de fabricación ====="+ 
                                            "\n 1 - Argentina"+
                                            "\n 2 - China"+
                                            "\n 3 - Brasil"+
                                            "\n 4 – Uruguay");
                         System.out.print("Elija una opcion: ");
                         String opcioncad = sc.next();
                         opcion = Byte.parseByte(opcioncad);
                         if(opcion<1 || opcion>4) {
                           System.out.println("\nERROR, Ingrese los numero que indica el menu");
                         }
                         
	         	} catch (Exception e) {
			         System.out.println("\nERROR, Ingrese las opciones indicadas en el menu");
			         pass=false;
		        }
	        	
		   } while(pass==false || opcion<1 || opcion>4);
	      
		   String Origen = null;
		   if(opcion== 1) {
			   Origen= "ARGENTINA";
		   }else if(opcion==2) {
			   Origen= "CHINA";
		   }else if(opcion==3) {
			   Origen= "BRASIL";
		   }else if(opcion==4) {
			   Origen= "URUGUAY";
		   }
		   
		   
		   do { 
	        	try {    
	        		     pass=true;
	        		     System.out.println("\n===== Categoría ====="+ 
                                           "\n 1 - Telefonía"+
                                           "\n 2 - Informática"+
                                           "\n 3 - Electro hogar"+
                                           "\n 4 – Herramientas");
                        System.out.print("Elija una opcion:");
                        String opcioncad = sc.next();
                        opcion = Byte.parseByte(opcioncad);
                        if(opcion<1 || opcion>4) {
                          System.out.println("\nERROR, Ingrese los numero que indica el menu");
                        }
                        
	         	} catch (Exception e) {
			         System.out.println("\nERROR, Ingrese las opciones indicadas en el menu");
			         pass=false;
		        }
	        	
		  } while(pass==false || opcion<1 || opcion>4);
		   
		  String cate = null;
		   if(opcion== 1) {
			   cate= "TELEFONIA";
		   }else if(opcion==2) {
			   cate= "INFORMATICA";
		   }else if(opcion==3) {
			   cate= "ELECTROHOGAR";
		   }else if(opcion==4) {
			   cate= "HERRAMIENTAS";
		   }
		   
		   origenFabricacion origendefabricacion = origenFabricacion.valueOf(Origen);
		   categoria cat = categoria.valueOf(cate);
		   
		   productos.add(new Producto(codigo, descripcion, precio, origendefabricacion, cat));
	   }
	   /*
	    * 
	    *
	   */
	   public static void Mostrarproducto(){
		   if(productos==null) {
			   System.out.println("\nERROR, No se han registrados productos");
		   }
		   else {
			 System.out.println("\n======== Productos ========");
			 productos.forEach(p->System.out.println(p));
		   }
	   }
	   
	   /*
	    * 
	    *
	   */
	   public static void Modificarproducto(){
		   if(productos==null) {
			   System.out.println("\nERROR, No se han registrados productos");
		   }
		   else {
			   Scanner sc = new Scanner(System.in);
			   
			   byte opt=0;
			   boolean pass=false, encontrado=false;
			   byte opcion=0;
			   
			   
			   System.out.print("ingrese codigo del producto: ");
			   String cod = sc.next();
			   
			   for(int i=0;i<productos.size();i++) {
				  if(cod.compareTo(productos.get(i).getCodigo())==0) {
					encontrado=true;
					do {
				        System.out.println("\n======== Selecciona lo que quieras modificar ========");
				        System.out.println( "\n 1 - descripcion"+
                                            "\n 2 - precio unitario"+
                                            "\n 3 - origen de fabricacion"+
                                            "\n 4 – categoria"+
                                            "\n 5 – salir de modificar");
                        System.out.print("Elija una opcion: ");
                      try {
                    	  opt = sc.nextByte();
				      } catch (Exception e) {
				    	  System.out.println("\nERROR, Ingrese las opciones indicadas en el menu");
				    	  opt=5;
					  }          
                        switch(opt){       
			    	      case 1:      
			    	    	            System.out.print("ingrese descripcion: ");
			   		                    String descripcion = sc.next();
			   		                    productos.get(i).setDescripcion(descripcion);
			    	     	break;
			    	      case 2:          
			    	    	            float precio=0;
			    			            do {
			    		        	         try {
			    				                   pass=true;
			    				                   System.out.print("ingrese precio unitario: ");
			    				                   String preciocad = sc.next();
			    				                   precio = Float.parseFloat(preciocad); 
			    			                 } catch (Exception e) {
			    		          	                System.out.println("\nERROR, Ingrese datos validos");
			    				                    pass=false;
			    			                 }
			    			            }while(pass==false);
			    			            productos.get(i).setPreciounitario(precio);
			    	    	break;
			    	      case 3:       do { 
			  	                             	try {    
			        	                    	     pass=true;
			        	                    	     
			        		                         System.out.println("\n===== Origen de fabricación ====="+ 
		                                                                "\n 1 - Argentina"+
		                                                                "\n 2 - China"+
		                                                                "\n 3 - Brasil"+
		                                                                "\n 4 – Uruguay");
		                                              System.out.print("Elija una opcion:");
		                                              String opcioncad = sc.next();
		                                              opcion = Byte.parseByte(opcioncad);
		                                             if(opcion<1 || opcion>4) {
		                                                System.out.println("\nERROR, Ingrese los numero que indica el menu");
		                                              }
		                         
			                              	     } catch (Exception e) {
					                                   System.out.println("\nERROR, Ingrese las opciones indicadas en el menu");
					                                   pass=false;
				                                 }
			         	
				                         } while(pass==false || opcion<1 || opcion>4);
			      
				                        String Origen = null;
				                        
				                        if(opcion== 1) {
					                     Origen= "ARGENTINA";
				                        }else if(opcion==2) {
					                      Origen= "CHINA";
				                        }else if(opcion==3) {
					                      Origen= "BRASIL";
				                        }else if(opcion==4) {
					                      Origen= "URUGUAY";
				                        }
				                        origenFabricacion origendefabricacion = origenFabricacion.valueOf(Origen);
				                        productos.get(i).setOrigen(origendefabricacion);
				                     
				            break;
			    	      case 4:         
			    	    	           do { 
			  	        	                try {    
			        		                      pass=true;
			        		                      System.out.println("\n===== Categoría ====="+ 
		                                                             "\n 1 - Telefonía"+
		                                                             "\n 2 - Informática"+
		                                                             "\n 3 - Electro hogar"+
		                                                             "\n 4 – Herramientas");
		                                         System.out.print("Elija una opcion: ");
		                                         String opcioncad = sc.next();
		                                         opcion = Byte.parseByte(opcioncad);
		                                         if(opcion<1 || opcion>4) {
		                                           System.out.println("\nERROR, Ingrese los numero que indica el menu");
		                                         }
		                        
			         	                  } catch (Exception e) {
					                            System.out.println("\nERROR, Ingrese las opciones indicadas en el menu");
					                            pass=false;
				                          }
			        	
				                      } while(pass==false || opcion<1 || opcion>4);
				   
				                     String cate = null;
				                     if(opcion== 1) {
				                	   cate= "TELEFONIA";
			                   	   }else if(opcion==2) {
				                 	   cate= "INFORMATICA";
				                   }else if(opcion==3) {
					                   cate= "ELECTROHOGAR";
				                   }else if(opcion==4) {
					                   cate= "HERRAMIENTAS";
				                   }
				                     categoria cat = categoria.valueOf(cate);
				                     productos.get(i).setCategoria(cat);
			    	  	    break;
			    	     default:  System.out.println("opcion no valida");
			    	        break;
                        }
                    
				     }while(opt!=5);
			   }
		  }
			   if(encontrado==false) {
				   System.out.println("\nNo se encontro el producto"); }			 
	   }
		 
	}
	   
	   
}

