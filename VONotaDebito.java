//Requerimiento Funcional 16.

package vos;

import java.util.Date;

public class NotaDebito {

	private Long idDevolucion;
	
	private Long idBoleta;
	
	private Date dateDevolucion;
	
	private Date dateFuncion;
	
	private Long idCliente;
	
	private Long idFuncion;
	
	private Funcion funcion;

	public NotaDebito(Long idDevolucion, Long idBoleta, Date dateDevolucion, Date dateFuncion, Long idCliente,
			Long idFuncion, Funcion funcion) {
		
		this.idDevolucion = idDevolucion;
		this.idBoleta = idBoleta;
		this.dateDevolucion = dateDevolucion;
		this.dateFuncion = dateFuncion;
		this.idCliente = idCliente;
		this.idFuncion = idFuncion;
		this.funcion = funcion;
	}

	public Long getIdDevolucion() {
		return idDevolucion;
	}

	public void setIdDevolucion(Long idDevolucion) {
		this.idDevolucion = idDevolucion;
	}

	public Long getIdBoleta() {
		return idBoleta;
	}

	public void setIdBoleta(Long idBoleta) {
		this.idBoleta = idBoleta;
	}

	public Date getDateDevolucion() {
		return dateDevolucion;
	}

	public void setDateDevolucion(Date dateDevolucion) {
		this.dateDevolucion = dateDevolucion;
	}

	public Date getDateFuncion() {
		return dateFuncion;
	}

	public void setDateFuncion(Date dateFuncion) {
		this.dateFuncion = dateFuncion;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Long getIdFuncion() {
		return idFuncion;
	}

	public void setIdFuncion(Long idFuncion) {
		this.idFuncion = idFuncion;
	}

	public Funcion getFuncion() {
		return funcion;
	}

	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}
	
	public String toString()
	{
		String retu = "-------------------------------\n"
				+ "Nota de debito número: " + idDevolucion + "\n"
				+ "para el usuario identificado con el número: " + idCliente + ".\n"
				+"\n"
				+"Fecha solicitud: " + dateDevolucion.toString()+ " :\n"
				+"Comprobante que solicita la devolución del dinero de la boleta: "+ idBoleta+"\n"
				+ "para la función: " + idFuncion + " del espectaculo: "+ funcion.getEspectaculo().getNombre() +"\n"
				+"a realizarse en la fecha: " + funcion.getFecha() + ".\n"
				+  "-------------------------------\n";
		return retu;
	}
	
	
}
