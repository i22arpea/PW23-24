package business.inscripcion;





/**

 * Esta clase es una clase abstracta que define el contenido de una inscripcion parcial y los métodos para tratar con ella.
 * 
 * @author: Adrián Arroyo Pérez

 * @version: 

 */

import java.util.Date;


public class Parcial extends Inscripcion {
	
	
	
	/**

     * Constructor por defecto de parcial
     * 
     */
	public Parcial() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Parcial(int idCampamento, int idAsistente, Date fecha, float precio, String tipo){
		super(idCampamento, idAsistente, fecha, precio, "parcial");
		// TODO Auto-generated constructor stub
		
	}
	
	
	
	/**
	 * Obtiene informacion de la inscripcion parcial.
	 * 
	 * @return infoReserva Cadena de texto con la informacion de la inscripcion parcial.
	 */
	public String toString() {
		String infoReserva = super.toString();
		System.out.println(infoReserva);
		return infoReserva;
	}
	
}
