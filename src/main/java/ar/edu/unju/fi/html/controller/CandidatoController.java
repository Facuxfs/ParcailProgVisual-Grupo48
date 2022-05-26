package ar.edu.unju.fi.html.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.html.model.Candidato;
import ar.edu.unju.fi.html.servicee.ICandidatosService;

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
	public ModelAndView getListaAlumnosPage(@Validated @ModelAttribute("candidato")Candidato candidato,
			BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("nuevocandidato");
			mav.addObject("candidato", candidatoservice.getCandidato());
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/candidato/listaCandidatos");
		
	
		if(candidatoservice.guardarCandidato(candidato)) {
			//LOGGER.info("Se agregó un objeto al arrayList de alumnos");
		}
		return mav;
	}
}
