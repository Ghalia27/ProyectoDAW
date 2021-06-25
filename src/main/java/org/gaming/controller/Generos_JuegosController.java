package org.gaming.controller;



import org.gaming.model.Generos_juegos;
import org.gaming.model.Perfiles;
import org.gaming.repository.IGeneros_JuegosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Generos_JuegosController {

	@Autowired
	private IGeneros_JuegosRepository repo;
	
	@GetMapping("/listGenJuegos")
	public String listadoGenJuegos(Model model) {		
		model.addAttribute("lstGenJuegos", repo.findAll());
				
		return "List_GenJuegos";
	}
	
	
	@PostMapping("/RgstGenJuegos")
	public String guardarPerfil(@ModelAttribute Generos_juegos GenJuego, Model model) throws Exception{	
		System.out.println(GenJuego);
		ModelAndView vista = new ModelAndView();
		try {
			repo.save(GenJuego);
			System.out.println("BIEN.X2......");
			//model.addAttribute("message","Baeldung");
			vista.setViewName("Registrar_GenJuegos");
			vista.addObject("mensaje", "Modificado Correctamente");
		}catch(Exception e) {
			System.out.println("ERROR.......");
			
		};
		model.addAttribute("GenJuego", repo.findById(GenJuego.getIdgenerojuego()));
		return "Registrar_GenJuegos";
	}
	
	@PostMapping("/buscarGenJue")
	public String buscarGen(@ModelAttribute Generos_juegos  gj, Model model) {
		
		System.out.println(gj);
		model.addAttribute("GenJuego", repo.findById(gj.getIdgenerojuego()));
		model.addAttribute("opcion", 1);
		return "Registrar_GenJuegos";
		
	
	}
	@GetMapping("/eliminarGenJue")
	public String eliminarPerfil(@ModelAttribute Generos_juegos p, Model model) {
		System.out.println(p);
		repo.delete(p);
		model.addAttribute("GenJuego",repo.findById(p.getIdgenerojuego()));
		model.addAttribute("lstGenJuegos", repo.findAll());
		return "List_GenJuegos";
	}
	
	
}
