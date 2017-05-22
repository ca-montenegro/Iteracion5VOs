package vos;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonProperty;

public class Espectaculo {
	
	@JsonProperty(value="id")
	private int id;
	
	@JsonProperty(value="nombre")
	private String nombre;
	
	@JsonProperty(value="duracion")
	private double duracion;	

	@JsonProperty(value="intermedio")
	private int intermedio;
	
	@JsonProperty(value="idioma")
	private String idioma;
	
	@JsonProperty(value="clasificacion")
	private String clasificacion;	
	
	@JsonProperty(value="costoRealizacion")
	private double costoRealizacion;
	
	@JsonProperty(value="publicoActivo")
	private int publicoActivo;
	
	@JsonProperty(value="traduccionSubtitulos")
	private int traduccionSubtitulos;
	
	@JsonProperty(value="traduccionAudifonos")
	private int traduccionAudifonos;
	
	@JsonProperty(value="descripcion")
	private String descripcion;
	
	@JsonProperty(value="publicoObjetivo")
	private String publicoObjetivo;
	
	@JsonProperty(value="compañias")
	private ListaCompañias compañias;
	
	@JsonProperty(value="categorias")
	private ListaCategorias categorias;
	
	@JsonProperty(value="requerimientos")
	private ListaRequerimientos requerimientos;
	
	@JsonProperty(value="funciones")
	private ArrayList<Funcion> funciones;

	public Espectaculo(@JsonProperty(value="id")int id, @JsonProperty(value="nombre")String nombre, @JsonProperty(value="duracion")double duracion, @JsonProperty(value="intermedio")int intermedio, @JsonProperty(value="idioma")String idioma, @JsonProperty(value="clasificacion")String clasificacion,
			@JsonProperty(value="costoRealizacion")double costoRealizacion, @JsonProperty(value="publicoActivo")int publicoActivo, @JsonProperty(value="traduccionSubtitulos")int traduccionSubtitulos, @JsonProperty(value="traduccionAudifonos")int traduccionAudifonos,
			@JsonProperty(value="descripcion")String descripcion, @JsonProperty(value="publicoObjetivo")String publicoObjetivo, @JsonProperty(value="compañias")ListaCompañias compañias, @JsonProperty(value="categorias")ListaCategorias categorias, @JsonProperty(value="requerimientos")ListaRequerimientos requerimientos, @JsonProperty(value="funciones") ArrayList<Funcion> funciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.duracion = duracion;
		this.intermedio = intermedio;
		this.idioma = idioma;
		this.clasificacion = clasificacion;
		this.costoRealizacion = costoRealizacion;
		this.publicoActivo = publicoActivo;
		this.traduccionSubtitulos = traduccionSubtitulos;
		this.traduccionAudifonos = traduccionAudifonos;
		this.descripcion = descripcion;
		this.publicoObjetivo = publicoObjetivo;
		this.compañias = compañias;
		this.categorias = categorias;
		this.requerimientos = requerimientos;
		this.funciones = funciones;
	}

	public ListaRequerimientos getRequerimientos() {
		return requerimientos;
	}


	public void setRequerimientos(ListaRequerimientos requerimientos) {
		this.requerimientos = requerimientos;
	}

	public int getId() {
		return id;
	}

	public ListaCategorias getCategorias() {
		return categorias;
	}

	public void setCategorias(ListaCategorias categorias) {
		this.categorias = categorias;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public int isIntermedio() {
		return intermedio;
	}

	public void setIntermedio(int intermedio) {
		this.intermedio = intermedio;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public double getCostoRealizacion() {
		return costoRealizacion;
	}

	public void setCostoRealizacion(double costoRealizacion) {
		this.costoRealizacion = costoRealizacion;
	}

	public int isPublicoActivo() {
		return publicoActivo;
	}

	public void setPublicoActivo(int publicoActivo) {
		this.publicoActivo = publicoActivo;
	}

	public int isTraduccionSubtitulos() {
		return traduccionSubtitulos;
	}

	public void setTraduccionSubtitulos(int traduccionSubtitulos) {
		this.traduccionSubtitulos = traduccionSubtitulos;
	}

	public int isTraduccionAudifonos() {
		return traduccionAudifonos;
	}

	public void setTraduccionAudifonos(int traduccionAudifonos) {
		this.traduccionAudifonos = traduccionAudifonos;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPublicoObjetivo() {
		return publicoObjetivo;
	}

	public void setPublicoObjetivo(String publicoObjetivo) {
		this.publicoObjetivo = publicoObjetivo;
	}

	public ListaCompañias getCompañias() {
		return compañias;
	}

	public void setCompañias(ListaCompañias compañias) {
		this.compañias = compañias;
	}

	public ArrayList<Funcion> getFunciones() {
		return funciones;
	}

	public void setFunciones(ArrayList<Funcion> funciones) {
		this.funciones = funciones;
	}
	
	
}
