package ar.edu.unju.fi.html.util;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.html.model.Usuario;

@Component
public class listaUsuarios {

	
	public ArrayList<Usuario> listaUsuarios ;
	
	public listaUsuarios(){
		listaUsuarios = new ArrayList<Usuario>();
		
		Usuario unUsuario1 = new Usuario("Facu", "Facu@gmail.com", 39230981, LocalDate.of(1996, 6, 4));
		Usuario unUsuario2 = new Usuario("Ro", "Ro@gmail.com", 37891504, LocalDate.of(1993, 8, 2));
		Usuario unUsuario3 = new Usuario("Sol", "Sol@gmail.com", 38509677, LocalDate.of(1995, 10, 7));
		listaUsuarios.add(unUsuario1);
		listaUsuarios.add(unUsuario2);
		listaUsuarios.add(unUsuario3);
	}

	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	
}
