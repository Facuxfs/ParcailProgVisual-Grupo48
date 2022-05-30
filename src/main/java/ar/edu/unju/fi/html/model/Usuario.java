package ar.edu.unju.fi.html.model;

import java.time.LocalDate;


import java.time.temporal.ChronoUnit;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;


@Component
public class Usuario {

	@Size(min=3, max=20, message="El nombre debe tener entre 3 a 20 caracteres")
	@NotEmpty(message="El nombre no puede ser vacio")
	private String nombre;
	@NotEmpty
	@Email
	private String email;
	@Min(value=1000,message="El codigo debe ser mayor 1.000.000")
	private int dni;
	@Max(value=0)
	private int votos;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaDenacimiento;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFechaDenacimiento() {
		return fechaDenacimiento;
	}

	public void setFechaDenacimiento(LocalDate fechaDenacimiento) {
		this.fechaDenacimiento = fechaDenacimiento;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}
	
	public long calcularEdad() {
		LocalDate fechaNac = fechaDenacimiento;
		LocalDate ahora = LocalDate.now();
		long edad = ChronoUnit.YEARS.between(fechaNac, ahora);
		return edad;
	}

	public Usuario(String nombre, String email, int dni, LocalDate fechaDenacimiento) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.dni = dni;
		this.fechaDenacimiento = fechaDenacimiento;
	}

	
	
	public Usuario(String nombre, String email, int dni, int votos, LocalDate fechaDenacimiento) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.dni = dni;
		this.votos = votos;
		this.fechaDenacimiento = fechaDenacimiento;
	}

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", email=" + email + ", dni=" + dni + ", fechaDenacimiento="
				+ fechaDenacimiento + "]";
	}

	public int getVotos() {
		return votos;
	}

	public void setVotos(int votos) {
		this.votos = votos;
	}

	

}
