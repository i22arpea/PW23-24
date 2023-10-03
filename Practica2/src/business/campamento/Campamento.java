package business.campamento;


import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import business.actividad.*;
import business.monitor.Monitor;


/*

 * Esta clase define de que está compuesto un campamento y los métodos asociados a este
 * 
 * @author: Adrián Arroyo Pérez

 * @version: 

 */

public class Campamento extends Actividad {
	
	
	private int id;
	private Date inicio;
	private Date fin;
	private NivelEducativo tipo;
	private int maxasistentes;
	private List<Actividad> listact;
	private List<Monitor> monitores;
	
	
	
	 /**
	 * 
     * Constructor por defecto de campamento
     * 
     */
	public Campamento() {
		listact = new ArrayList<Actividad>();
		monitores = new ArrayList<Monitor>();
	}
	
	/**
     * Constructor parametrizado de la clase campamento.
     * 
     * @param id_ que vamos a inicializar.
     * @param inicio_ .
     * @param fin_ .
     * @param tipo_ .
     * @param maxasistentes_ .
     * 
     */
	public Campamento(int id_,Date inicio_,Date fin_,NivelEducativo tipo_,int maxasistentes_ ) {
		this.id = id_;
		this.inicio = inicio_;
		this.fin = fin_;
		this.tipo = tipo_;
		this.maxasistentes = maxasistentes_;
		listact = new ArrayList<Actividad>();
		monitores = new ArrayList<Monitor>();
	}
	
	/**
     * Método para obtener el id del campamento
     * 
     * @return devuelve el id del campamento.
     */
	public int getId() {
		return id;
	}
	
	/**
     * Método para asignar un id al campamento.
     * 
     * @param id i que se quiere asignar al campamento.
     * 
     */
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public NivelEducativo getTipo() {
		return tipo;
	}

	public void setTipo(NivelEducativo tipo) {
		this.tipo = tipo;
	}

	public int getMaxasistentes() {
		return maxasistentes;
	}

	public void setMaxasistentes(int maxasistentes) {
		this.maxasistentes = maxasistentes;
	}

	public List<Actividad> getListact() {
		return listact;
	}

	public void setListact(List<Actividad> listact) {
		this.listact = listact;
	}

	public List<Monitor> getMonitores() {
		return monitores;
	}

	public void setMonitores(List<Monitor> monitores) {
		this.monitores = monitores;
	}
	
	/**
     * Método para pasar a formato texto los datos del campamento.
     * 
     * @return devuelve la cadena con todos los atributos del campamento.
     * 
     */
	public String toString() {
		String pistaInfo = "Id campamento: " + this.id 
				+ "\n Hora de inicio: " + this.inicio
				+ "\n Hora de fin: " + this.fin
				+ "\n Nivel educativo: " + this.tipo
				+ "\n Numero de asistentes maximo: " + this.maxasistentes; 
		return pistaInfo;
	}
	
	
	
	/**
     * Método asociar un kart a una pista.
     * 
     * @param nuevoKart kart que se quiere asociar a la pista.
     * 
     */
	public boolean asociarActividad(Actividad nueva) {
		boolean sepuede = false;
		if(nueva.getTipo() == this.getTipo()) {
			listact.add(nueva);
			sepuede=true;
		}else {
			System.out.println("\nLa actividad no es del mismo nivel educativo que el campamento");
		}
		
		return sepuede;
	}
	
	public boolean asociarMonitor(Actividad nueva, Monitor moni) {
		boolean sepuede = false;
		boolean actexiste= false;
		int cont=0;
		boolean moniexiste = false;
		//verificar actividad existe
		for(int i=0;i<listact.size();i++) {
			if(nueva == listact.get(i)) {
				actexiste = true;
				cont=i;
			}
		}
		//verificar monitor existe
		for(int i=0;i<monitores.size();i++) {
			if(moni == monitores.get(i)) {
				moniexiste = true;
			}
		}
		if(actexiste && moniexiste) {
			listact.get(cont).asociarMonitor(moni);
			sepuede=true;
		}else {
			System.out.println("\n La actividad o el monitor no existen dentro del campamento");
		}
		
		
		return sepuede;
	}
	
	public boolean asociarMonitorEspecial(Actividad nueva, Monitor moni) {
		boolean sepuede = false;
		boolean actexiste= false;
		boolean moniactivo= false;
		boolean especial= false;
		int cont=0;
		boolean moniexiste = false;
		//verificar monitor existe
		for(int i=0;i<monitores.size();i++) {
			if(moni == monitores.get(i)) {
				moniexiste = true;
			}
		}
		
		//verificar monitor especial
		if(moni.getEducador()){
			especial = true;
		}
		
		//verificar actividad existe
		for(int i=0;i<listact.size();i++) {
			if(nueva == listact.get(i)) {
				actexiste = true;
				cont=i;
			}
			if(listact.get(i).getMonitores().size() > 0) {
				for(int j=0;j<listact.get(i).getMonitores().size();j++) {
					if(listact.get(i).getMonitores().get(j) == moni) {
						moniactivo = true;
					}
				}
			}
		}
		
		//verificar monitor no esta en ninguna actividad
		if(especial) {
		if(actexiste && moniexiste) {
			if(!moniactivo) {
				listact.get(cont).añadirMonitor(moni);
				sepuede=true;
			}else {
				System.out.println("\n El monitor esta asignado en otra actividad");
			}
			
		}else {
			System.out.println("\n La actividad o el monitor no existen dentro del campamento");
		}
		}else {
			System.out.println("\n El monitor no es especial");
		}
		
		return sepuede;
	}
	
	/**
     * Método verificar que un asistente es mayor de edad.
     * 
     * @param usu asistente que realiza la operación en la pista.
     * @return devuelve un booleano verificando que el usuario es mayor de edad
     */
	/*
	public boolean verificarmayoredad(Asistente usu, GestorAsistentes u) {
		if(u.calcularedad(usu) > 18) {
			return true;
		}
		else {
			return false;
		}
	}
	*/
}