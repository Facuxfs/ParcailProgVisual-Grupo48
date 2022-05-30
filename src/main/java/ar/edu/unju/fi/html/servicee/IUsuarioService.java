package ar.edu.unju.fi.html.servicee;

import ar.edu.unju.fi.html.model.Usuario;
import ar.edu.unju.fi.html.util.listaUsuarios;

public interface IUsuarioService {
	
	public Usuario getUsuario();
	public boolean guardarUsuario(Usuario usuario);
	public void modificarUsuario(Usuario usuario);
	public void eliminarUsuario(int dni);
	public listaUsuarios getListaUsuarios();
	public Usuario buscarUsuario(int dni);
	public void realizarVotoUsuario(Usuario usuario);

}
