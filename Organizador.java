package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Organizador extends Usuario
{
	@JsonProperty(value="festival")
	private Festival festival;

	public Organizador(@JsonProperty(value="id")int id, @JsonProperty(value="nombre")String nombre,@JsonProperty(value="mail") String mail,@JsonProperty(value="rol") String rol, @JsonProperty(value="festival") Festival festival) {
		super(id, nombre, mail, rol);
		this.festival = festival;
		// TODO Auto-generated constructor stub
	}

	public Festival getFestival() {
		return festival;
	}

	public void setFestival(Festival festival) {
		this.festival = festival;
	}
	
	

}
