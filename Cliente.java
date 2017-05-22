package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Cliente extends Usuario
{

	@JsonProperty(value="contrasena")
	private String contrasena;
	
	@JsonProperty(value="festival")
	private Festival festival;
	
	public Cliente(	@JsonProperty(value="id")int id, @JsonProperty(value="nombre")String nombre,@JsonProperty(value="mail") String mail,@JsonProperty(value="rol") String rol, @JsonProperty(value="contrasena")String contrasena, @JsonProperty(value="festival") Festival festival) {
		super(id, nombre, mail, rol);
		this.contrasena = contrasena;
		this.festival = festival;		
		// TODO Auto-generated constructor stub
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Festival getFestival() {
		return festival;
	}

	public void setFestival(Festival festival) {
		this.festival = festival;
	}
	
	

}
