package ar.edu.unju.fi.html.model;

import java.time.LocalDate;

import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Component;


@Component
public class Usuario {

	private String nombre;
	private String email;
	private int dni;
	private int votos;
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
		this.votos = 0;
	}

	

}
