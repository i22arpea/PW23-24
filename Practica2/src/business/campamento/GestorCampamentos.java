package business.campamento;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.text.DateFormat;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Properties;

import business.actividad.*;

/**

 * Esta clase define la gestión de la clase Campamento mediante lectura y escritura en ficheros.

 * @author: Álvaro

 * @version: 08/10/2022

 */

public class GestorCampamentos {
	
	Properties propiedades = new Properties();
	public Actividad k = new Actividad();
	
	/**

     * Constructor por defecto del gestor de Campamentos


     */
	public  GestorCampamentos(){
		
		
	}
	
	/**

     * Método para crear una nueva Campamento y asignarla en el fichero

     * @param nombre nombre de la Campamento.
     * @param estado estado en el que se encuentra la Campamento, puede ser reservado o libre.
     * @param Dificultad dificultad que tiene la Campamento para saber que tipo de usuarios pueden acceder.
     * @param max máximo de personas que pueden estar en la Campamento.
     * 
     */
	public void crearCampamento(String nombre, boolean estado, NivelEducativo Dificultad, int max) {
		BufferedReader br = null;
	    boolean existe=false;
	    
	    try {
	    	 propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
		     File archivo =  new File(propiedades.getProperty("Campamento"));
		     br = new BufferedReader(new FileReader(archivo));
		     
		     String linea;
		     while((linea = br.readLine()) != null && existe== false) {
		    	 String[] campos = linea.split(" , "); 
		    	 
		    	 if(campos[0]==nombre) {
			        	existe=true;
			     }
		    	 
		     }
		     
		     if(existe) {
		    	   System.out.println("El nombre ya está asignado a una Campamento");
		     }else {
		    	 PrintWriter escribir = new PrintWriter(new FileWriter(archivo,true));
		    	 String completo = nombre + " , " + estado + " , " + Dificultad + " , "+ max+ " , "+ "Actividads:"+ "\n";
		    	 Campamento Campamento=new Campamento(nombre,estado,Dificultad,max);
		    	 escribir.write(completo);
		    	 escribir.close();
		     }
	    } catch (FileNotFoundException e) {
	          e.printStackTrace();
	      }	catch(IOException a) {
	    	  a.printStackTrace();
	      }
	}
	
	public Campamento buscarCampamento(String Campamento) {
		BufferedReader br = null;
	    boolean existe=false;
	    Campamento pist = new Campamento();
	    try {
	    	 propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
		     File archivo =  new File(propiedades.getProperty("Campamento"));
		     br = new BufferedReader(new FileReader(archivo));
		     
		     String linea;
		     while((linea = br.readLine()) != null && existe== false) {
		    	 String[] campos = linea.split(" , "); 
		    	 
		    	 if(campos[0].equals(Campamento)) {
		    		 existe = true;
		    		 NivelEducativo Dificultad = NivelEducativo.infantil;;
		    		 if(campos[2] == "familiar") {
		    			 Dificultad = NivelEducativo.familiar;
		    		 }
		    		 if(campos[2] == "adultos") {
		    			 Dificultad = NivelEducativo.adultos;
		    		 }
		    		 pist=new Campamento(campos[0],Boolean.valueOf(campos[1]),Dificultad,Integer.parseInt(campos[3]));
		    		 
			     }
		    	 
		     }
		     
		     if(!existe) {
		    	   System.out.println("No existe la Campamento asignada\n");
		     }
		    
	    } catch (FileNotFoundException e) {
	          e.printStackTrace();
	      }	catch(IOException a) {
	    	  a.printStackTrace();
	      }
	    return pist;
	}
	
	
	public Actividad buscarActividad(int Actividad) {
		BufferedReader br = null;
	    boolean existe=false;
	    Actividad kar = new Actividad();
	    try {
	    	 propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
		     File archivo =  new File(propiedades.getProperty("Actividad"));
		     br = new BufferedReader(new FileReader(archivo));
		     
		     String linea;
		     while((linea = br.readLine()) != null && existe== false) {
		    	 String[] campos = linea.split(" , "); 
		    	 
		    	 if(Integer.parseInt(campos[0])==Actividad) {
		    		 existe = true;
		    		 NivelEducativo Dificultad = NivelEducativo.reservado;
		    		 if(campos[2].equals("disponible") ) {
		    			 Dificultad = NivelEducativo.disponible;
		    		 }
		    		 if(campos[2].equals("mantenimiento") ) {
		    			 Dificultad = NivelEducativo.mantenimiento;
		    		 }
		    		 kar=new Actividad(Actividad,Boolean.valueOf(campos[1]),Dificultad);
		    		 
			     }
		    	 
		     }
		     
		     if(!existe) {
		    	   System.out.println("No existe el Actividad asignado\n");
		     }
		    
	    } catch (FileNotFoundException e) {
	          e.printStackTrace();
	      }	catch(IOException a) {
	    	  a.printStackTrace();
	      }
	    return kar;
	}
	
	
	public boolean buscarid(int Actividad) {
		BufferedReader br = null;
	    boolean existe=false;
	   
	    try {
	    	 propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
		     File archivo =  new File(propiedades.getProperty("Actividad"));
		     br = new BufferedReader(new FileReader(archivo));
		     
		     String linea;
		     while((linea = br.readLine()) != null && existe== false) {
		    	 String[] campos = linea.split(" , "); 
		    	 
		    	 if(Integer.parseInt(campos[0])==Actividad) {
		    		 existe = true;
		    		 
		    		 
			     }
		    	 
		     }
		     
		     if(!existe) {
		    	   System.out.println("No existe el Actividad asignado\n");
		     }
		    
	    } catch (FileNotFoundException e) {
	          e.printStackTrace();
	      }	catch(IOException a) {
	    	  a.printStackTrace();
	      }
	    return existe;
	}
	
	/**

     * Método para listar las Campamentos existentes.

     */
	public void listarCampamentos() {
		BufferedReader br = null;
	      boolean esta=false;
	      try {
	      propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
	      File archivo =  new File(propiedades.getProperty("Campamento"));
	      
	      if(!archivo.exists()) {
	    	  archivo.createNewFile();
	      }
	      
	    	  br = new BufferedReader(new FileReader(archivo));
	       
	    	  String linea;
	    	  int cont=0;
	    	  while ((linea = br.readLine()) != null) {
	    		  cont += 1;
	    		  
	    		  
	        
	    		  System.out.println("Campamento nº "+cont+": \n");
	    		  System.out.println(linea);
	        
	       }
	      }catch (FileNotFoundException e) {
	    	  e.printStackTrace();
  	} catch(IOException a) {
	    	  a.printStackTrace();
	      }
	}
	
	public void listarCampamentosMantenimiento() {
		BufferedReader br = null;
	      
	      try {
	      propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
	      File archivo =  new File(propiedades.getProperty("Campamento"));
	      
	      if(!archivo.exists()) {
	    	  archivo.createNewFile();
	      }
	      
	    	  br = new BufferedReader(new FileReader(archivo));
	       
	    	  String linea;
	    	  int cont=0;
	    	  while ((linea = br.readLine()) != null) {
	    		  cont ++;
	    		  String[] campos = linea.split(" , "); 
	    		 
	    		  if(campos[1].equals("false")) {
	    			  System.out.println("Campamento nº "+cont+": "+linea);
		    		  
			     }
	        
	    		  
	        
	       }
	      }catch (FileNotFoundException e) {
	    	  e.printStackTrace();
  	} catch(IOException a) {
	    	  a.printStackTrace();
	      }
	}
	
	public void listarCampamentosDisponibles() {
		BufferedReader br = null;
	      
	      try {
	      propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
	      File archivo =  new File(propiedades.getProperty("Campamento"));
	      
	      if(!archivo.exists()) {
	    	  archivo.createNewFile();
	      }
	      
	    	  br = new BufferedReader(new FileReader(archivo));
	       
	    	  String linea;
	    	  int cont=0;
	    	  while ((linea = br.readLine()) != null) {
	    		  cont ++;
	    		  String[] campos = linea.split(" , "); 
	    		 
	    		  if(campos[1].equals("true")) {
	    			  System.out.println("Campamento nº "+cont+": "+linea);
		    		  
			     }
	        
	    		  
	        
	       }
	      }catch (FileNotFoundException e) {
	    	  e.printStackTrace();
  	} catch(IOException a) {
	    	  a.printStackTrace();
	      }
	}
	
	public int listarCampamentosPar(int participantes, String tipo) {
		BufferedReader br = null;
		int cont=0;
	      boolean esta=false;
	      try {
	      propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
	      File archivo =  new File(propiedades.getProperty("Campamento"));
	      
	      if(!archivo.exists()) {
	    	  archivo.createNewFile();
	      }
	      
	    	  br = new BufferedReader(new FileReader(archivo));
	       
	    	  String linea;
	    	  
	    	  while ((linea = br.readLine()) != null) {
	    		  cont += 1;
	    		  String[] campos = linea.split(" , ");
	    		  
	    		  if(campos[2].equals(tipo) && Integer.parseInt(campos[3]) > participantes) {
	    			  System.out.println("Campamento "+tipo+" nº "+cont+": \n");
		    		  System.out.println(linea);
			     }
	        
	    		  
	        
	       }
	      }catch (FileNotFoundException e) {
	    	  e.printStackTrace();
  	} catch(IOException a) {
	    	  a.printStackTrace();
	      }
	      return cont;
	}

	public void crearActividad(String nombre, NivelEducativo estado, String horario, int nummonitores) {
		BufferedReader br = null;
	    boolean existe=false;
	    
	    try {
	    	 propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
		     File archivo =  new File(propiedades.getProperty("Actividad"));
		     br = new BufferedReader(new FileReader(archivo));
		     
		     String linea;
		     while((linea = br.readLine()) != null && existe== false) {
		    	 String[] campos = linea.split(" , "); 
		    	 
		    	 if(campos[0].equals(nombre)) {
			        	existe=true;
			     }
		    	 
		     }
		     
		     if(existe) {
		    	   System.out.println("El nombre ya está asignado a un Actividad");
		     }else {
		    	 PrintWriter escribir = new PrintWriter(new FileWriter(archivo,true));
		    	 Actividad Actividad=new Actividad(nombre,estado,horario,nummonitores);
		    	 String completo = nombre + " , " + estado + " , " + horario + " , " + nummonitores + "\n";
		    	 escribir.write(completo);
		    	 escribir.close();
		     }
		     
		     
	    } catch (FileNotFoundException e) {
	          e.printStackTrace();
	      }	catch(IOException a) {
	    	  a.printStackTrace();
	      }
	}
	
	public void listarActividades() {
		BufferedReader br = null;
	      boolean esta=false;
	      try {
	      propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
	      File archivo =  new File(propiedades.getProperty("Actividad"));
	      
	      if(!archivo.exists()) {
	    	  archivo.createNewFile();
	      }
	      
	    	  br = new BufferedReader(new FileReader(archivo));
	       
	    	  String linea;
	    	  int cont=0;
	    	  while ((linea = br.readLine()) != null) {
	    		  cont += 1;
	    		  
	    		  
	        
	    		  System.out.println("Actividad nº "+cont+": "+linea);
	    		  
	        
	       }
	      }catch (FileNotFoundException e) {
	    	  e.printStackTrace();
  	} catch(IOException a) {
	    	  a.printStackTrace();
	      }
	}
	
	public void listarActividadesDisponibles() {
		BufferedReader br = null;
	      
	      try {
	      propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
	      File archivo =  new File(propiedades.getProperty("Actividad"));
	      
	      if(!archivo.exists()) {
	    	  archivo.createNewFile();
	      }
	      
	    	  br = new BufferedReader(new FileReader(archivo));
	       
	    	  String linea;
	    	  int cont=0;
	    	  while ((linea = br.readLine()) != null) {
	    		  cont ++;
	    		  String[] campos = linea.split(" , "); 
	    		 
	    		  if(campos[2].equals("disponible")) {
	    			  System.out.println("Actividad nº "+cont+": "+linea);
		    		  
			     }
	        
	    		  
	        
	       }
	      }catch (FileNotFoundException e) {
	    	  e.printStackTrace();
  	} catch(IOException a) {
	    	  a.printStackTrace();
	      }
	}
	
	public void CambiarActividadReservado(int Actividad) {
		BufferedReader reader = null;
		
	      try {
	      propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
	      File archivo =  new File(propiedades.getProperty("Actividad"));
	      File archivomod =  new File(propiedades.getProperty("Actividadmod"));
	      
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
	    		  
	    		  if(Integer.parseInt(campos[0])==Actividad) {
	    			  //String completo = Campamento + " , " + "false" + " , " + campos[2] + " , "+ campos[4];
	    			  linea = linea.replace("disponible", "reservado");
		    		  
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
	}
	
	public void CambiarCampamentoMantenimiento(String Campamento) {
		BufferedReader reader = null;
		
	      try {
	      propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
	      File archivo =  new File(propiedades.getProperty("Campamento"));
	      File archivomod =  new File(propiedades.getProperty("Campamentomod"));
	      
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
	    		  
	    		  if(campos[0].equals(Campamento)) {
	    			  //String completo = Campamento + " , " + "false" + " , " + campos[2] + " , "+ campos[4];
	    			  linea = linea.replace("true", "false");
		    		  
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
	}
	
	public void CambiarCampamentoDisponible(String Campamento) {
		BufferedReader reader = null;
		
	      try {
	      propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
	      File archivo =  new File(propiedades.getProperty("Campamento"));
	      File archivomod =  new File(propiedades.getProperty("Campamentomod"));
	      
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
	    		  
	    		  if(campos[0].equals(Campamento)) {
	    			  
	    			  linea = linea.replace("false", "true");
		    		  
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
	}
	
	
	public boolean AsociarActividadCampamento(String Campamento,int Actividad) {
		BufferedReader reader = null;
		boolean sepuede=false;
	      try {
	      propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
	      File archivo =  new File(propiedades.getProperty("Campamento"));
	      File archivomod =  new File(propiedades.getProperty("Campamentomod"));
	      
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
	    		  
	    		  if(campos[0].equals(Campamento)) {
	    			  Campamento pis = buscarCampamento(Campamento);
	    			  Actividad k = buscarActividad(Actividad);
	    			  if(pis.asociarActividadACampamento(k)) {
	    			  String completo = Campamento + " , " + "false" + " , " + campos[2] + " , "+ campos[3]+ " , "+ campos[4]+" "+Actividad;
	    			  linea = completo;
	    			  sepuede=true;
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
	
	
	public boolean EliminarCampamento(String Campamento) {
		BufferedReader reader = null;
		boolean sepuede = false;
	      try {
	      propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
	      File archivo =  new File(propiedades.getProperty("Campamento"));
	      File archivomod =  new File(propiedades.getProperty("Campamentomod"));
	      
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
	    		  
	    		  if(campos[0].equals(Campamento)) {
	    			  
	    			 sepuede=true;
		    		  
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
	
	public boolean EliminarActividad(String Actividad) {
		BufferedReader reader = null;
		boolean sepuede = false;
	      try {
	      propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
	      File archivo =  new File(propiedades.getProperty("Actividad"));
	      File archivomod =  new File(propiedades.getProperty("Actividadmod"));
	      
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
	    		  
	    		  if(campos[0].equals(Actividad)) {
	    			  
	    			 sepuede=true;
		    		  
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
	
	
}