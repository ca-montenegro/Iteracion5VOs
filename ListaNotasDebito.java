package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaNotasDebito 
{
	@JsonProperty(value="notasDebito")
	private List<NotaDebitoJM> notasDebito;

	public ListaNotasDebito(@JsonProperty(value="notasDebito") List<NotaDebitoJM> notasDebito) 
	{
		super();
		this.notasDebito = notasDebito;
	}

	public List<NotaDebitoJM> getNotasDebito() {
		return notasDebito;
	}

	public void setNotasDebito(List<NotaDebitoJM> notasDebito) {
		this.notasDebito = notasDebito;
	}
	

}
