package ar.edu.unju.fi.html.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.html.model.Candidato;
import ar.edu.unju.fi.html.model.Usuario;
import ar.edu.unju.fi.html.servicee.ICandidatosService;
import ar.edu.unju.fi.html.servicee.IUsuarioService;
import ar.edu.unju.fi.html.util.listaCandidatos;
@Controller
@RequestMapping("/usuario")
public class UsuarioController {
		
		@Autowired
		@Qualifier("UsuarioServiceImp")
		private IUsuarioService usuarioservice;
		
		@Autowired
		@Qualifier("CandidatosServiceImp")
		private ICandidatosService candidatoservice;
		
		//private static final Log LOGGER = LogFactory.getLog(CandidatoController.class);
		
		
		@GetMapping("/listausuarios")
		public ModelAndView getListaCandidatosPage() {
			ModelAndView mav = new ModelAndView("listausuarios");
			mav.addObject("usuarios",usuarioservice.getListaUsuarios().getListaUsuarios());
			return mav;
		}

		@GetMapping("/nuevo")
		public String getFormNuevoCandidato(Model model) {	
			model.addAttribute("usuario", usuarioservice.getUsuario());
			return "nuevousuario";
		}
		
		@PostMapping("/guardar")
		public ModelAndView getListaUsuarioPage(@Validated @ModelAttribute("usuario")Usuario usuario,
				BindingResult bindingResult) {
			if(bindingResult.hasErrors()) {
				ModelAndView mav = new ModelAndView("nuevousuario");
				mav.addObject("candidato", usuarioservice.getUsuario());
				return mav;
			}
			
			if(usuarioservice.buscarUsuario(usuario.getDni()).getDni()==usuario.getDni()) {
				ModelAndView mav = new ModelAndView("usuarioexiste");
				return mav;
			}
			
			ModelAndView mav = new ModelAndView("redirect:/usuario/listausuarios");
			if(usuarioservice.guardarUsuario(usuario)) {
				//LOGGER.info("Se agregó un objeto al arrayList de alumnos");
			}
			return mav;
		}
		
		
		@GetMapping("/eliminar/{dni}")
		public ModelAndView getEliminarUsuarioPage(@PathVariable(value="dni")int dni) {
			ModelAndView mav = new ModelAndView("listausuarios");
			usuarioservice.eliminarUsuario(dni);
			return mav;
		}
		
		
		
		
		@GetMapping("/editar/{dni}")
		public ModelAndView getEditarUsuarioPage(@PathVariable(value="dni")int dni) {
			ModelAndView mav = new ModelAndView("editarusuario");
			Usuario usuario = usuarioservice.buscarUsuario(dni);
			mav.addObject("usuario", usuario);
			return mav;
		}
		
		@PostMapping("/modificar")
		public ModelAndView editarDatosUsuario(@Validated @ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult ) {
			if(bindingResult.hasErrors()) {
				//LOGGER.info("ocurrió un error "+alumno);
				ModelAndView mav = new ModelAndView("editarusuario");
				mav.addObject("usuario", usuario);
				return mav;
			}
			ModelAndView mav = new ModelAndView("redirect:/usuario/listausuarios");
			usuarioservice.modificarUsuario(usuario);
			return mav;
			
		}

		
		@GetMapping("/votar/{dni}")
		public ModelAndView getVotarUsuario(@PathVariable(value="dni")int dni) {
			ModelAndView mav = new ModelAndView("crearvoto");
			Usuario usuario = usuarioservice.buscarUsuario(dni);
			mav.addObject("candidatos",candidatoservice.getListaCandidatos().getListaCandidatos());
			mav.addObject(usuario);
			if (usuario.getVotos()==4) {
				ModelAndView mave = new ModelAndView("votonoregistrado");
				mav.addObject("usuario", usuario);
				return mave;
			}else {
				usuarioservice.realizarVotoUsuario(usuario);
			}
			return mav;
		}
		
	
		
	
}
