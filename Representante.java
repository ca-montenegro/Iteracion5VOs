package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Representante extends Usuario
{

	@JsonProperty(value="paginaWeb")
	private String paginaWeb;

	@JsonProperty(value="pais")
	private String pais;
	
	public Representante(@JsonProperty(value="id")int id, @JsonProperty(value="nombre")String nombre,@JsonProperty(value="mail") String mail,@JsonProperty(value="rol") String rol, @JsonProperty(value="paginaWeb")String paginaWeb, @JsonProperty(value="pais")String pais ) 
	{
		super(id, nombre, mail, rol);
		this.paginaWeb = paginaWeb;
		this.pais = pais;
		// TODO Auto-generated constructor stub
	}

	public String getPaginaWeb() {
		return paginaWeb;
	}

	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	

}
