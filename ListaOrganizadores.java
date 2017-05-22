package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaOrganizadores 
{
	@JsonProperty(value="organizadores")
	private List<Organizador> organizadores;
	
	public ListaOrganizadores(@JsonProperty(value="organizadores") List<Organizador> organizadores) {
		super();
		this.organizadores = organizadores;
	}

	public List<Organizador> getOrganizadores() {
		return organizadores;
	}

	public void setOrganizadores(List<Organizador> organizadores) {
		this.organizadores = organizadores;
	}
	
	
}
