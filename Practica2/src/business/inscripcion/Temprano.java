package business.inscripcion;





import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


import business.campamento.Campamento;
import business.asistente.Asistente;


/**
 * Esta clase hereda de la clase inscripcion y redefine los métodos de la clase padre.
 * 
 * @author: Adrián Arroyo Pérez
 * 
 * @version: 
 */

public class Temprano extends CrearInscripcion{
	Scanner entrada = new Scanner(System.in);
	
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
		
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaactual);
        calendar.add(Calendar.DAY_OF_YEAR, 15); // Suma 15 días
        
        Date newDate = calendar.getTime();
		
			if(fecha.before(newDate)) {
				System.out.println("\n Por favor introduzca una fecha posterior a "+newDate);
				
			}else {
				
					nueva.setIdAsistente(usuario.getId());;
					nueva.setidCampamento(campamento.getId());
					nueva.setTipo("parcial");
					nueva.setfecha(fecha);
				
			}
			
		
		
		return nueva;
	}
	
	@Override
	public Parcial CrearInsParcial(Asistente usuario,Date fecha,Campamento campamento) {
		
		Parcial nueva = new Parcial();
		//obtenemos la fecha actual que es cuando se realiza la inscripcion
		Date fechaactual = new Date();
		//comparamos la fecha dada con la fecha actual para ver si cumple con los 15 dias de antelacion
		
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaactual);
        calendar.add(Calendar.DAY_OF_YEAR, 15); // Suma 15 días
        
        Date newDate = calendar.getTime();
		
			if(fecha.before(newDate)) {
				System.out.println("\n Por favor introduzca una fecha posterior a "+newDate);
				
			}else {
				
					nueva.setIdAsistente(usuario.getId());;
					nueva.setidCampamento(campamento.getId());
					nueva.setTipo("parcial");
					nueva.setfecha(fecha);
				
			}
			
		
		
		return nueva;
	}
	
}