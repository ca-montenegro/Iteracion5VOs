package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Resultado {

	@JsonProperty(value="respuesta")
	private String respuesta;

	public Resultado (@JsonProperty(value="respuesta") String respuesta)
	{
		this.respuesta = respuesta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	
}
