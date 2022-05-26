package ar.edu.unju.fi.html.service.imp;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.fi.html.model.Usuario;
import ar.edu.unju.fi.html.servicee.IUsuarioService;
import ar.edu.unju.fi.html.util.listaUsuarios;

public class IUsuarioImp implements IUsuarioService {

	@Autowired
	private listaUsuarios listausuarios;
	
	
	@Override
	public Usuario getUsuario() {
		// TODO Auto-generated method stub
		return new Usuario();
	}

	@Override
	public boolean guardarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return listausuarios.getListaUsuarios().add(usuario);
	}

	@Override
	public void modificarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		for(Usuario usu : listausuarios.getListaUsuarios()) {
			if(usu.getDni()== usuario.getDni()) {	
				usu.setNombre(usuario.getNombre());
				usu.setEmail(usuario.getEmail());
				usu.setFechaDenacimiento(usuario.getFechaDenacimiento());
			}
		}

	}

	@Override
	public void eliminarUsuario(int dni) {
		// TODO Auto-generated method stub

	}

	@Override
	public listaUsuarios getListaUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario buscarUsuario(int dni) {
		// TODO Auto-generated method stub
		return null;
	}

}
