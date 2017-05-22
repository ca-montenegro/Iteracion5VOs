package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaCategorias {

	@JsonProperty(value="categorias")
	private List<Categoria> categorias;

	public ListaCategorias(@JsonProperty(value="categorias")List<Categoria> categorias) {
		super();
		this.categorias = categorias;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
}
