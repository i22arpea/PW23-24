package business.actividad;

import java.util.ArrayList;
import java.util.List;

import business.monitor.Monitor;

/*

 * Esta clase define de que está compuesto un kart y los métodos asociados a este
 * 
 * @author: Adrián Arroyo Pérez

 * @version: 

 */


public class Actividad {
	
	private String nombre;
	private NivelEducativo tipo; 
	private String horario;
	private int nummonitores;
	private List<Monitor> monitores;
	
	
	 /**

     * Constructor por defecto de actividads

     */
	public Actividad() {
		
	}
	
	 /**

     * Constructor parametrizado de una actividad

     * @param nombre_ define el nombre de la actividad
     * @param tipo_ define el nivel educativo de la actividad
     * @param horario_ define el horario de una actividad que puede ser mañana o tarde
     * @param nummonitores_ define el número de monitores que necesita la actividad

     */
	public Actividad(String nombre_, NivelEducativo tipo_, String horario_, int nummonitores_) {
		
		this.nombre = nombre_;
		this.tipo = tipo_;
		this.horario = horario_;
		this.nummonitores = nummonitores_;
		this.monitores = new ArrayList<Monitor>();
		
	}
	/**

     * Método para obtener el nombre

     * @return devuelve el nombre de la actividad

     */
	public String getNombre() {
		return nombre;
	}
	
	/**

     * Método para cambiar el nombre

     * @param nombre es el nombre de la actividad

     */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**

     * Método para obtener el tipo

     * @return devuelve el tipo de actividad

     */
	public NivelEducativo getTipo() {
		return tipo;
	}

	/**

     * Método para cambiar el tipo

     * @param tipo es el tipo de actividad

     */
	public void setTipo(NivelEducativo tipo) {
		this.tipo = tipo;
	}
	
	/**

     * Método para obtener el horario

     * @return devuelve el horario de la actividad

     */
	public String getHorario() {
		return horario;
	}
	/**

     * Método para cambiar el horario

     * @param horario es el horario de la actividad

     */
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	/**

     * Método para obtener el numero de monitores

     * @return devuelve el numero de monitores

     */
	public int getNummonitores() {
		return nummonitores;
	}
	
	/**

     * Método para cambiar el numero de monitores

     * @param nummonitores es el numero de monitores nuevo

     */
	public void setNummonitores(int nummonitores) {
		this.nummonitores = nummonitores;
	}
	
	/**

     * Método para obtener el array de monitores

     * @return devuelve el array de monitores

     */
	public List<Monitor> getMonitores() {
		return monitores;
	}
	
	/**

     * Método para cambiar el array de monitores

     * @param monitores es el array de monitores nuevo

     */	
	public void setMonitores(List<Monitor> monitores) {
		this.monitores = monitores;
	}
	
	public void añadirMonitor(Monitor moni) {
		this.monitores.add(moni);
	}

	public boolean asociarMonitor(Monitor moni) {
		boolean sepuede = false;
		boolean max= false;
		
		boolean moniexiste = false;
		//verificar monitor existe
		for(int i=0;i<monitores.size();i++) {
			if(moni == monitores.get(i)) {
				moniexiste = true;
			}
		}
		//verificar monitores no completos
		if(nummonitores == monitores.size()) {
			max = true;
		}
		
		if(!max && !moniexiste) {
			this.monitores.add(moni);
			sepuede=true;
		}else {
			System.out.println("\n El monitor ya existe o ya estan todos los monitores asignados");
		}
		
		
		return sepuede;
	}
	 /**

     * Método para pasar a texto la actividad

     * @return devuelve la cadena con todos los atributos de la actividad

     */
	public String toString() {
		String kartInfo = "Nombre actividad: " + this.nombre
				+ "\n Tipo: " + this.tipo 
				+ "\n Horario: " + this.horario
				+ "\n Numero de Monitores: " + this.nummonitores;
		for(int i = 0; i < monitores.size(); i++) {
			kartInfo = kartInfo + "\n Monitor nº" +i+": " + this.monitores.get(i);
		}
			kartInfo = kartInfo + "\n";
				
		return kartInfo;
	}
}