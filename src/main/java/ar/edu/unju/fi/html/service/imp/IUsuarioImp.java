package ar.edu.unju.fi.html.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.html.model.Candidato;
import ar.edu.unju.fi.html.model.Usuario;
import ar.edu.unju.fi.html.servicee.IUsuarioService;
import ar.edu.unju.fi.html.util.listaUsuarios;

@Service("UsuarioServiceImp")
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
		int eliminar = 0;
		for(Usuario cand : listausuarios.getListaUsuarios()) {
			if(cand.getDni() == dni) {
				eliminar = listausuarios.getListaUsuarios().indexOf(cand);
			}
		}
		listausuarios.getListaUsuarios().remove(eliminar);

	}

	@Override
	public listaUsuarios getListaUsuarios() {
		// TODO Auto-generated method stub
		return listausuarios;
	}

	@Override
	public Usuario buscarUsuario(int dni) {
		Optional<Usuario> usuarioo = listausuarios.getListaUsuarios().stream().filter(a -> a.getDni() == dni).findFirst();
		return usuarioo.get();
	}

	@Override
	public void realizarVotoUsuario(Usuario usuario) {
	
		for (Usuario usu : listausuarios.getListaUsuarios()) {
			if (usu.getDni() == usuario.getDni()) {
				
				usu.setVotos(usuario.getVotos()+1);
			}
		}

	}

	@Override
	public boolean existeUsuario(Usuario usuario) {
		for(Usuario cand : listausuarios.getListaUsuarios()) {
			if(cand.getDni()==usuario.getDni())
				return true;
		}
		return false;
	}
}


