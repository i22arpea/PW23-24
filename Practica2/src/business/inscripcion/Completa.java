package business.inscripcion;

import java.util.Date;

/**

 * Esta clase es una clase abstracta que define el contenido de una inscripcion completa y los métodos para tratar con ella.
 * 
 * @author: Adrián Arroyo Pérez

 * @version: 

 */




public class Completa extends Inscripcion {
	
	
	/**

     * Constructor por defecto de completa.
     * 
     */
	public Completa() {
		super();
		// TODO Auto-generated constructor stub
		
	}
	
	public Completa(int idCampamento, int idAsistente, Date fecha, float precio, String tipo){
		super(idCampamento, idAsistente, fecha, precio, "completa");
		// TODO Auto-generated constructor stub
		
	}
	
	
	
	/**
	 * Obtiene informacion de la inscripcion completa.
	 * 
	 * @return infoReserva Cadena de texto con la informacion de la inscripcion completa.
	 */
	public String toString() {
		String infoReserva = super.toString();
		return infoReserva;
	}
	
}