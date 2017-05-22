package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaRequerimientos {
	
	@JsonProperty(value="requerimientos")
	private List<Requerimiento> requerimientos;

	public ListaRequerimientos(	@JsonProperty(value="requerimientos")List<Requerimiento> requerimientos) {
		super();
		this.requerimientos = requerimientos;
	}

	public List<Requerimiento> getRequerimientos() {
		return requerimientos;
	}

	public void setRequerimientos(List<Requerimiento> requerimientos) {
		this.requerimientos = requerimientos;
	}
}
