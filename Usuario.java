package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Usuario 
{
////Atributos


	@JsonProperty(value="id")
	private int id;


	@JsonProperty(value="nombre")
	private String nombre;


	@JsonProperty(value="mail")
	private String mail;
	
	/**
	 * Rol
	 */
	@JsonProperty(value="rol")
	private String rol;


	public Usuario(@JsonProperty(value="id")int id, @JsonProperty(value="nombre")String nombre,@JsonProperty(value="mail") String mail,@JsonProperty(value="rol") String rol ) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.mail = mail;
		this.rol = rol;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	
}
