package business.inscripcion;





import java.util.Date;

import business.asistente.Asistente;
import business.campamento.Campamento;


/**
 * Esta clase es una clase abstacta que define 3 métodos abstractos que heredaran los tipos de inscripcions.
 * 
 * @author: Adrián Arroyo Pérez
 * 
 * @version: 
 */

public abstract class CrearInscripcion {
			
	/**
     * Método para crear los tipos de inscripcion
     * @param usuario usuario que realizará la inscripcion
     * @param fecha fecha en la que se realizará la inscripcion
     * @param campamento campamento en el que se realiza la inscripcion
     * @return devuelve una inscripcion del tipo asociado con los datos pasados por parámetros
     */
	public abstract Parcial CrearInsParcial(Asistente usuario,Date fecha, Campamento campamento);
	
	public abstract Completa CrearInsCompleta(Asistente usuario,Date fecha, Campamento campamento);
			
}