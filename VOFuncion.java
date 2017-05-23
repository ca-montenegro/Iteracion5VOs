
package vos;

import java.sql.Timestamp;
import java.util.List;

import org.codehaus.jackson.annotate.*;

import oracle.sql.TIMESTAMP;

/**
 * Clase que representa un Video
 * @author Juan
 */
public class VOFuncion {

	//// Atributos

	/**
	 * Id 
	 */
	@JsonProperty(value="id")
	private Long id;

	/**
	 * fecha
	 */
	@JsonProperty(value="fecha")
	private String fecha;

	/**
	 * espectaculo
	 */
	@JsonProperty(value="espectaculo")
	private String nombreEspectaculo;


	/**
	 * sitio
	 */
	@JsonProperty(value="sitio")
	private String nombreSitio;


	

	public VOFuncion(@JsonProperty(value="id")Long id,@JsonProperty(value="fecha")String fecha,
                 @JsonProperty(value="espectaculo")String espectaculo, @JsonProperty(value="sitio")
	String sitio ) {
		super();
		this.id=id;
		this.fecha=(fecha);
		nombreSitio=sitio;
		nombreEspectaculo=especatulo;
	}

	public VOFuncion() {
		//  Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNombreEspectaculo() {
		return nombreEspectaculo;
	}

	public void setNombreEspectaculo(String nombreEspectaculo) {
		this.nombreEspectaculo = nombreEspectaculo;
	}

	public String getNombreSitio() {
		return nombreSitio;
	}

	public void setNombreSitio(String nombreSitio) {
		this.nombreSitio = nombreSitio;
	}
	
	
}
