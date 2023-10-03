package business.inscripcion;





import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**

 * Esta clase es una clase abstracta que define el contenido de una inscripcion y los métodos para tratar con ella.
 * 
 * @author: Adrián Arroyo Pérez

 * @version:

 */

public abstract class Inscripcion {
	
	//campamento
	protected int idCampamento;
	//asistente
	protected int idAsistente;
	//fecha inscripcion
	protected Date fecha;
	//precio
	protected float precio;
	//tipo
	protected String tipo;
	
	public Inscripcion() {
		
	}
	
	/**

     * Constructor parametrizado

     */
	public Inscripcion(int idCampamento, int idAsistente, Date fecha, float precio, String tipo) {
		super();
		this.idCampamento = idCampamento;
		this.idAsistente = idAsistente;
		this.fecha = fecha;
		this.precio = precio;
		this.tipo = tipo;
		
	}
	
	
	

	

	
	/**
     * Método para obtener la fecha de la inscripcion.
     *
     * @return devuelve la fecha de inscripcion
     */
	public Date getFechaDate() {
		return fecha;
	}
	
	/**
     * Método para obtener el usuario que realiza la inscripcion
     * 
     * @return devuelve el usuario que realiza la inscripcion
     */
	public int getIdAsistente() {
		return idAsistente;
	}
	
	/**
     * Método para cambiar el usuario que realiza la inscripcion
     * 
     * @param idAsistente es el usuario que realiza la inscripcion
     */
	public void setIdAsistente(int idAsistente) {
		
		this.idAsistente = idAsistente;
		
	}

	/**
     * Método para obtener la fecha de la inscripcion
     * 
     * @return devuelve la fecha de la inscripcion
     */
	public String getfecha() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String fechaComoCadena = sdf.format(this.fecha);
		
		
		return fechaComoCadena;
		
	}
	
	/**
     * Método para cambiar la fecha de la inscripcion
     * 
     * @param fecha es la fecha de la inscripcion
     */
	public void setfecha(Date fecha) {
		
		this.fecha = fecha;
		
	}
	
	/**
     * Método para obtener el precio de la inscripcion
     * 
     * @return devuelve el precio de la inscripcion
     */
	public double getprecio() {
		
		return precio;
		
	}
	
	/**
     * Método para cambiar el precio de la inscripcion.
     * 
     * @param precio es el precio nuevo de la inscripcion.
     */
	public void setprecio(float precio) {
		
		this.precio = precio;
		
	}
	
	/**
     * Método para obtener el id del campamento de la inscripcion
     * 
     * @return devuelve el id del campamento de la inscripcion
     */
	public int getidCampamento() {
		
		return idCampamento;
		
	}
	
	/**
     * Método para cambiar el id del campamento de la inscripcion
     * 
     * @param idCampamento id nuevo del campamento de la inscripcion
     */
	public void setidCampamento(int idCampamento) {
		
		this.idCampamento = idCampamento;
		
	}
	
	
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	//método tostring
	public String toString() {
				
		String inscripcionInfo = "Id del campamento: " + this.idCampamento
			+ "\n Id del asistente: " + this.idAsistente
			+ "\n Fecha de inscripcion: " + this.fecha 
			+ "\n Precio: " + this.precio;
			
		return inscripcionInfo;
					
	}
	
	
}