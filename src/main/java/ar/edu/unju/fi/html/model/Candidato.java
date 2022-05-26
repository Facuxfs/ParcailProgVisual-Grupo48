package ar.edu.unju.fi.html.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class Candidato {
	@Min(value=1000,message="El codigo debe ser mayor 1.000")
	private int codigo;
	@Size(min=3, max=20, message="El nombre debe tener entre 3 a 20 caracteres")
	@NotEmpty(message="El nombre del artista no puede ser vacio")
	private String nombre;
	@NotEmpty(message="El genero del artista no puede ser vacio")
	private String generoMusical;
	private String imagen;
	@NotEmpty(message="La descripcion del artista no puede ser vacio")
	private String descripcion;
	@Max(value = 0)
	private int cantidadDeVotos;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getGeneroMusical() {
		return generoMusical;
	}
	public void setGeneroMusical(String generoMusical) {
		this.generoMusical = generoMusical;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCantidadDeVotos() {
		return cantidadDeVotos;
	}
	public void setCantidadDeVotos(int cantidadDeVotos) {
		this.cantidadDeVotos = cantidadDeVotos;
	}
	

	@Override
	public String toString() {
		return "Candidato [codigo=" + codigo + ", nombre=" + nombre + ", generoMusical=" + generoMusical
				+ ", descripcion=" + descripcion + ", cantidadDeVotos=" + cantidadDeVotos + "]";
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Candidato(@Min(value = 1000, message = "El codigo debe ser mayor 1.000") int codigo,
			@Size(min = 3, max = 20, message = "El nombre debe tener entre 3 a 20 caracteres") @NotEmpty(message = "El nombre del artista no puede ser vacio") String nombre,
			@NotEmpty(message = "El genero del artista no puede ser vacio") String generoMusical, String imagen,
			String descripcion, @Max(0) int cantidadDeVotos) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.generoMusical = generoMusical;
		this.imagen = imagen;
		this.descripcion = descripcion;
		this.cantidadDeVotos = cantidadDeVotos;
	}
	public Candidato() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
