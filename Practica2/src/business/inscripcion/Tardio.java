package business.inscripcion;






import java.util.Calendar;

/**
 * Esta clase define un tipo de reserva que sería la reserva bono que heredsa los atributos de una reserva y añade nuevos atributos 
 * como especialización de la clase reserva.
 * @author: Adrián Arroyo Pérez
 * @author Javier Roldan Ortiz
 * @version: 08/10/2022
 */

import java.util.Date;

import business.asistente.GestorAsistentes;
import business.campamento.Campamento;
import business.asistente.Asistente;



public class Tardio extends CrearInscripcion{
	
	
	
	
	
	
	
	/**
     * Constructor por defecto de tardio
     */
	public Tardio() {
		super();
		
		
		// TODO Auto-generated constructor stub
	}
	
	
	/**
     * Método para crear los tipos de inscripcion
     * @param usuario usuario que realizará la inscripcion
     * @param fecha fecha en la que se realizará la inscripcion
     * @param campamento campamento en el que se realiza la inscripcion
     * @return devuelve una inscripcion del tipo asociado con los datos pasados por parámetros
     */
	
	@Override
	public Completa CrearInsCompleta(Asistente usuario,Date fecha, Campamento campamento) {
	
		Completa nueva = new Completa();
		//obtenemos la fecha actual que es cuando se realiza la inscripcion
		Date fechaactual = new Date();
		//comparamos la fecha dada con la fecha actual para ver si cumple con los 15 dias de antelacion
		
		Calendar calendar15 = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(fechaactual);
	    calendar2.add(Calendar.DAY_OF_YEAR, 2); // Suma 2 días
        calendar15.setTime(fechaactual);
        calendar15.add(Calendar.DAY_OF_YEAR, 15); // Suma 15 días
        
        Date Date15 = calendar15.getTime();
        Date Date2 = calendar2.getTime();
		
			if(fecha.before(Date15) && campamento.getInicio().before(Date2)) {
				System.out.println("\n La fecha de la inscripcion o el campamento no son válidas");
				
			}else {
				
					nueva.setIdAsistente(usuario.getId());;
					nueva.setidCampamento(campamento.getId());
					nueva.setTipo("parcial");
					nueva.setfecha(fecha);
				
			}
			
		
		
		return nueva;
	}
	
	@Override
	public Parcial CrearInsParcial(Asistente usuario,Date fecha, Campamento campamento) {
	
		Parcial nueva = new Parcial();
		//obtenemos la fecha actual que es cuando se realiza la inscripcion
		Date fechaactual = new Date();
		//comparamos la fecha dada con la fecha actual para ver si cumple con los 15 dias de antelacion
		
		Calendar calendar15 = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(fechaactual);
	    calendar2.add(Calendar.DAY_OF_YEAR, 2); // Suma 2 días
        calendar15.setTime(fechaactual);
        calendar15.add(Calendar.DAY_OF_YEAR, 15); // Suma 15 días
        
        Date Date15 = calendar15.getTime();
        Date Date2 = calendar2.getTime();
		
			if(fecha.before(Date15) && campamento.getInicio().before(Date2)) {
				System.out.println("\n La fecha de la inscripcion o el campamento no son válidas");
				
			}else {
				
					nueva.setIdAsistente(usuario.getId());;
					nueva.setidCampamento(campamento.getId());
					nueva.setTipo("parcial");
					nueva.setfecha(fecha);
				
			}
			
		
		
		return nueva;
	}
	
	

	
}