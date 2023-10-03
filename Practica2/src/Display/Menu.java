package Display;
/*----------------------------------------------------------------------------------------
 * AVISOS
 * Cuando hagais login poned los datos de los ficheros de propiedades que estan en github, tenedlos en la misma carpeta que el main o cambiad la ruta.
 * Para asistente PRUEBA y CONTRASEÑA, para admin ADMIN y ADMIN.
  
 ------------------------------------------------------------------------------------------*/

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import business.actividad.*;
import business.asistente.*;
import business.campamento.*;
import business.inscripcion.*;


public class Menu {
	static Properties propiedades = new Properties();
	private static Scanner input_ = new Scanner(System.in); //Utilizado para los switchers
	private static Scanner lectura_ = new Scanner(System.in); //Utilizado para lecturas normmales
	private static boolean logStatus_; //para verificar el log in o no
	private static int userRole_=0; //para asignar un rol de cara a los menus: 1 para users, 2 para admin
	private static String LogUser_ = "C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\LoginUsers.txt";
	private static String LogAdmin_ = "C:\\\\Users\\\\adria\\\\eclipse-workspace\\\\Practica 1\\\\src\\\\data\\ficheros\\LoginAdmins.txt";
	//Instancias
	public static Actividad kart_ = new Actividad();
	public static Properties Prop_ = new Properties(); // Este para controlar los login
	private static Properties sql_ = new Properties(); // Este para las operaciones con la BBDD
	public static Asistente asistente_ = new Asistente();
	public static Campamento actividad_ = new Campamento();
	public static Inscripcion reserva_;
	public static GestorReservas GReservas_ = new GestorReservas();
	public static GestorCampamentos Gactividades_ = new GestorCampamentos();
	public static GestorAsistentes GUsu_ = new GestorAsistentes();
	
	public static void clearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

	public static void menuInicio() {
		
		System.out.println("\nBienvenido/a por favor, seleccione como desea acceder al sistema: \n1. asistente \n2. Administrador \n3. Salir. ");
	}
	
	public static void menuAdmin() {
		System.out.println("\nPor favor seleccione una opción \n1. Gestionar asistentes \n2. Gestionar actividades \n3. Gestionar campamentos \n4. Salir");
	}
	
	public static void menuUser() { 
		System.out.println("\n¿Que desea hacer? \n1. Consultar actividads disponibles segun parametros y reservar \n2. Consultar karts disponibles \n3. Reservar kart \n4. Modificar mis reservas \n5. Cancelar una reserva \n6. Mi informacion \n7.  Salir");
	}
	
	public static void menuGAsistentes() {
		System.out.println("\n1. Dar de alta un asistente \n2. Modificar la informacion de un asistente \n3. Listar asistentes registrados \n4. Eliminar asistente \n5. Volver al menu \n6. Salir");
	}
	
	public static void menuGActividades() {
		System.out.println("\n1. Crear actividad \n2. Listar actividades \n3. Cambiar tipo actividad \n4. Eliminar actividad \n5. Volver atras \n6. Salir");
	}
	
	public static void menuGCampamentos() {
		System.out.println("\n1. Crear campamento \n2. Listar campamento \n3. Añadir personas \n4. Asociar monitor a actividad \n5. Eliminar campamento \n6. Eliminar actividad \n6. Volver atras \n8. Salir");
	}
	
	public static void menuGReservas() {
		
	}
	
	//Constructor para inicializar el resto de clases.
	public Menu(int userdefault, boolean logstatus, GestorCampamentos Gactividads,GestorAsistentes GUsu, GestorReservas GReservas, Actividad kart1, Asistente user, Campamento actividad,Inscripcion res) {
		
		userRole_ = userdefault = 0;
		logStatus_ = logstatus = false;		
		GReservas_ = GReservas;
		Gactividades_ = Gactividads;
		GUsu_ = GUsu;
		kart_ = kart1;
		asistente_ = user;
		actividad_ = actividad;
		reserva_ = res;
		
	}
	
	public static void main(String[] args) {
		try {
			propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int switcher; 
		Temprano Reserva = new Temprano() ; // Puntero al objeto Reserva para poder usar sus metodos.
		Tardio bono = new Tardio() {}; // Lo mismo pero para el bono.
		//Estos dos mejor los dejamos asi porque en la clase asistente no tenemos un campo passwd;
		String asistente = "default";
		String passwd = "default";
		int id;
		int control=0;
		logStatus_ = true;
		
		
		String auxfecha; // Para pasar como string la fecha de nacimiento
		String nombre;
		String especial;
		String fecha="";
		Date Fechanac = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		int controlFecha = 0;
		int controlespecial = 0;
		int controlid = 0;
		/*
		System.out.println("\nSi desea abandonar el proceso, introduzca 'salir' en ambos campos");
		
		
		int test = 0;
		test = lectura_.nextInt(); // 1 o 2 
		*/
		// Pongo todo esto comentado para no tener que lidiar con el login en las pruebas.
		
		do {
			//clearConsole();
			menuInicio();
			switcher = input_.nextInt();
			switch(switcher) {
			case 1: 
				System.out.println("\n1. Registro \n2. Inicio de sesion \n3. Volver \n4. Salir");
				control = lectura_.nextInt();
				
					while (control >4 || control <0) {
						System.out.println("\n Por favor, introduzca un valor valido");
						control = lectura_.nextInt();
						
						
					
					}
					switch (control) {
					case 1:
						BufferedReader br = null;
						
					    boolean esta=false;
					try {
						
					      File archivo =  new File(propiedades.getProperty("loginuser"));
					      File archivousu =  new File(propiedades.getProperty("asistente"));
					      
						
						
						System.out.println("\nPor favor introduzca el nombre de usuario que desea:");
						asistente = lectura_.next();
						while(GUsu_.buscarNombre(asistente)){
							System.out.println("\nEse usuario ya existe intente otro");
							asistente = lectura_.next();
						}
							
						asistente_.setNombre(asistente);
						System.out.println("\nPor favor introduzca su contraseña que desea:");
						passwd = lectura_.next();
						
						System.out.println ("\nIntroduzca la fecha de nacimiento en el siguiente formato dd/MM/yyyy");
						auxfecha = lectura_.next();
						while (controlFecha == 0) {
							try {
								Fechanac = formato.parse(auxfecha);
								controlFecha = 1;
							}
							catch (ParseException a) {
								a.printStackTrace();
								System.out.println("\n Por favor introduzca un valor siguiendo el formato dd/MM/yyyy");
								auxfecha = lectura_.next();
							}					
						}
						asistente_.setFnacimiento(Fechanac);
						System.out.println("\nNecesita atención especial: ");
						especial = lectura_.next();
						while (controlespecial == 0) {
							
							if (especial != "si" && especial != "no"){
								System.out.println("\nPor favor introduzca un valor adecuado");
								especial = lectura_.next();
							}else {
									controlespecial = 1;
								}
						}
						if(especial == "si") {
							asistente_.setEspecial(true);
						}else {
							asistente_.setEspecial(false);
						}
						
						
						// Abrir el .csv en buffer de lectura
					       br = new BufferedReader(new FileReader(archivo));
					       
					       // Leer una linea del archivo
					       String linea;
					       while ((linea = br.readLine()) != null && esta== false) {
					        // Separar la linea leída con el separador definido previamente
					        String[] campos = linea.split(" , "); 
					        
					        
					        if(campos[0].equals(asistente)) {
					        	esta=true;
					        	
					        }
					       }
					       if(esta) {
					    	   System.out.println("El asistente ya esta registrado");
					       }else {
					    	   asistente_.setId(GUsu_.asignarid());
					    	   PrintWriter escribir = new PrintWriter(new FileWriter(archivo,true));
					    	   String completo = nombre+" , "+ passwd+" , "+ asistente +" , "+ asistente_.getId()+"\n";
						    	  escribir.write(completo);
						    	  escribir.close();
						    	  System.out.println("asistente registrado con exito");
						    	  GUsu_.darAltaasistente(asistente_);
					       }
					}
					catch (FileNotFoundException e) {
						    e.printStackTrace();
					}	catch(IOException a) {
						   a.printStackTrace();
					}
					break;
					
					case 2:
						 br = null;
					     esta=false;
					try {
						propiedades.load(new FileReader("C:\\Users\\adria\\eclipse-workspace\\Practica 1\\src\\data\\ficheros\\config.properties"));
					      File archivo =  new File(propiedades.getProperty("loginuser"));
					      
						while (logStatus_ != true)
						System.out.println("\nSi desea abandonar el proceso, introduzca 'salir' en ambos campos");
						System.out.println("\nPor favor introduzca su nombre de usuario:");
						asistente = lectura_.next();
						System.out.println("\nPor favor introduzca su contraseña");
						passwd = lectura_.next();
						if (asistente == "salir" && passwd =="salir")
						{
							System.out.println ("\nSaliendo del sistema...");
							System.exit (0);
						}
						
						// Abrir el .csv en buffer de lectura
					       br = new BufferedReader(new FileReader(archivo));
					       
					       // Leer una linea del archivo
					       String linea;
					       while ((linea = br.readLine()) != null && esta== false) {
					        // Separar la linea leída con el separador definido previamente
					        String[] campos = linea.split(" , "); 
					        
					        
					        if(campos[2].equals(asistente) && campos[1].equals(passwd)) {
					        	esta=true;
					        	
					        }
					       }
					       if(esta) {
					    	   System.out.println("\n Acceso autorizado");
					    	   logStatus_ = true;
								userRole_ = 1; //para asistentes normales
								break;
								
							
					       }else {
								System.out.println("\nasistente no encontrado, intentelo de nuevo");
								
								
							}
						
					}
					catch (FileNotFoundException e) {
				          e.printStackTrace();
				      }	catch(IOException a) {
				    	  a.printStackTrace();
				      }
					break;
					case 3:
						switcher = 0;
						break;
					case 4:
						System.out.println("\n Saliendo del sistema...");
						System.exit(0);
					}
				
				break;
				
			case 2:
			try {
				BufferedReader reader2 = new BufferedReader(new FileReader(LogAdmin_));
				Prop_.load(reader2);
				while (logStatus_ != true) 
				System.out.println("\nSi desea abandonar el proceso, introduzca 'salir' en ambos campos");
				System.out.println("\nPor favor introduzca su nombre de asistente:");
				asistente = lectura_.next();
				System.out.println("\nPor favor introduzca su contraseña");
				passwd = lectura_.next();
				if (asistente == "salir" && passwd =="salir")
				{
					System.out.println ("\nSaliendo del sistema...");
					System.exit (0);
				}
				
				String usu = Prop_.getProperty("asistente");
				String cont = Prop_.getProperty("contraseña");
				if(asistente.equals(usu) && passwd.equals(cont)) {
					System.out.println("\n Acceso autorizado");
					logStatus_ = true;
					userRole_ = 2; //para admins
					break;
				}
				else {
					System.out.println("\nasistente no encontrado, intentelo de nuevo");
				}
				
				break;
			}
			catch (FileNotFoundException e) {
		          e.printStackTrace();
		      }	catch(IOException a) {
		    	  a.printStackTrace();
		      }
			case 3:
				System.out.println("\n Saliendo del sistema...");
				System.exit(0);
			default:
				System.out.println("\nPor favor introduzca una opcion valida para el sistema");
				break;
			}
		} while (userRole_==0);
		
		// Control del rol de acceso al sistema
		
		
		
		if (logStatus_ = false) {
			System.out.println("\nNo se ha podido completar la autenticacion, saliendo...");
			System.exit(0);
		}
		// Menu de administrador
		if (userRole_ == 2) {
			int switcher2; //Nuevo switcher para evitar problemas en los nuevos menus
			System.out.println("\nBienvenido " + asistente +" ha accedido como administrador al sistema"); // 
			//DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			do {
				//clearConsole();
				menuAdmin();
				switcher2 = input_.nextInt();
				switch (switcher2) {
				case 1:
					int switcherUserMenu;
					do {
						menuGAsistentes();
						switcherUserMenu = input_.nextInt();
						switch (switcherUserMenu) {
						case 1:
							int controlador = 0;
							while (controlador ==0  || controlador==1) {
							System.out.println("\nIntroduzca los datos");
							System.out.println ("\nNombre: ");
							asistente_.setNombre(lectura_.next());
							System.out.println ("\nIntroduzca la fecha de nacimiento en el siguiente formato dd/MM/yyyy");
							auxfecha = lectura_.next();
							while (controlFecha == 0) {
								try {
									Fechanac = formato.parse(auxfecha);
									controlFecha = 1;
								}
								catch (ParseException a) {
									a.printStackTrace();
									System.out.println("\n Por favor introduzca un valor siguiendo el formato dd/MM/yyyy");
									auxfecha = lectura_.next();
								}					
							}
							asistente_.setFnacimiento(Fechanac);
							System.out.println("\nNecesita atención especial: ");
							especial = lectura_.next();
							while (controlespecial == 0) {
								
								if (especial != "si" && especial != "no"){
									System.out.println("\nPor favor introduzca un valor adecuado");
									especial = lectura_.next();
								}else {
										controlespecial = 1;
									}
							}
							if(especial == "si") {
								asistente_.setEspecial(true);
							}else {
								asistente_.setEspecial(false);
							}
							
							asistente_.setId(GUsu_.asignarid());
							
							GUsu_.darAltaasistente(asistente_);
							System.out.println("\n1. Añadir otro asistente \n2. Volver al menu principal \n3. Salir");
							controlador = lectura_.nextInt();
							}
							if (controlador >3 || controlador <0) {
								while (controlador>3 || controlador <0) {
									System.out.println("\n Por favor, introduzca un valor valido");
									controlador = lectura_.nextInt();
									if (controlador == 2) {
										switcherUserMenu = 0;
										break;
									}
									
									if (controlador == 3) {
										System.out.println("\n Saliendo del sistema...");
										System.exit(0);
									}	
								}
							}
							break;
							
						case 2:
							int controlador2 = 0;
							while (controlador2 == 0 || controlador2 == 1) {
							System.out.println("\nPor favor, introduzca el id del asistente que desea modificar: ");
							id = lectura_.nextInt();
							while (controlid == 0) {
								 if(!GUsu_.buscarid(id)){
									System.out.println("\nEse asistente no existe intentelo otra vez");
									id = lectura_.nextInt();
									}else {
										controlid = 1;
									}
							}
							asistente_.setId(id);
							System.out.println("\nPor favor introduzca los datos que desea modificar, si no desea modificar alguno de los datos ponga NO");
							System.out.println("\nNombre: ");
							nombre = lectura_.next();
							System.out.println("\nFecha de nacimiento: ");
							auxfecha = lectura_.next();
							while (controlFecha == 0) {
								try {
									Fechanac = formato.parse(auxfecha);
									controlFecha = 1;
									
								}
								catch (ParseException a) {
									a.printStackTrace();
									System.out.println("\n Por favor introduzca un valor siguiendo el formato dd/MM/yyyy");
									auxfecha = lectura_.next();
								}					
							}
							System.out.println("\nAsistencia especial: ");
							especial = lectura_.next();
							
							if(especial == "si") {
								asistente_.setEspecial(true);
							}else {
								asistente_.setEspecial(false);
							}
							
							asistente_.setFnacimiento(Fechanac);
							GUsu_.modificarInfo(asistente_.getId(), nombre, Fechanac, asistente_.getEspecial());
							System.out.println("\n1. Modificar otro asistente \n2. Volver al menu principal \n3. Salir");
							controlador2 = lectura_.nextInt();
							}
							if (controlador2 >3 || controlador2 <0) {
								while (controlador2>3 || controlador2 <0) {
									System.out.println("\n Por favor, introduzca un valor valido");
									controlador2 = lectura_.nextInt();
									if (controlador2 == 2) {
										switcherUserMenu = 0;
										break;
									}
									if (controlador2 == 3) {
										System.out.println("\n Saliendo del sistema...");
										System.exit(0);
									}	
								}
							}
							break;
						case 3: 
							int controlador3 = 0;
							while (controlador3 !=2) {
							System.out.println("\nLista de asistentes: ");
							  GUsu_.listaasistentes();
							  System.out.println(" \n1. Volver al menu principal \n2. Salir");
							  controlador3 = lectura_.nextInt();
							  if (controlador3 == 1) {
									switcherUserMenu = 0;
									break;
								}
								if (controlador3 == 2) {
									System.out.println("\n Saliendo del sistema...");
									System.exit(0);
								}
							}
							break;
						case 4:
							System.out.println("\nPor favor, introduzca el id del asistente que desea eliminar: ");
							id = lectura_.nextInt();
							while (controlid == 0) {
								
								 if(!GUsu_.Eliminarasistente(id)){
									System.out.println("\nEse asistente no existe intentelo otra vez");
									id = lectura_.nextInt();
									}else {
										controlid = 1;
									}
							}
							
							break;
						case 5:
							switcherUserMenu = 0;
							break;
						case 6:
							System.out.println("\n Saliendo del sistema...");
							System.exit(0);
						default:
							System.out.println("\nPor favor introduzca un valor valido para el sistema");
							break;
						}
					}while (switcherUserMenu != 0);
					break;
				case 2:
					int switcherMenuactividads;
					int auxiliar;
					int auxiliar2;
					do {
						//clearConsole();
						menuGActividades();
						switcherMenuactividads = input_.nextInt();
						switch (switcherMenuactividads) {
						case 1:
							
								System.out.println("\n Introduzca los datos de la actividad");
								System.out.println("\n Nombre: ");
								actividad_.setNombre(lectura_.next()); 
								System.out.println("\n Nivel educativo de la actividad: \n1. Infantil \n2. Juvenil \n3. Adolescente");
								auxiliar2 = input_.nextInt();
								while(auxiliar2 < 0 || auxiliar2 > 3) { //Controlador para evitar errores
									System.out.println("\nPor favor introduzca un valor valido");
									auxiliar2 = input_.nextInt();
								}
								switch (auxiliar2) {
								case 1:
									actividad_.setTipo(NivelEducativo.infantil);
									System.out.println("\n Nivel educativo infantil confirmado");
									break;
								case 2:
									actividad_.setTipo(NivelEducativo.juvenil);
									System.out.println("\n Nivel educativo familiar confirmado");
									break;
								case 3:
									actividad_.setTipo(NivelEducativo.adolescente);
									System.out.println("\n Nivel educativo adultos confirmado");
									break;
								}
								System.out.println("\n Horario de la actividad: \n1. Mañana \n2. Tarde ");
								auxiliar2 = input_.nextInt();
								while(auxiliar2 < 0 || auxiliar2 > 3) { //Controlador para evitar errores
									System.out.println("\nPor favor introduzca un valor valido");
									auxiliar2 = input_.nextInt();
								}
								switch (auxiliar2) {
								case 1:
									actividad_.setHorario("mañana");
									System.out.println("\n Horario de mañana confirmado");
									break;
								case 2:
									actividad_.setHorario("tarde");
									System.out.println("\n Horario de tarde confirmado3 confirmado");
									break;
								}
								
								System.out.println("\n Maximo de monitores: ");
								actividad_.setNummonitores(lectura_.nextInt());
								Gactividades_.crearactividad(actividad_.nombre, actividad_.Estadoactividad, actividad_.Nivel educativo, actividad_.maxkarts); 
								break;
								
							
								
							
							break;
						case 2:
							System.out.println("\n1. Listar actividads en mantenimiento \n2. Listar actividads disponibles \n3. Salir");
							auxiliar = input_.nextInt();
							while(auxiliar < 1 || auxiliar > 3) { //Controlador para evitar errores
								System.out.println("\nPor favor introduzca un valor valido");
								auxiliar2 = input_.nextInt();
							}
							switch (auxiliar) {
							case 1:
								System.out.println("\n Estas son las actividads en mantenimiento: ");
								Gactividades_.listaractividadsMantenimiento();
								break;
							case 2:
								System.out.println("\n Estas son las actividads disponibles: ");
								Gactividades_.listaractividadsDisponibles();
								break;
							
							case 3:
								System.out.println("\n Volviendo al menú");
								break;
							}
							break;
							
						case 3:
							System.out.println("\n Introduzca el nombre de la actividad que quiere cambiar: ");
							String nom = lectura_.next();
							System.out.println("\n1. Cambiar actividad a mantenimiento \n2. Cambiar actividad a disponible \n3. Salir");
							auxiliar = input_.nextInt();
							while(auxiliar < 1 || auxiliar > 3) { //Controlador para evitar errores
								System.out.println("\nPor favor introduzca un valor valido");
								auxiliar = input_.nextInt();
							}
							switch (auxiliar) {
							case 1:
								Gactividades_.CambiaractividadMantenimiento(nom);
								break;
							case 2:
								Gactividades_.CambiaractividadDisponible(nom);
								break;
							case 3:
								System.out.println("\n Volviendo al menú");
								break;
							}
							break;
							
						case 4:
							System.out.println("\n Estos son las karts disponibles: ");
							Gactividades_.listarKarts();
							break;
						case 5:
							
							System.out.println("\n Introduzca el id del kart a asociar : ");
							int art = Integer.parseInt(lectura_.next());
							System.out.println("\n Introduzca el nombre de la actividad a asociar: ");
							nom = lectura_.next();
							
							if(!Gactividades_.Asociarkartactividad(nom, art)) {
								
									System.out.println("\nNo se ha podido efectuar la operacion");
									System.out.println("\nVolviendo al menu");
									break;
								
							}
							break;
						case 6:
							System.out.println("\n1. Eliminar actividad \n2. Eliminar kart");
							auxiliar = input_.nextInt();
							while(auxiliar < 1 || auxiliar > 2) { //Controlador para evitar errores
								System.out.println("\nPor favor introduzca un valor valido");
								auxiliar2 = input_.nextInt();
							}
							switch (auxiliar) {
							case 1:
								System.out.println("\n Introduzca el nombre de la actividad a eliminar: ");
								nom = lectura_.next();
								if(!Gactividades_.Eliminaractividad(nom)) {
									
									System.out.println("\nNo se ha podido efectuar la operacion");
									System.out.println("\nVolviendo al menu");
									break;
								
							}
								break;
							case 2:
								System.out.println("\n Introduzca el id del kart a eliminar: ");
								String kartid = lectura_.next();
								if(!Gactividades_.EliminarKart(kartid)) {
									
									System.out.println("\nNo se ha podido efectuar la operacion");
									System.out.println("\nVolviendo al menu");
									break;
								
							}
								break;
							}
							break;
						case 7:
							switcherMenuactividads = 0;
							break;
						case 8:
							System.out.println("\nSaliendo del sistema...");
							System.exit(0);
							break;
						}
					} while(switcherMenuactividads != 0);
					break;
					
				case 3:
					System.out.println("\nSaliendo del sistema..");
					System.exit(0);
					
				default :
					System.out.println("\nPor favor introduzca una opcion valida");
					break;
				}
			}while (switcher2 != 0);
		}
		
		//Menu de asistentes normales
		else if (userRole_ == 1) {
			System.out.print("\033[H\033[2J");  
			System.out.flush(); 
			System.out.println("\nBienvenido " + asistente);
			int switcher3;
			int auxiliar4=0;
			int auxswitch;
			int adultos = 0;
			int ninos = 0;
			String auxstring = "default";
			String pist;
			int idres = 0;
			int dur = 0;
			int idbono=0;
			int numres=3;
			float preciofinal=0;
			float precio=0;
			String fechares;
			String tipo="";
			String nomb="";
			Date FechaReserva = null;
			int controlDuracion = 0;
			int switcherConfirmacion;
			int auxcontrol = 0;
			
			Date current = new Date();
			Calendar calendar = Calendar.getInstance();
	        calendar.setTime(current);
	        calendar.add(Calendar.DAY_OF_YEAR, 1); // Suma un día

	        Date newDate = calendar.getTime();
			
			do {
				//clearConsole();
				menuUser();
				switcher3 = input_.nextInt();
				switch (switcher3) {
				case 1:
					System.out.println("\n Tipo de actividad: \n1. Infantil \n2. Familiar \n3. Adultos");
					auxswitch = input_.nextInt();
					while(auxswitch < 0 || auxswitch > 3) { //Controlador para evitar errores
						System.out.println("\nPor favor introduzca un valor valido");
						auxswitch = input_.nextInt();
					}
					switch (auxswitch) {
					case 1:
						actividad_.setNivel educativo(actividad_.Nivel educativo.infantil); 
						System.out.println("\n Nivel educativo infantil confirmada");
						System.out.println("\n Introduzca el numero de niños");
						ninos =lectura_.nextInt();
						while(ninos < 0 || ninos > 100) { //Controlador para evitar errores
							System.out.println("\nPor favor introduzca un valor valido");
							ninos = input_.nextInt();
						}
						tipo = "infantil";
						break;
					case 2:
						actividad_.setNivel educativo(actividad_.Nivel educativo.familiar);
						System.out.println("\n Nivel educativo familiar confirmada");
						System.out.println("\n Introduzca el numero de adultos y de niños");
						System.out.println("\n Adultos :");
						adultos =lectura_.nextInt();
						while(adultos < 0 || adultos > 100) { //Controlador para evitar errores
							System.out.println("\nPor favor introduzca un valor valido");
							adultos = input_.nextInt();
						}
						System.out.println("\n Niños :");
						ninos =lectura_.nextInt();
						while(ninos < 0 || ninos > 100) { //Controlador para evitar errores
							System.out.println("\nPor favor introduzca un valor valido");
							ninos = input_.nextInt();
						}
						tipo = "familiar";
						break;
					case 3:
						actividad_.setNivel educativo(actividad_.Nivel educativo.adultos);
						System.out.println("\n Nivel educativo adultos confirmada");
						System.out.println("\n Introduzca el numero de adultos: ");
						adultos =lectura_.nextInt();
						while(adultos < 0 || adultos > 100) { //Controlador para evitar errores
							System.out.println("\nPor favor introduzca un valor valido");
							adultos = input_.nextInt();
						}
						tipo = "adultos";
						break;

					}
					System.out.println("\nLas actividads disponibles con los parametros seleccionados son: ");
					int cont = Gactividades_.listaractividadsPar(ninos+adultos, tipo);
					
					
					System.out.println(" \n1. Realizar una reserva \n2. Volver al menu principal \n3. Salir");
					  auxiliar4 = lectura_.nextInt();
					  while(auxiliar4 ==1 && cont == 0) { //Controlador para evitar errores
							System.out.println("\nNo hay ninguna actividad para reservar");
							auxiliar4 = input_.nextInt();
							
						}
					  while(auxiliar4 < 0 || auxiliar4 > 2) { //Controlador para evitar errores
							System.out.println("\nPor favor introduzca un valor valido");
							auxiliar4 = input_.nextInt();
							
						}
						switch (auxiliar4) {
						case 1:
							correounico = GUsu_.buscarasistenteLogin(asistente);
							asistente_ = GUsu_.buscarasistente(correounico);
							///////////////////////////////////////////////////////////////
							int antiguo =GUsu_.calcularAntiguedad(asistente_);
							int descuento=0;
							if(antiguo >= 2) {
								descuento=10;
							}
							System.out.println("\n Introduzca el ID de la actividad que desea Reservar");
							pist = lectura_.next();
							Campamento p = new Campamento();
							actividad_ = Gactividades_.buscaractividad(pist);
							while(actividad_ == p) {
								System.out.println("\n No se ha encontrado la actividad ponga otra ");
								pist = lectura_.next();
								actividad_ = Gactividades_.buscaractividad(pist);
								
								
							}
							System.out.println("\n1. Hacer Reserva individual \n2. Hacer Reserva con bono");
							auxswitch = input_.nextInt();
							while(auxswitch < 0 || auxswitch > 2) {
								System.out.println("\nPor favor introduzca un valor valido");
								auxswitch = input_.nextInt();
							}
							switch(auxswitch) {
							case 1:
								
								System.out.println ("\nIntroduzca la fecha de su Reserva en el siguiente formato dd/MM/yyyy");
								fechares = lectura_.next();
								while (controlFecha == 0) {
									try {
										FechaReserva = formato.parse(fechares);
										controlFecha = 1;
										if(FechaReserva.before(newDate)) {
											System.out.println("\n Por favor introduzca una fecha posterior a "+newDate);
											fechares = lectura_.next();
											controlFecha = 0;
										}
										
									}
									catch (ParseException a) {
										a.printStackTrace();
										System.out.println("\n Por favor introduzca un valor siguiendo el formato dd/MM/yyyy");
										fechares = lectura_.next();
									}					
								}
								System.out.println("\nIntroduzca la duracion de su Reserva 60, 90 o 120 minutos");
								dur = lectura_.nextInt();
								while (controlDuracion == 0) {
									if (dur !=90 && dur !=60 && dur !=120)
									{
										System.out.println("\nPor favor introduzca un valor adecuado");
										dur = lectura_.nextInt();
									}
									else {controlDuracion = 1;};
								}
								
								precio = GReservas_.precioReserva(dur);
								
							    preciofinal = precio - GReservas_.descuento(descuento,precio);
								
								System.out.println("\n El precio de su Reserva es de: "+preciofinal+" euros");								 
								System.out.println("\n Aplicado un descuento del: "+descuento+"%");
								System.out.println("\n ¿Desea confirmar su Reserva? \n1. Si \n2. No");
								switcherConfirmacion = lectura_.nextInt();
								switch (switcherConfirmacion) {
								case 1:
									reserva_ = GReservas_.registrarReserva(asistente_, fechares, dur, actividad_,adultos,ninos, 0, descuento);
									System.out.println("\n Su ID de reserva es: "+ reserva_.getIdReserva());
									System.out.println("\n Reserva creada con exito");
									
									break;
								case 2:
									System.out.println("\n Proceso cancelado");
									break;
								}
								
								break;
							case 2: 
								descuento=5;
								
								System.out.println("\n Introduzca el numero de Reservas entre 3 y 5 sesiones");
								numres = lectura_.nextInt();
								while (auxcontrol != 1) {
									if (numres != 3 || numres !=5)
									{
										System.out.println("Por favor introduzca un valor valido de bono, 3 o 5 sesiones");
									}
									else {auxcontrol = 1;}
								}
								
								System.out.println ("\nIntroduzca la fecha de su Reserva en el siguiente formato dd/MM/yyyy");
								fechares = lectura_.next();
								while (controlFecha == 0) {
									try {
										FechaReserva = formato.parse(fechares);
										controlFecha = 0;
									}
									catch (ParseException a) {
										a.printStackTrace();
										System.out.println("\n Por favor introduzca un valor siguiendo el formato dd/MM/yyyy");
										fechares = lectura_.next();
									}					
								}
								System.out.println("\nIntroduzca la duracion de su Reserva 60, 90 o 120 minutos");
								dur = lectura_.nextInt();
								while (controlDuracion == 0) {
									if (dur !=90 && dur !=60 && dur !=120)
									{
										System.out.println("\nPor favor introduzca un valor adecuado");
										dur = lectura_.nextInt();
									}
									else {controlDuracion = 1;};
								}
								
								 precio = GReservas_.precioReserva(dur);
							     preciofinal = precio - GReservas_.descuento(descuento,precio);
								
								System.out.println("\n El precio de su Reserva es de: "+preciofinal+" euros");								 
								System.out.println("\n Aplicado el descuento del bono de: "+descuento+"%");
								System.out.println("\n ¿Desea confirmar su Reserva? \n1. Si \n2. No");
								switcherConfirmacion = lectura_.nextInt();
								switch (switcherConfirmacion) {
								case 1:
									reserva_ = GReservas_.registrarReserva(asistente_, fechares, dur, actividad_,ninos,adultos, 1, descuento);
									System.out.println("\n Reserva creada con exito");
									System.out.println("\n Su ID de reserva es: "+ reserva_.getId());
									System.out.println("\n Su ID de bono es: "+ reserva_.getIdbono());
									auxiliar4 = lectura_.nextInt();
									  while(auxiliar4 < 0 || auxiliar4 > 1) { //Controlador para evitar errores
											System.out.println("\nPor favor introduzca un valor valido");
											auxiliar4 = input_.nextInt();
										}
									  if(auxiliar4 ==1)
									break;
								case 2:
									System.out.println("\n Proceso cancelado");
									break;
								}
								
							}
							
							
						case 2:
							switcher3 = 0;
							break;
						case 3:
							System.out.println("\n Saliendo del sistema...");
							System.exit(0);
						}
							
						  
						  
						
					  
					
					

						
					
				case 2: 
					System.out.println("\nEstos son los karts disponibles: ");
					Gactividades_.listarKartsDisponibles();
					break;
				case 3:
					
					System.out.println("\n Introduzca el id del kart que quiere reservar: ");
					int id = input_.nextInt();
					while(!Gactividades_.buscarid(id)) {
						System.out.println("\nPor favor introduzca un valor valido");
						id = input_.nextInt();
					}
					Gactividades_.CambiarKartReservado(id);
					break;
					
				case 4:
					correounico = GUsu_.buscarasistenteLogin(asistente);
					System.out.println("\n Introduzca el nombre de la actividad en la que esta la reserva");
					pist = lectura_.next();
					Campamento p = new Campamento();
					actividad_ = Gactividades_.buscaractividad(pist);
					while(actividad_ == p) {
						System.out.println("\n No se ha encontrado la actividad ponga otra ");
						pist = lectura_.next();
						actividad_ = Gactividades_.buscaractividad(pist);
						
						
					}
					int auxiliar =0;
					System.out.println("\n Introduzca el id de la reserva que desea modificar: ");
					int idreserva = input_.nextInt();
					System.out.println("\n1. Cambiar fecha \n2. Cambiar participantes \n3. Cambiar duracion \n4. Salir");
					auxiliar = input_.nextInt();
					while(auxiliar < 1 || auxiliar > 3) { //Controlador para evitar errores
						System.out.println("\nPor favor introduzca un valor valido");
						auxiliar = input_.nextInt();
					}
					switch (auxiliar) {
					
					case 1:
						correounico = GUsu_.buscarasistenteLogin(asistente);
						System.out.println ("\nIntroduzca la fecha nueva de su Reserva en el siguiente formato dd/MM/yyyy");
						fechares = lectura_.next();
						while (controlFecha == 0) {
							try {
								FechaReserva = formato.parse(fechares);
								controlFecha = 1;
								if(FechaReserva.before(newDate)) {
									System.out.println("\n Por favor introduzca una fecha posterior a "+newDate);
									fechares = lectura_.next();
									controlFecha = 0;
								}
								
							}
							catch (ParseException a) {
								a.printStackTrace();
								System.out.println("\n Por favor introduzca un valor siguiendo el formato dd/MM/yyyy");
								fechares = lectura_.next();
							}					
						}
						if(!GReservas_.CambiarFecha(actividad_, idreserva, FechaReserva,correounico)) {
							
							System.out.println("\nNo se ha podido efectuar la operacion");
							System.out.println("\nVolviendo al menu");
							break;
						
					}else {
						System.out.println("Reserva cancelada con exito \n"); 
					}
						break;
					case 2:
						correounico = GUsu_.buscarasistenteLogin(asistente);
						System.out.println ("\nIntroduzca los participantes de la reserva");
						int part = input_.nextInt();
						while(part > actividad_.getMaxkarts()) {
							System.out.println ("\nDemasiados participantes el numero maximo es "+actividad_.getMaxkarts()+" intentelo de nuevo" );
							part = input_.nextInt();
						}
						if(!GReservas_.CambiarParticipantes(actividad_, idreserva, part,correounico)) {
							
							System.out.println("\nNo se ha podido efectuar la operacion");
							System.out.println("\nVolviendo al menu");
							break;
						
					}
						break;
					case 3:
						correounico = GUsu_.buscarasistenteLogin(asistente);
						System.out.println ("\nIntroduzca la duracion de la reserva");
						dur = input_.nextInt();
						while (controlDuracion == 0) {
							if (dur !=90 && dur !=60 && dur !=120)
							{
								System.out.println("\nPor favor introduzca un valor adecuado");
								dur = lectura_.nextInt();
							}
							else {controlDuracion = 1;};
						}
						if(!GReservas_.CambiarDuracion(actividad_, idreserva, dur,correounico)) {
							
							System.out.println("\nNo se ha podido efectuar la operacion");
							System.out.println("\nVolviendo al menu");
							break;
						
					}
						break;
					case 4:
						System.out.println("\n Volviendo al menú");
						break;
					}
					break;
					
					
				case 5:
					correounico = GUsu_.buscarasistenteLogin(asistente);
					System.out.println("\n Introduzca el nombre de la actividad en la que esta la reserva");
					pist = lectura_.next();
					p = new Campamento();
					actividad_ = Gactividades_.buscaractividad(pist);
					while(actividad_ == p) {
						System.out.println("\n No se ha encontrado la actividad ponga otra ");
						pist = lectura_.next();
						actividad_ = Gactividades_.buscaractividad(pist);
						
						
					}
					System.out.println("\n Introduzca el id de la reserva que desea cancelar: ");
					idreserva = input_.nextInt();
					if(!GReservas_.CancelarReserva(actividad_,idreserva,correounico)) {
						
						System.out.println("\nNo se ha podido efectuar la operacion");
						System.out.println("\nVolviendo al menu");
						break;
					
				}
					break;
				case 6:
					
					 
					System.out.println("Esta es su informacion: \n"); 
					correounico = GUsu_.buscarasistenteLogin(asistente);
					asistente_ = GUsu_.buscarasistente(correounico);
					System.out.println(asistente_.toString());
					
					break;
				case 7:
					System.out.println("\nSaliendo del sistema...");
					System.exit(0);
				default:
					System.out.println("Por favor introduzca un valor adecuado");
				}
			}while (switcher3 != 0);		
		}
		
	}
	
}