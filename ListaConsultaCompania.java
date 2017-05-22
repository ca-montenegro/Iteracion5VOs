package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaConsultaCompania 
{
	@JsonProperty(value="listaCompanias")
	private List<ConsultaCompania> listaCompanias;

	public ListaConsultaCompania(@JsonProperty(value="listaCompanias") List<ConsultaCompania> listaCompanias) {
		super();
		this.listaCompanias = listaCompanias;
	}

	public List<ConsultaCompania> getListaCompanias() {
		return listaCompanias;
	}

	public void setListaCompanias(List<ConsultaCompania> listaCompanias) {
		this.listaCompanias = listaCompanias;
	}
	
	
}
