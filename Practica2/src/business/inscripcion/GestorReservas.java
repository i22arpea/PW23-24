package business.inscripcion;






import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import business.asistente.GestorAsistentes;
import business.campamento.Campamento;
import business.campamento.DificultadPista;
import business.asistente.Asistente;

/* 
 * CLASE EN MANTENIMIENTO
 *
 */

/**
 * Esta clase define la gestión de las reservas que realiza cada usuario.

 * @version: 24/10/2022
 */
public class GestorReservas {
	Properties propiedades = new Properties();
	
	
	

	
	/**
     * Constructor por defecto
     */
	public  GestorReservas(){
			
	}
	
	



	/**
     * Método para visualizar las reservas existentes.
     */
	public void listarReservasInfantil() {
		
		BufferedReader br = null;
	      //boolean esta=false;
	      try {
	      propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
	      File archivo =  new File(propiedades.getProperty("infantil"));
	      
	      if(!archivo.exists()) {
	    	  archivo.createNewFile();
	      }
	      
	    	  
	    	  // Abrir el .csv en buffer de lectura
	    	  br = new BufferedReader(new FileReader(archivo));
	       
	    	  // Leer una linea del archivo
	    	  String linea;
	    	  int cont=0;
	    	  while ((linea = br.readLine()) != null) {
	    		  cont += 1;
	    		  
	    		  
	        
	    		  System.out.println("Reserva nº "+cont+": \n");
	    		  System.out.println(linea);
	        
	       }
	      }catch (FileNotFoundException e) {
	    	  e.printStackTrace();
  	} catch(IOException a) {
	    	  a.printStackTrace();
	      }

		
	}
	
	/**
     * Método para visualizar las reservas existentes.
     */
	public void listarReservasAdulto() {
		
		BufferedReader br = null;
	      //boolean esta=false;
	      try {
	      propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
	      File archivo =  new File(propiedades.getProperty("adulto"));
	      
	      if(!archivo.exists()) {
	    	  archivo.createNewFile();
	      }
	      
	    	  
	    	  // Abrir el .csv en buffer de lectura
	    	  br = new BufferedReader(new FileReader(archivo));
	       
	    	  // Leer una linea del archivo
	    	  String linea;
	    	  int cont=0;
	    	  while ((linea = br.readLine()) != null) {
	    		  cont += 1;
	    		  
	    		  
	        
	    		  System.out.println("Reserva nº "+cont+": \n");
	    		  System.out.println(linea);
	        
	       }
	      }catch (FileNotFoundException e) {
	    	  e.printStackTrace();
  	} catch(IOException a) {
	    	  a.printStackTrace();
	      }

		
	}
	
	/**
     * Método para visualizar las reservas existentes.
     */
	public void listarReservasFamiliar() {
		
		BufferedReader br = null;
	      //boolean esta=false;
	      try {
	      propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
	      File archivo =  new File(propiedades.getProperty("familiar"));
	      
	      if(!archivo.exists()) {
	    	  archivo.createNewFile();
	      }
	      
	    	  
	    	  // Abrir el .csv en buffer de lectura
	    	  br = new BufferedReader(new FileReader(archivo));
	       
	    	  // Leer una linea del archivo
	    	  String linea;
	    	  int cont=0;
	    	  while ((linea = br.readLine()) != null) {
	    		  cont += 1;
	    		  
	    		  
	        
	    		  System.out.println("Reserva nº "+cont+": \n");
	    		  System.out.println(linea);
	        
	       }
	      }catch (FileNotFoundException e) {
	    	  e.printStackTrace();
  	} catch(IOException a) {
	    	  a.printStackTrace();
	      }

		
	}
	
	
	/**
     * Método para visualizar las reservas existentes.
     */
	public void listarReservas() {
		
		listarReservasInfantil();
		listarReservasAdulto();
		listarReservasFamiliar();
		
	}
	
	/**
     * Método para obtener una reserva en concreto.
     * 
     * @param idReserva identificador de la reserva que deseamos encontrar.
     * @return devuelve el usuario encontrado.
     * 
     */
	
	public void listarReservasUsu(String usuario) {
		
		BufferedReader br = null;
	      //boolean esta=false;
	      try {
	      propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
	      File archivo =  new File(propiedades.getProperty("infantil"));
	      
	      if(!archivo.exists()) {
	    	  archivo.createNewFile();
	      }
	      
	    	  
	    	  // Abrir el .csv en buffer de lectura
	    	  br = new BufferedReader(new FileReader(archivo));
	       
	    	  // Leer una linea del archivo
	    	  String linea;
	    	  int cont=0;
	    	  while ((linea = br.readLine()) != null) {
	    		  cont += 1;
	    		  String[] campos = linea.split(" , ");
	    		  
	    		  if(campos[1]==usuario) {
	    			  System.out.println("Reserva de "+usuario+" nº "+cont+": \n");
		    		  System.out.println(linea);
			     }
	        
	       }
	      }catch (FileNotFoundException e) {
	    	  e.printStackTrace();
	} catch(IOException a) {
	    	  a.printStackTrace();
	      }
		
	}
	
	
	public void obtenerDatosReserva(int idReserva,String tipo) {
		
		
		BufferedReader br = null;
	      //boolean esta=false;
	      try {
	      propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
	      File archivo =  new File(propiedades.getProperty(tipo));
	      
	      if(!archivo.exists()) {
	    	  archivo.createNewFile();
	      }
	      
	    	  
	    	  // Abrir el .csv en buffer de lectura
	    	  br = new BufferedReader(new FileReader(archivo));
	       
	    	  // Leer una linea del archivo
	    	  String linea;
	    	  int cont=0;
	    	  while ((linea = br.readLine()) != null) {
	    		  cont += 1;
	    		  String[] campos = linea.split(" , ");
	    		  
	    		  if(campos[0]==String.valueOf(idReserva)) {
		    		  System.out.println(linea);
			     }
	        
	       }
	      }catch (FileNotFoundException e) {
	    	  e.printStackTrace();
	} catch(IOException a) {
	    	  a.printStackTrace();
	      }
		
		
	}
	
	
	public boolean verificarIdExiste(int idReserva,String tipo) {
		
		BufferedReader br = null;
	      boolean esta=false;
	      try {
	      propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
	      File archivo =  new File(propiedades.getProperty(tipo));
	      
	      if(!archivo.exists()) {
	    	  archivo.createNewFile();
	      }
	      
	    	  
	    	  // Abrir el .csv en buffer de lectura
	    	  br = new BufferedReader(new FileReader(archivo));
	       
	    	  // Leer una linea del archivo
	    	  String linea;
	    	  int cont=0;
	    	  while ((linea = br.readLine()) != null) {
	    		  cont += 1;
	    		  String[] campos = linea.split(" , ");
	    		  
	    		  if(campos[0]==String.valueOf(idReserva)) {
		    		  esta = true;
			     }
	        
	       }
	      }catch (FileNotFoundException e) {
	    	  e.printStackTrace();
	} catch(IOException a) {
	    	  a.printStackTrace();
	      }
		
		return esta;
	}
	
	public boolean verificarIdExisteUsuario(int idReserva, String tipo, String email) {
		
		BufferedReader br = null;
	      boolean esta=false;
	      try {
	      propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
	      File archivo =  new File(propiedades.getProperty(tipo));
	      
	      if(!archivo.exists()) {
	    	  archivo.createNewFile();
	      }
	      
	    	  
	    	  // Abrir el .csv en buffer de lectura
	    	  br = new BufferedReader(new FileReader(archivo));
	       
	    	  // Leer una linea del archivo
	    	  String linea;
	    	  int cont=0;
	    	  while ((linea = br.readLine()) != null) {
	    		  cont += 1;
	    		  String[] campos = linea.split(" , ");
	    		  
	    		  if(campos[0]==String.valueOf(idReserva) && campos[1]==email) {
		    		  esta = true;
			     }
	        
	       }
	      }catch (FileNotFoundException e) {
	    	  e.printStackTrace();
	} catch(IOException a) {
	    	  a.printStackTrace();
	      }
		
		return esta;
	}
	
	/**
     * Método para comprobar y registar un usuario en la base de datos.
     * @param sql fichero con las instancias de la base de datos.
     * @param nombre nombre del nuevo usuario.
     * @param correo correo que le pasamos como identificador del usuario que deseamos crear.
     * @param fnacimiento fecha de nacimiento del nuevo usuario.
     * @return devuelve una cadena con el estado de la operación.
     * 
     */
	public Inscripcion registrarReserva(Asistente usuario,String fecha,int duracion, Campamento pista, int numninos,int numadultos,int idbono,int descuento ) {
		
		
		BufferedReader br = null;
	    String tipo;
	    int numpart=numninos+numadultos;
	    Inscripcion res;
	    if(pista.getDificultad() == DificultadPista.adultos) {
	    	tipo = "adultos";
	    	res = new Parcial();
	    }else if(pista.getDificultad() == DificultadPista.infantil) {
	    	tipo = "infantil";
	    	res = new Completa();
	    }else {
	    	tipo = "familiar";
	    	res = new Familiar();
	    }
	    try {
	    	 propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
		     File archivo =  new File(propiedades.getProperty(tipo));
		     br = new BufferedReader(new FileReader(archivo));
		     String[] campos= null;
		     String linea;
		     int cont=0;
		     int contres=0;
		     while((linea = br.readLine()) != null) {
		    	 campos = linea.split(" , ");
		    	 if(Integer.valueOf(campos[9]) != 0) {
		    		 cont++;
		    	 }
		    		 contres++;
		    	 
		     }
		     int idbonos;
		     if(idbono != 0) {
		    	 idbonos = cont+1;
		     }else idbonos = 0;
		     
		     int idReserva = contres;
		     float precio = precioReserva(duracion);
		     float preciofinal = precio - descuento(descuento,precio);
		     
		     GestorAsistentes usu = new GestorAsistentes();
				
		     
		     boolean mayor=false;
		     boolean mantenimiento=false;
		     
		     int edad = usu.calcularedad(usuario);
		     if(edad >= 18) {
				mayor =true;
		     }
		     if(pista.EstadoPista == false) {
				mantenimiento = true;
		     }
				
		     if(mayor == false) {
		    	 System.out.println("El usuario " + usuario.getNombre() + " no es mayor de edad"); 
					}
		     else if(mantenimiento == true) { 
		    	 System.out.println("La pista " + pista.getNombre() + " está en mantenimiento"); 
					}
		     else {
		     
		     
		     
		     PrintWriter escribir = new PrintWriter(new FileWriter(archivo,true));
		     String completo;
		     

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				Date fechaComoFecha;
				
				fechaComoFecha = sdf.parse(fecha);
				
		     
		     if(tipo == "adultos") {
		    	 completo = idReserva + " , " + usuario.getCorreo() + " , " + fecha + " , "+ duracion + " , "+ pista.getNombre() + " , " + preciofinal 
			    		 + " , " + descuento + " , "+ numpart + " , "+ tipo + " , " + idbonos+ "\n" ;
		    	 
			    	res = new Parcial(idReserva,usuario.getCorreo(),fechaComoFecha,duracion,pista.getNombre(),preciofinal,
			    			descuento,numpart,tipo,idbonos);
			    }else if(tipo == "infantil") {
			    	completo = idReserva + " , " + usuario.getCorreo() + " , " + fecha + " , "+ duracion + " , "+ pista.getNombre() + " , " + preciofinal 
				    		 + " , " + descuento + " , "+ numpart + " , "+ tipo + " , " + idbonos+ "\n" ;
			    	
			    	res = new Completa(idReserva,usuario.getCorreo(),fechaComoFecha,duracion,pista.getNombre(),preciofinal,
			    			descuento,numpart,tipo,idbonos);
			    }else {
			    	completo = idReserva + " , " + usuario.getCorreo() + " , " + fecha + " , "+ duracion + " , "+ pista.getNombre() + " , " + preciofinal 
				    		 + " , " + descuento + " , "+ numninos + " , "+ numadultos + " , " + tipo + " , " + idbonos+ "\n" ;
			    	
			    	res = new Familiar(idReserva,usuario.getCorreo(),fechaComoFecha,duracion,pista.getNombre(),preciofinal,
			    			descuento,numninos,numadultos,tipo,idbonos);
			    }
		    
		    	 escribir.write(completo);
		    	 escribir.close();
		    	 System.out.println("Registro de la reserva en la base de datos ha sido un exito") ;
		     }
	    } catch (FileNotFoundException e) {
	          e.printStackTrace();
	      }	catch(IOException a) {
	    	  a.printStackTrace();
			
		   }catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
			 
				
		
		return res; // Retornamos el estado del registro de los datos del usuario
	}
	
	
	public boolean CambiarFecha(Campamento pista, int idres,Date fech,String correo) {
		BufferedReader br = null;
		boolean sepuede = false;
		String tipo;
		String tipomod;
		 Date fecha = new Date();
		    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		    Date current = new Date();
			Calendar calendar = Calendar.getInstance();
	        calendar.setTime(current);
	        calendar.add(Calendar.DAY_OF_YEAR, 1); // Suma un día

	        Date newDate = calendar.getTime();
		    
	    Inscripcion res;
	    if(pista.getDificultad() == DificultadPista.adultos) {
	    	tipo = "adultos";
	    	tipomod = "adultosmod";
	    	res = new Parcial();
	    }else if(pista.getDificultad() == DificultadPista.infantil) {
	    	tipo = "infantil";
	    	tipomod = "infantilmod";
	    	res = new Completa();
	    }else {
	    	tipo = "familiar";
	    	tipomod = "familiarmod";
	    	res = new Familiar();
	    }
	   
	    
	    
		
	      try {
	    	  propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
			     File archivo =  new File(propiedades.getProperty(tipo));
			     File archivomod =  new File(propiedades.getProperty(tipomod));
			     br = new BufferedReader(new FileReader(archivo));
	      
	      
	      if(!archivo.exists()) {
	    	  archivo.createNewFile();
	      }
	      if(!archivomod.exists()) {
	    	  archivomod.createNewFile();
	      }
	      
	    	  
	    	  
	    	  PrintWriter escribir = new PrintWriter(new FileWriter(archivomod,true));
	    	  String linea;
	    	  String newfech = formato.format(fech);
	    	  while ((linea = br.readLine()) != null) {
	    		  
	    		  String[] campos = linea.split(" , ");
	    		  
	    		  if(Integer.parseInt(campos[0]) == idres && campos[1].equals(correo)) {
	    			  sepuede = true;
	    			  try {
							fecha = formato.parse(campos[2]);
							
							if(fecha.before(newDate)) {
								sepuede=false;
								
							}else {
								linea = linea.replace(campos[2], newfech);
							}
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	    			  
	    			  
		    		  
			     }
	    		  
	    		  escribir.write(linea);
	    		  escribir.write("\n");
	    		  
	    		  
	    	  }
	    	  escribir.close();
	    		  try (InputStream inputStream = new FileInputStream(archivomod);
	    				     OutputStream outputStream = new FileOutputStream(archivo)) {
	    		  byte[] buffer = new byte[1024];
	    		    int bytesRead;
	    		    while ((bytesRead = inputStream.read(buffer)) != -1) {
	    		        outputStream.write(buffer, 0, bytesRead);
	    		    }
	    		   inputStream.close();
	    		    System.out.println("Archivo reemplazado exitosamente.");
	    		    archivomod.delete();
	    		    	
	    		    
	    		  } catch (IOException e) {
	    			    e.printStackTrace();
	    			}
	    		  
	        
	       
	      }catch (FileNotFoundException e) {
	    	  e.printStackTrace();
  	} catch(IOException a) {
	    	  a.printStackTrace();
	      }
	      return sepuede;
	}

	
	public boolean CambiarDuracion(Campamento pista, int idres,int dur,String correo) {
		BufferedReader br = null;
		boolean sepuede = false;
		String tipo;
		String tipomod;
		 Date fecha = new Date();
		    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		    Date current = new Date();
			Calendar calendar = Calendar.getInstance();
	        calendar.setTime(current);
	        calendar.add(Calendar.DAY_OF_YEAR, 1); // Suma un día

	        Date newDate = calendar.getTime();
		    
	    Inscripcion res;
	    if(pista.getDificultad() == DificultadPista.adultos) {
	    	tipo = "adultos";
	    	tipomod = "adultosmod";
	    	res = new Parcial();
	    }else if(pista.getDificultad() == DificultadPista.infantil) {
	    	tipo = "infantil";
	    	tipomod = "infantilmod";
	    	res = new Completa();
	    }else {
	    	tipo = "familiar";
	    	tipomod = "familiarmod";
	    	res = new Familiar();
	    }
	   
	    
	    
		
	      try {
	    	  propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
			     File archivo =  new File(propiedades.getProperty(tipo));
			     File archivomod =  new File(propiedades.getProperty(tipomod));
			     br = new BufferedReader(new FileReader(archivo));
	      
	      
	      if(!archivo.exists()) {
	    	  archivo.createNewFile();
	      }
	      if(!archivomod.exists()) {
	    	  archivomod.createNewFile();
	      }
	      
	      	 
	    	  
	    	  PrintWriter escribir = new PrintWriter(new FileWriter(archivomod,true));
	    	  String linea;
	    	  
	    	  while ((linea = br.readLine()) != null) {
	    		  
	    		  String[] campos = linea.split(" , ");
	    		  
	    		  if(Integer.parseInt(campos[0]) == idres && campos[1].equals(correo)) {
	    			  sepuede = true;
	    			  try {
							fecha = formato.parse(campos[2]);
							
							if(fecha.before(newDate)) {
								sepuede=false;
								
							}else {
								float precio = precioReserva(dur);
							     float preciofinal = precio - descuento(Integer.parseInt(campos[6]),precio);
								linea = linea.replace(campos[3],String.valueOf(dur) );
								linea = linea.replace(campos[5],String.valueOf(preciofinal));
							}
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	    			  
	    			  
		    		  
			     }
	    		  escribir.write(linea);
	    		  escribir.write("\n");
	    		  
	    		  
	    	  }
	    	  escribir.close();
	    		  try (InputStream inputStream = new FileInputStream(archivomod);
	    				     OutputStream outputStream = new FileOutputStream(archivo)) {
	    		  byte[] buffer = new byte[1024];
	    		    int bytesRead;
	    		    while ((bytesRead = inputStream.read(buffer)) != -1) {
	    		        outputStream.write(buffer, 0, bytesRead);
	    		    }
	    		   inputStream.close();
	    		    System.out.println("Archivo reemplazado exitosamente.");
	    		    archivomod.delete();
	    		    	
	    		    
	    		  } catch (IOException e) {
	    			    e.printStackTrace();
	    			}
	    		  
	        
	       
	      }catch (FileNotFoundException e) {
	    	  e.printStackTrace();
  	} catch(IOException a) {
	    	  a.printStackTrace();
	      }
	      return sepuede;
	}
	
	
	public boolean CambiarParticipantes(Campamento pista, int idres,int part,String correo) {
		BufferedReader br = null;
		boolean sepuede = false;
		String tipo;
		String tipomod;
		 Date fecha = new Date();
		    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		    Date current = new Date();
			Calendar calendar = Calendar.getInstance();
	        calendar.setTime(current);
	        calendar.add(Calendar.DAY_OF_YEAR, 1); // Suma un día

	        Date newDate = calendar.getTime();
		    
	    Inscripcion res;
	    if(pista.getDificultad() == DificultadPista.adultos) {
	    	tipo = "adultos";
	    	tipomod = "adultosmod";
	    	res = new Parcial();
	    }else if(pista.getDificultad() == DificultadPista.infantil) {
	    	tipo = "infantil";
	    	tipomod = "infantilmod";
	    	res = new Completa();
	    }else {
	    	tipo = "familiar";
	    	tipomod = "familiarmod";
	    	res = new Familiar();
	    }
	   
	    
	    
		
	      try {
	    	  propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
			     File archivo =  new File(propiedades.getProperty(tipo));
			     File archivomod =  new File(propiedades.getProperty(tipomod));
			     br = new BufferedReader(new FileReader(archivo));
	      
	      
	      if(!archivo.exists()) {
	    	  archivo.createNewFile();
	      }
	      if(!archivomod.exists()) {
	    	  archivomod.createNewFile();
	      }
	      
	    	  
	    	  
	    	  PrintWriter escribir = new PrintWriter(new FileWriter(archivomod,true));
	    	  String linea;
	    	  
	    	  while ((linea = br.readLine()) != null) {
	    		  
	    		  String[] campos = linea.split(" , ");
	    		  
	    		  if(Integer.parseInt(campos[0]) == idres && campos[1].equals(correo)) {
	    			  sepuede = true;
	    			  try {
							fecha = formato.parse(campos[2]);
							
							if(fecha.before(newDate)) {
								sepuede=false;
								
							}else {
								
								linea = linea.replace(campos[7],String.valueOf(part) );
							}
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	    			  
	    			  
		    		  
			     }
	    		  escribir.write(linea);
	    		  escribir.write("\n");
	    		  
	    		  
	    	  }
	    	  escribir.close();
	    		  try (InputStream inputStream = new FileInputStream(archivomod);
	    				     OutputStream outputStream = new FileOutputStream(archivo)) {
	    		  byte[] buffer = new byte[1024];
	    		    int bytesRead;
	    		    while ((bytesRead = inputStream.read(buffer)) != -1) {
	    		        outputStream.write(buffer, 0, bytesRead);
	    		    }
	    		   inputStream.close();
	    		    System.out.println("Archivo reemplazado exitosamente.");
	    		    archivomod.delete();
	    		    	
	    		    
	    		  } catch (IOException e) {
	    			    e.printStackTrace();
	    			}
	    		  
	        
	       
	      }catch (FileNotFoundException e) {
	    	  e.printStackTrace();
  	} catch(IOException a) {
	    	  a.printStackTrace();
	      }
	      return sepuede;
	}
	
	
	/*
	public Boolean ModificarReserva(ReservaDTO res, int idReserva, Usuario usuario, Date fechanueva, int duracion,int numpart ) {
		
		GestorUsuarios usu = new GestorUsuarios();
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date fecha = new java.sql.Date(utilDate.getTime());
		Boolean estado = true;
		if(this.verificarIdExiste(res.getIdReserva()) == false) {
			estado = false;
			System.out.println("Esta reserva que quieres modificar no existe");
		}else if(this.verificarIdExiste(idReserva) == true){
			estado = false;
			System.out.println("El id de la reserva que quieres poner nuevo ya está asignado");
			
		}else if(usu.calcularedad(usuario) < 18) {
			estado = false;
			System.out.println("El usuario nuevo no es mayor de 18");
			
		}else if(fecha.compareTo(res.getFechaDate()) ==0) {
			estado = false;
			System.out.println("No se puede modificar la reserva, es demasiado tarde");
			
		}else {
			for(int i=0; i < this.Reservas.size(); i++) {
				
				if(this.Reservas.get(i) == res) {
					this.Reservas.get(i).setIdReserva(idReserva);
					this.Reservas.get(i).setId(usuario.getCorreo());
					this.Reservas.get(i).setfecha(fecha);
					this.Reservas.get(i).setduracion(duracion);
					this.Reservas.get(i).setparticipantes(numpart);
				}
				
			}
		}
		
	
		return estado;
	}
	*/
	
	public boolean buscarResId(int idres,String correo, Campamento pista) {
		BufferedReader br = null;
		boolean existe = false;
		String tipo;
		String tipomod;
	    
	    Inscripcion res;
	    if(pista.getDificultad() == DificultadPista.adultos) {
	    	tipo = "adultos";
	    	tipomod = "adultosmod";
	    	res = new Parcial();
	    }else if(pista.getDificultad() == DificultadPista.infantil) {
	    	tipo = "infantil";
	    	tipomod = "infantilmod";
	    	res = new Completa();
	    }else {
	    	tipo = "familiar";
	    	tipomod = "familiarmod";
	    	res = new Familiar();
	    }
	   
	    try {
	    	 propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
		     File archivo =  new File(propiedades.getProperty(tipo));
		     br = new BufferedReader(new FileReader(archivo));
		     
		     String linea;
		     while((linea = br.readLine()) != null && existe== false) {
		    	 String[] campos = linea.split(" , "); 
		    	 
		    	 if(campos[0].equals(idres)) {
		    		 
		    		 if(campos[1].equals(correo)){
		    			 existe = true;
		    		 }
		    		 
		    		 
		    		
		    		 
		    		 
		    		 
		    		 
			     }
		    	 
		     }
		     
		     if(!existe) {
		    	   System.out.println("No existe el usuario asignado\n");
		     }
		    
	    } catch (FileNotFoundException e) {
	          e.printStackTrace();
	      }	catch(IOException a) {
	    	  a.printStackTrace();
	      }
	    return existe;
	}
	
	public boolean CancelarReserva(Campamento pista,int idreserva, String correo) {
		BufferedReader reader = null;
		boolean sepuede = false;
		String tipo;
		String tipomod;
	    Date fecha = new Date();
	    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	    Date current = new Date();
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(current);
        calendar.add(Calendar.DAY_OF_YEAR, 1); // Suma un día

        Date newDate = calendar.getTime();
	    
	    
	    Inscripcion res;
	    if(pista.getDificultad() == DificultadPista.adultos) {
	    	tipo = "adultos";
	    	tipomod = "adultosmod";
	    	res = new Parcial();
	    }else if(pista.getDificultad() == DificultadPista.infantil) {
	    	tipo = "infantil";
	    	tipomod = "infantilmod";
	    	res = new Completa();
	    }else {
	    	tipo = "familiar";
	    	tipomod = "familiarmod";
	    	res = new Familiar();
	    }
	      try {
	      propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
	      File archivo =  new File(propiedades.getProperty(tipo));
	      File archivomod =  new File(propiedades.getProperty(tipomod));
	      
	      if(!archivo.exists()) {
	    	  archivo.createNewFile();
	      }
	      if(!archivomod.exists()) {
	    	  archivomod.createNewFile();
	      }
	      
	    	  reader = new BufferedReader(new FileReader(archivo));
	    	  
	    	  PrintWriter escribir = new PrintWriter(new FileWriter(archivomod,true));
	    	  String linea;
	    	  
				
	    	  while ((linea = reader.readLine()) != null) {
	    		  
	    		  String[] campos = linea.split(" , ");
	    		  
	    		  if(Integer.parseInt(campos[0]) == idreserva && campos[1].equals(correo)) {
	    			  
	    			 sepuede=true;
	    			 
	    			 try {
						fecha = formato.parse(campos[2]);
						
						if(fecha.before(newDate)) {
							sepuede=false;
							
						}
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    		  
			     }else {
			    	 escribir.write(linea);
			    	 escribir.write("\n");
			     }
	    		  
	    		  
	    		  
	    		  
	    	  }
	    	  escribir.close();
	    		  try (InputStream inputStream = new FileInputStream(archivomod);
	    				     OutputStream outputStream = new FileOutputStream(archivo)) {
	    		  byte[] buffer = new byte[1024];
	    		    int bytesRead;
	    		    while ((bytesRead = inputStream.read(buffer)) != -1) {
	    		        outputStream.write(buffer, 0, bytesRead);
	    		    }
	    		   inputStream.close();
	    		    
	    		    archivomod.delete();
	    		    	
	    		    
	    		  } catch (IOException e) {
	    			    e.printStackTrace();
	    			}
	    		  
	        
	       
	      }catch (FileNotFoundException e) {
	    	  e.printStackTrace();
  	} catch(IOException a) {
	    	  a.printStackTrace();
	      }
	      return sepuede;
	}
	
	public float precioReserva(int duracion) {
		float precio=0;
		if(duracion==60) {
			precio=20;
		}
		if(duracion==90) {
			precio=30;
		}
		if(duracion==120) {
			precio=40;
		}
		
		return precio;
	}
	
	
	public float descuento(int descuento,float precio) {
		
		
			precio = (precio *descuento/100);
		
		return precio;
	}
	
	
}

