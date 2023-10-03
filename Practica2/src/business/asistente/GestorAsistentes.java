package business.asistente;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.concurrent.TimeUnit;



/**

 * Esta clase define la gestión de la clase asistente mediante lectura y escritura en ficheros.

 * @author: Adrián Arroyo Pérez

 * @version: 

 */
public class GestorAsistentes {
	//leer el fichero para todos los asistentes y añadir asistentes al fichero 
	Properties propiedades = new Properties();
	
	/**

     * Constructor por defecto de asistente


     */
	public GestorAsistentes() {
		
	}
	
	/**

     * Método para dar de alta a un asistente en el fichero de asistentes.

     * @param asis asistente que queremos dar de alta en el sistema.
     * 
     */
	public void darAltaasistente(Asistente asis) {
		
		
	      BufferedReader br = null;
	      boolean esta=false;
	      try {
	    	  
	    	  propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
	      File archivo =  new File(propiedades.getProperty("asistente"));
	      
	      
	      
	    	  
	       // Abrir el .csv en buffer de lectura
	       br = new BufferedReader(new FileReader(archivo));
	       
	       // Leer una linea del archivo
	       String linea;
	       while ((linea = br.readLine()) != null && esta== false) {
	        // Separar la linea leída con el separador definido previamente
	        String[] campos = linea.split(" , "); 
	        
	        
	        if(Integer.parseInt(campos[0])== asis.getId()) {
	        	esta=true;
	        	
	        }
	        
	        
	       }
	       if(esta) {
	    	   System.out.println("El asistente ya existe");
	       }else {
	    	  PrintWriter escribir = new PrintWriter(new FileWriter(archivo,true));
	    	  String fechanacimiento = asis.getFnacimientoString();
	    	  String completo = asis.getId()+" , "+asis.getNombre()+" , "+fechanacimiento +" , "+asis.getEspecial()+"\n";
	    	  escribir.write(completo);
	    	  escribir.close();
	       }
	      } catch (FileNotFoundException e) {
	          e.printStackTrace();
	      }	catch(IOException a) {
	    	  a.printStackTrace();
	      }
		
	}
	
	
	/**

     * Método para modificar la información de un asistente. Si en los parametros le pasamos la información "NO" no se cambia la información
     * de ese parámetro.

     * @param id identificador del asistente que deseamos modificar.
     * @param fnacNueva fecha de nacimiento que deseamos modificar en el asistente.
     * @param nombreNuevo nombre que deseamos modificar en el asistente.
     * @param idnuevo id que desemaos modificar en el asistente.
     * 
     */
	public void modificarInfo(int id,String nombreNuevo,Date fnacNueva, boolean especial) {
		 BufferedReader reader = null;
	      boolean esta=false;
	    //declaración de strings para modificar
	      SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	      String fech = formato.format(fnacNueva);
	      
	      String fecha="";
	      String nombre="";
	      try {
	    	  propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
	      File archivo =  new File(propiedades.getProperty("asistente"));
	      File archivomod =  new File(propiedades.getProperty("asistentemod"));
	      
	      
	      //boleano para cambiar los datos por los parametros dados o no
	      boolean nom1=false;
	      boolean fnac1=false;
	     
	      if(!archivo.exists()) {
	    	  archivo.createNewFile();
	      }
	      if(!archivomod.exists()) {
	    	  archivomod.createNewFile();
	      }
	      
	    	  
	       // Abrir el .csv en buffer de lectura
	       reader = new BufferedReader(new FileReader(archivo));
	       int cont=-1;
	       PrintWriter escribir = new PrintWriter(new FileWriter(archivomod,true));
	       
	       // Leer una linea del archivo
	       String linea;
	       while ((linea = reader.readLine()) != null ) {
	        cont++;
	        String[] campos = linea.split(" , "); 
	        
	        
	        if(Integer.parseInt(campos[0])== id) {
	        	esta = true;
	        	
	        	if(nombreNuevo.equals("NO")) {
	  	    	  nombre = campos[1];
	  	    	  nom1=true;
	  	      }else {
	  	    	  nombre = nombreNuevo;
	  	      }
	        	
	        	if(fech.equals("00/00/0000")) {
		  	    	  fecha = campos[2];
		  	    	  fnac1=true;
		  	    	
		  	      }else {
		  	    	  fecha = fech;
		  	      }
	        	
	        	String completo  = id+" , "+nombre+" , "+ fecha+" , "+especial;
		        linea = completo;
	        }
	        
	        escribir.write(linea);
	 		   escribir.write("\n"); 
	       }
	       
	       
	       escribir.close();
	       
	       if(!esta) {
	    	   System.out.println("El id no esta asignado a ningún asistente");
	       }else {
	    	   
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
	    		    	
	    		  }
	       }
	      		} catch (IOException e) {
	    			    e.printStackTrace();
	      		}
	      
	}
	
	

	/**

     * Método para listar los asistentes existentes.

     */
	public void listaasistentes() {
		BufferedReader br = null;
	      //boolean esta=false;
	      try {
	      propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
	      File archivo =  new File(propiedades.getProperty("asistente"));
	      
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
	    		  
	    		  
	        
	    		  System.out.println("asistente nº "+cont+": "+ linea);
	    		  
	        
	       }
	      }catch (FileNotFoundException e) {
	    	  e.printStackTrace();
    	} catch(IOException a) {
	    	  a.printStackTrace();
	      }
	}
	
	
	public int asignarid() {
		BufferedReader br = null;
		int cont=0;
	      //boolean esta=false;
	      try {
	      propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
	      File archivo =  new File(propiedades.getProperty("asistente"));
	      
	      if(!archivo.exists()) {
	    	  archivo.createNewFile();
	      }
	      
	    	  
	    	  // Abrir el .csv en buffer de lectura
	    	  br = new BufferedReader(new FileReader(archivo));
	       
	    	  // Leer una linea del archivo
	    	  String linea;
	    	  
	    	  while ((linea = br.readLine()) != null) {
	    		  cont += 1;
	    		  
	    		  
	        
	    		  System.out.println("asistente nº "+cont+": "+ linea);
	    		  
	        
	       }
	      }catch (FileNotFoundException e) {
	    	  e.printStackTrace();
    	} catch(IOException a) {
	    	  a.printStackTrace();
	      }
	      return cont+1;
	}
	
	public boolean buscarid(int id) {
		BufferedReader br = null;
	    boolean existe=false;
	   
	    try {
	    	 propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
		     File archivo =  new File(propiedades.getProperty("asistente"));
		     br = new BufferedReader(new FileReader(archivo));
		     
		     String linea;
		     while((linea = br.readLine()) != null && existe== false) {
		    	 String[] campos = linea.split(" , "); 
		    	 
		    	 if(Integer.parseInt(campos[0])== id) {
		    		 existe = true;
		    		 
		    		
		    		 
		    		 
		    		 
		    		 
			     }
		    	 
		     }
		     
		     if(!existe) {
		    	   System.out.println("No existe el asistente asignado\n");
		     }
		    
	    } catch (FileNotFoundException e) {
	          e.printStackTrace();
	      }	catch(IOException a) {
	    	  a.printStackTrace();
	      }
	    return existe;
	}
	
	public boolean buscarNombre(String nombre) {
		BufferedReader br = null;
	    boolean existe=false;
	   
	    
	    try {
	    	 propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
		     File archivo =  new File(propiedades.getProperty("loginuser"));
		     br = new BufferedReader(new FileReader(archivo));
		     
		     String linea;
		     while((linea = br.readLine()) != null && existe== false) {
		    	 String[] campos = linea.split(" , "); 
		    	 
		    	 if(campos[2].equals(nombre)) {
		    		 existe = true;
		    		 
		    		
		    		 
		    		 
		    		 
		    		 
			     }
		    	 
		     }
		     
		     if(!existe) {
		    	   System.out.println("No existe el asistente asignado\n");
		     }
		    
	    } catch (FileNotFoundException e) {
	          e.printStackTrace();
	      }	catch(IOException a) {
	    	  a.printStackTrace();
	      }
	    return existe;
	}
	
	public Asistente buscarasistente(int id) {
		BufferedReader br = null;
	    boolean existe=false;
	    Asistente asis = new Asistente();
	    Date fnac = new Date();
	    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	    boolean especial = false;
	    try {
	    	 propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
		     File archivo =  new File(propiedades.getProperty("asistente"));
		     br = new BufferedReader(new FileReader(archivo));
		     
		     String linea;
		     while((linea = br.readLine()) != null && existe== false) {
		    	 String[] campos = linea.split(" , "); 
		    	 
		    	 if(Integer.parseInt(campos[0])== id) {
		    		 existe = true;
		    		 
		    		 try {
						fnac = formato.parse(campos[2]);
						
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    		 if(campos[3] == "true") {
		    			 especial = true;
		    		 }
		    		 
		    		 asis=new Asistente(id,campos[1],fnac,especial);
		    		 
			     }
		    	 
		     }
		     
		     if(!existe) {
		    	   System.out.println("No existe el asistente asignado\n");
		     }
		    
	    } catch (FileNotFoundException e) {
	          e.printStackTrace();
	      }	catch(IOException a) {
	    	  a.printStackTrace();
	      }
	    return asis;
	}
	
	public String buscarasistenteLogin(String user) {
		BufferedReader br = null;
	    boolean existe=false;
	    String id="";
	    
	    try {
	    	 propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
		     File archivo =  new File(propiedades.getProperty("loginuser"));
		     br = new BufferedReader(new FileReader(archivo));
		     
		     String linea;
		     while((linea = br.readLine()) != null && existe== false) {
		    	 String[] campos = linea.split(" , "); 
		    	 
		    	 if(campos[2].equals(user)) {
		    		 existe = true;
		    		 
		    		
		    		 
		    		 id = campos[2];
		    		 
			     }
		    	 
		     }
		     
		     if(!existe) {
		    	   System.out.println("No existe el asistente asignado\n");
		     }
		    
	    } catch (FileNotFoundException e) {
	          e.printStackTrace();
	      }	catch(IOException a) {
	    	  a.printStackTrace();
	      }
	    return id;
	}
	
	public boolean Eliminarasistente(int asis) {
		BufferedReader reader = null;
		boolean sepuede = false;
	      try {
	      propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
	      File archivo =  new File(propiedades.getProperty("asistente"));
	      File archivomod =  new File(propiedades.getProperty("asistentemod"));
	      
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
	    		  
	    		  if(Integer.parseInt(campos[0])== asis) {
	    			  
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
	
	/**
     * Método para calcular la edad del asistente
     * 
     * @return devuelve el número de años que tiene el asistente.
     * 
     */
	public int calcularedad(Asistente asis) {
		Date actual = new Date();
		long calcular = actual.getTime() - asis.getFnacimientoDate().getTime();
		
        TimeUnit time = TimeUnit.DAYS; 
        long diffrence = time.convert(calcular, TimeUnit.MILLISECONDS);
        int cont=0;
        while(diffrence>0) {
        	diffrence = diffrence -365;
        	cont++;
        }
		return cont;
	}
	
	
	/**
     * Método para calcular la antigüedad que tiene el asistente.
     * 
     * @return devuelve el número de años que tiene de antigüedad el asistente.
     * 
     */
	 public static int calculateAge(Date birthDate, Date currentDate) {
	        Calendar birthCal = Calendar.getInstance();
	        birthCal.setTime(birthDate);

	        Calendar currentCal = Calendar.getInstance();
	        currentCal.setTime(currentDate);

	        int age = currentCal.get(Calendar.YEAR) - birthCal.get(Calendar.YEAR);
	       
	        // Ajustar la edad si aún no ha pasado el cumpleaños este año
	        if (currentCal.get(Calendar.DAY_OF_YEAR) < birthCal.get(Calendar.DAY_OF_YEAR)) {
	            age--;
	        }

	        return age;
	    }
	
	
	
		
};