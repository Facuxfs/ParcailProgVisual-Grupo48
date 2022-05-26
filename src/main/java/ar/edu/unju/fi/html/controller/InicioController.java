package ar.edu.unju.fi.html.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.fi.html.util.listaCandidatos;
@Controller
public class InicioController {


		
		@GetMapping("/inicio")
		public String getIndexPage(Model model) {
			listaCandidatos listacartas = new listaCandidatos();
			model.addAttribute("listacartas", listacartas.getListaCandidatos());
			
			return "inicio";
		}
		
}
