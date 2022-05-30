package ar.edu.unju.fi.html.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.fi.html.servicee.ICandidatosService;

@Controller
public class InicioController {

	@Autowired
	@Qualifier("CandidatosServiceImp")
	private ICandidatosService candidatoservice;

		
		@GetMapping("/inicio")
		public String getIndexPage(Model model) {
			//listaCandidatos listacartas = new listaCandidatos();
			model.addAttribute("listacartas", candidatoservice.getListaCandidatos().getListaCandidatos());
			return "inicio";
		}
		
}
