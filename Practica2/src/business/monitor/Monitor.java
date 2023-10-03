package business.monitor;





/**

 * Esta clase define un monitor y los métodos para tratar con él.

 * @author: Adrián Arroyo Pérez

 * @version: 

 */

public class Monitor {
	
	private int id;
	private String nombre;
	private boolean educador;
	
	

	/**
	 * 
     * Constructor por defecto de la clase monitor.
     * 
     */
	public Monitor() {
		
		
	}
	
	/**
     * Constructor parametrizado de la clase monitor.
     * 
     * @param id_ id del monitor.
     * @param nombre_ nombre del monitor que vamos a inicializar.
     * @param educador_ para saber si el monitor es un educador especial.
     * 
     */
	public Monitor(int id_,String nombre_,boolean educador_) {
		this.id = id_;
		this.nombre = nombre_;
		this.educador = educador_;
	}
	
	
	/**
     * Método para obtener el id del monitor
     * 
     * @return devuelve el id del monitor
     * 
     */
	public int getId() {
		return id;
	}
	
	/**
     * Método para asignar un id al monitor.
     * 
     * @param id id que le queremos asignar al monitor.
     * 
     */
	public void setId(int id) {
		this.id = id;
	}

	/**
     * Método para obtener el si el monitor es educador especial
     * 
     * @return devuelve si el monitor es educador especial
     * 
     */
	public boolean getEducador() {
		return educador;
	}

	/**
     * Método para asignar si el monitor es atención especial o no
     * 
     * @param educador booleano para saber si el monitor es educador especial
     * 
     */
	public void setEducador(boolean educador) {
		this.educador = educador;
	}

	/**
     * Método para obtener el nombre del monitor.
     * 
     * @return devuelve el nombre del monitor.
     * 
     */
	public String getNombre() {
		return nombre;
	}
	
	/**
     * Método para asignar un nombre al monitor.
     * 
     * @param nombre nombre que le queremos asignar al monitor.
     * 
     */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
     * Método para pasar a texto el monitor
     * 
     * @return devuelve la cadena con todos los atributos del monitor
     * 
     */
	public String toString() {
			String monitorInfo = "Id monitor: " + this.id
					+ "\n Nombre y apellidos: " + this.nombre;
			return monitorInfo;
	}
		
	
	
	
}
	
	

