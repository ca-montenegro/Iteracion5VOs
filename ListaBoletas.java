package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaBoletas {

	@JsonProperty(value="boletas")
	private List<BoletaJM> boletas;

	public ListaBoletas(@JsonProperty(value="boletas")List<BoletaJM> boletas) {
		super();
		this.boletas = boletas;
	}

	public List<BoletaJM> getBoletas() {
		return boletas;
	}

	public void setBoletas(List<BoletaJM> boletas) {
		this.boletas = boletas;
	}
}
