package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Rentabilidad {

	@JsonProperty(value="fechaInicial")
	private String fechaInicial;

	@JsonProperty(value="fechaFinal")
	private String fechaFinal;

	@JsonProperty(value="idEspectaculo")
	private Long idEspectaculo;

	@JsonProperty(value="totalClientes")
	private int totalClientes;

	@JsonProperty(value="totalBoletas")
	private int totalBoletas;

	@JsonProperty(value="idSitio")
	private Long idSitio;

	@JsonProperty(value="tipo")
	private char tipo;

	@JsonProperty(value="proporcion")
	private double proporcion;

	@JsonProperty(value="precio")
	private int precio;

	@JsonProperty(value="nombreCategoria")
	private String nombreCategoria;
	
	@JsonProperty(value="fecha")
	private String fecha;

	public Rentabilidad(@JsonProperty(value="fechaInicial") String fechaInicial,
			@JsonProperty(value="fechaFinal") String fechaFinal)
	{
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
	}
	
	public Rentabilidad(String fechaInicial, String fechaFinal,
			Long idEspectaculo, int totalClientes, int totalBoletas, 
			Long idSitio, char tipo, double proporcion, 
			int precio, String nombreCategoria, String fecha)
	{
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
		this.idEspectaculo = idEspectaculo;
		this.totalClientes = totalClientes;
		this.totalBoletas = totalBoletas;
		this.idSitio = idSitio;
		this.tipo = tipo;
		this.proporcion = proporcion;
		this.precio = precio;
		this.nombreCategoria = nombreCategoria;
		this.fecha = fecha;
				
	}

	public String getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public String getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(String fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public Long getIdEspectaculo() {
		return idEspectaculo;
	}

	public void setIdEspectaculo(Long idEspectaculo) {
		this.idEspectaculo = idEspectaculo;
	}

	public int getTotalClientes() {
		return totalClientes;
	}

	public void setTotalClientes(int totalClientes) {
		this.totalClientes = totalClientes;
	}

	public int getTotalBoletas() {
		return totalBoletas;
	}

	public void setTotalBoletas(int totalBoletas) {
		this.totalBoletas = totalBoletas;
	}

	public Long getIdSitio() {
		return idSitio;
	}

	public void setIdSitio(Long idSitio) {
		this.idSitio = idSitio;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public double getProporcion() {
		return proporcion;
	}

	public void setProporcion(double proporcion) {
		this.proporcion = proporcion;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
}

