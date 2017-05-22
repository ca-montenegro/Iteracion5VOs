package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaFestivales {

	@JsonProperty(value="festivales")
	private List<Festival> festivales;

	public ListaFestivales(@JsonProperty(value="festivales")List<Festival> festivales) {
		super();
		this.festivales = festivales;
	}

	public List<Festival> getFestivales() {
		return festivales;
	}

	public void setFestivales(List<Festival> festivales) {
		this.festivales = festivales;
	}



}
