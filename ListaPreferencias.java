package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaPreferencias {

	@JsonProperty(value="preferencias")
	private List<Preferencia> preferencias;	
	
	public ListaPreferencias(@JsonProperty(value="preferencias")List<Preferencia> preferencias) {
		super();
		this.preferencias = preferencias;
	}

	public List<Preferencia> getPreferencias() {
		return preferencias;
	}

	public void setPreferencias(List<Preferencia> preferencias) {
		this.preferencias = preferencias;
	}
	
	
}
