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

import ar.edu.unju.fi.html.servicee.ICandidatosService;
import ar.edu.unju.fi.html.servicee.IUsuarioService;
import ar.edu.unju.fi.html.util.listaCandidatos;

@Controller
@RequestMapping("/candidato")
public class CandidatoController {
	
	@Autowired
	@Qualifier("CandidatosServiceImp")
	private ICandidatosService candidatoservice;
	
	//private static final Log LOGGER = LogFactory.getLog(CandidatoController.class);
	
	
	@GetMapping("/listaCandidatos")
	public ModelAndView getListaCandidatosPage() {
		ModelAndView mav = new ModelAndView("listacandidatos");
		mav.addObject("candidatos",candidatoservice.getListaCandidatos().getListaCandidatos());
		return mav;
	}

	@GetMapping("/nuevo")
	public String getFormNuevoCandidato(Model model) {	
		model.addAttribute("candidato",candidatoservice.getCandidato());
		return "nuevocandidato";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getListaCandidatoPage(@Validated @ModelAttribute("candidato")Candidato candidato,
			BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("nuevocandidato");
			mav.addObject("candidato", candidatoservice.getCandidato());
			return mav;
		}		
		
		else if(candidatoservice.existeCandidato(candidato)==true) {
			ModelAndView mav = new ModelAndView("usuarioexiste");
			return mav;
		}
		
		ModelAndView mav = new ModelAndView("artistaagregado");
		candidatoservice.guardarCandidato(candidato);
			//LOGGER.info("Se agregó un objeto al arrayList de alumnos");
		
		return mav;
	}
	
	@GetMapping("/editar/{codigo}")
	public ModelAndView getEditarCandidatoPage(@PathVariable(value="codigo")int codigo) {
		ModelAndView mav = new ModelAndView("editarcandidato");
		Candidato candidato = candidatoservice.buscarCandidato(codigo);
		mav.addObject("candidato", candidato);
		return mav;
	}
	
	@PostMapping("/modificar")
	public ModelAndView editarDatosCandidato(@Validated @ModelAttribute("candidato") Candidato candidato, BindingResult bindingResult ) {
		if(bindingResult.hasErrors()) {
			//LOGGER.info("ocurrió un error "+alumno);
			ModelAndView mav = new ModelAndView("editarcandidato");
			mav.addObject("candidato", candidato);
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/candidato/listaCandidatos");
		candidatoservice.modificarCandidato(candidato);
		return mav;
		
	}
	@GetMapping("/eliminar/{codigo}")
	public ModelAndView getEliminarCandidatoPage(@PathVariable(value="codigo")int codigo) {
		ModelAndView mav = new ModelAndView("listacandidatos");
		candidatoservice.eliminarCandidato(codigo);
		return mav;
	}
	
	@GetMapping("/votacion")
	public ModelAndView getListaVotacionPage() {
		ModelAndView mav = new ModelAndView("resultadovotacion");
		mav.addObject("candidatos",candidatoservice.getListaCandidatos().getListaCandidatos());
		return mav;
	}
	
	
	@GetMapping("/votar/{codigo}")
	public ModelAndView guardarVotoUsuario(@PathVariable(value="codigo")int codigo){
		ModelAndView mav = new ModelAndView("votonoregistrado");
		candidatoservice.contarVotoCandidato(candidatoservice.buscarCandidato(codigo));
		return mav;
	}
}
