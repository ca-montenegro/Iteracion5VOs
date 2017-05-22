//Requerimiento 15

package vos;


import org.codehaus.jackson.annotate.JsonProperty;

public class Boleta {
	
	/**
	 * Identificacion de la boleta
	 */
	@JsonProperty(value="id")
	private Long id;
	
	@JsonProperty(value="idFuncion")
	private Long idFuncion;
	
	@JsonProperty(value="idSilla")
	private Long idSilla;
	
	@JsonProperty(value="idCliente")
	private Long idCliente;
	
	/**
	 * Silla de la boleta
	 */
	private Funcion funcion;
	
	/**
	 * Silla que es asignada la boleta
	 */
	private Silla silla;
	
	/**
	 * Cliente que compra la boleta
	 */
	private Cliente cliente;
	
	/**
	 * Localidad a la cual pertenece la boleta
	 */
	private Localidad localidad;
	
	@JsonProperty(value="idAbonamiento")
	private Long idAbonamiento;
	
	@JsonProperty(value="estado")
	private char estado;
	
	/**
	 * Precio al cual se vendio la boleta
	 */
	private int precio;
	
	private int cantidad;
	
	/**
	 * Metodo constructor de una boleta 
	 * @param id identificacion de la boleta  id != null
	 * @param funcion funcion para la cual esta destinada la boleta funcion != null
	 * @param silla silla asignada a la boleta  silla != null
	 * @param cliente cliente que compra la boleta
	 */
	public Boleta(@JsonProperty(value="id") Long id, @JsonProperty(value="idFuncion")Long idFuncion, 
			@JsonProperty(value="idSilla")Long idSilla,@JsonProperty(value="cantidad") int cantidad,
			@JsonProperty(value="estado") char estado)
	{
		//this.id = id;
		this.idFuncion = idFuncion;
		this.idSilla = idSilla;
		this.cantidad = cantidad;
		this.estado = estado;
		//this.idCliente = idCliente;
	}

	
	
	/**
	 * Metodo getter del atributo id
	 * @return identificacion de la boleta
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Metodo setter del atributo id
	 *  <b>post: </b> La identificacion de la boleta ha sido cambiado con el valor que entra como parametro
	 * @param id - Identificacion de la boleta
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Metodo getter del atributo funcion
	 * @return Funcion para la cual esta la boleta
	 */
	public Funcion getFuncion() {
		return funcion;
	}

	/**
	 * Metodo setter del atributo funcion
	 *  <b>post: </b> La funcion para la cual es la boleta ha sido cambiado con el valor que entra como parametro
	 * @param funcion - Funcion para la cual es la boleta
	 */
	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}

	/**
	 * Metodo getter del atributo silla
	 * @return Silla que fue asignada a la boleta
	 */
	public Silla getSilla() {
		return silla;
	}

	/**
	 * Metodo setter del atributo silla
	 *  <b>post: </b> La silla adignada ha sido cambiado con el valor que entra como parametro
	 * @param silla - Silla asignada a la boleta.
	 */
	public void setSilla(Silla silla) {
		this.silla = silla;
	}

	/**
	 * Metodo getter del atributo cliente
	 * @return Cliente que compro la boleta
	 */
	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * Metodo getter del atributo localidad
	 * @return localidad a la cual pertenece la boleta
	 */
	public Localidad getLocalidad() {
		return localidad;
	}

	/**
	 * Metodo setter del atributo localidad 
	 *  <b>post: </b> La localidad de la boleta ha sido cambiado con el valor que entra como parametro
	 * @param localidad - Localidad de la boleta.
	 */
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	/**
	 * Metodo getter del atributo precio
	 * @return precio al cual se vendio la boleta
	 */
	public int getPrecio() {
		return precio;
	}

	/**
	 * Metodo setter del atributo precio
	 *  <b>post: </b> El precio al cual se vendio la boleta ha sido cambiado con el valor que entra como parametro
	 * @param precio - Precio al cual se vendio la boleta
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Long getIdFuncion() {
		return idFuncion;
	}

	public void setIdFuncion(Long idFuncion) {
		this.idFuncion = idFuncion;
	}

	public Long getIdSilla() {
		return idSilla;
	}

	public void setIdSilla(Long idSilla) {
		this.idSilla = idSilla;
	}



	public int getCantidad() {
		return cantidad;
	}



	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}



	public Long getIdAbonamiento() {
		return idAbonamiento;
	}



	public void setIdAbonamiento(Long idAbonamiento) {
		this.idAbonamiento = idAbonamiento;
	}



	public char getEstado() {
		return estado;
	}



	public void setEstado(char estado) {
		this.estado = estado;
	}
	
	
	public String toString()
	{
		return "-----Boleta con id: " + id + "-----\n"
				+ "idCliente: " + idCliente+" \n"
				+"idFuncion: " + idFuncion + "\n"
				+"idSilla: " + idSilla + "\n"
				+"Localidad: " +localidad.getNombre() +"\n"
				+"Estado: " + estado +"\n"
				+"Precio: " + precio + ".\n"
				+"Abonamiento número: " + idAbonamiento + "\n";
	}
	
	

}
