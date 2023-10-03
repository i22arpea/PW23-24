package business.asistente;


import java.text.SimpleDateFormat;
import java.util.Date;



/**

 * Esta clase define un asistente y los métodos para tratar con él.

 * @author: Adrián Arroyo Pérez

 * @version:

 */

public class Asistente {
	
	private int id;
	private String nombre;
	private Date fnacimiento;
	private boolean especial;
	
	

	/**
	 * 
     * Constructor por defecto de la clase asistente.
     * 
     */
	public Asistente() {
		nombre="";
		
	}
	
	/**
     * Constructor parametrizado de la clase asistente.
     * 
     * @param id_ id del monitor.
     * @param nombre_ nombre del monitor que vamos a inicializar.
     * @param fnacimiento_ fecha de nacimiento del asistente que vamos a inicializar.
     * @param especial_ para saber si el asistente necesita atención especial.
     * 
     */
	public Asistente(int id_,String nombre_,Date fnacimiento_,boolean especial_) {
		this.id = id_;
		this.nombre = nombre_;
		this.fnacimiento = fnacimiento_;
		this.especial = especial_;
	}
	
	
	/**
     * Método para obtener el id del asistente
     * 
     * @return devuelve el id del asistente
     * 
     */
	public int getId() {
		return id;
	}
	
	/**
     * Método para asignar un id al asistente.
     * 
     * @param id id que le queremos asignar al asistente.
     * 
     */
	public void setId(int id) {
		this.id = id;
	}

	/**
     * Método para obtener el si el asistente requiere atención especial
     * 
     * @return devuelve si el asistente requiere atención especial
     * 
     */
	public boolean getEspecial() {
		return especial;
	}

	/**
     * Método para asignar si el asistente requiere atención especial o no
     * 
     * @param epecial booleano para saber si el asistente requiere atención especial
     * 
     */
	public void setEspecial(boolean especial) {
		this.especial = especial;
	}

	/**
     * Método para obtener el nombre del asistente.
     * 
     * @return devuelve el nombre del asistente.
     * 
     */
	public String getNombre() {
		return nombre;
	}
	
	/**
     * Método para asignar un nombre al asistente.
     * 
     * @param nombre nombre que le queremos asignar al asistente.
     * 
     */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
     * Método para obtener la fecha de nacimiento del asistente en formato texto.
     * 
     * @return devuelve la fecha de nacimiento del asistente.
     * 
     */
	public String getFnacimientoString() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String fechaComoCadena = sdf.format(this.fnacimiento);
		
		
		return fechaComoCadena;
	}
	
	/**
     * Método para obtener la fecha de nacimiento del asistente.
     * 
     * @return devuelve la fecha de nacimiento del asistente.
     * 
     */
	public Date getFnacimientoDate() {
		return fnacimiento;
	}
	
	/**
     * Método para asignar la fecha de nacimiento a un asistente.
     * 
     * @param fnacimiento fecha de nacimiento que le queremos asignar al asistente.
     * 
     */
	public void setFnacimiento(Date fnacimento) {
		this.fnacimiento = fnacimento;
	}
	
	/**
     * Método para pasar a texto el asistente
     * 
     * @return devuelve la cadena con todos los atributos del asistente
     * 
     */
	public String toString() {
			String asistenteInfo = "Id asistente: " + this.id
					+ "\n Nombre y apellidos: " + this.nombre 
					+ "\n Fecha de nacimiento: " + this.fnacimiento;
			return asistenteInfo;
	}
		
	
	
	
}
	
	

