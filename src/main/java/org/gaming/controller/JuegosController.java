package org.gaming.controller;

import org.gaming.model.Generos;
import org.gaming.model.Juegos;
import org.gaming.repository.IGeneros_JuegosRepository;
import org.gaming.repository.IJuegosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JuegosController {

	@Autowired
	private IJuegosRepository repo;
	
	@GetMapping("/cargarJuego")
	public String cargarJuego(Model model) {
		model.addAttribute("juegos", new Juegos());
		return "Registrar_Juegos";
	} 
	
	@PostMapping("/grabarJuego")
	public ModelAndView guardarJuegos(@ModelAttribute Juegos juegos, Model model) throws Exception{	
		System.out.println(juegos);
		ModelAndView vista = new ModelAndView();
		repo.save(juegos);
			
		if (repo.findById(juegos.getIdjuego()).isPresent()){
			vista.addObject("mensaje", "Modificado Correctamente");
			vista.setViewName("Registrar_Juegos");		
			return vista;
		}else {
			vista.addObject("mensaje", "Error");
			vista.setViewName("Registrar_Juegos");		

			return vista;
		}
		
	}

	@GetMapping("/listarJuego")
	public String listadoJuegos(Model model) {
		model.addAttribute("lstJuegos", repo.findAll());
		return "Listar_Juegos";
	}
	
	@PostMapping("/eliminarJuego")
	public String eliminarJuego(@ModelAttribute Juegos j, Model model) {
		System.out.println(j);
		repo.delete(j);
		model.addAttribute("juegos",repo.findById(j.getIdjuego()));
		return "Listar_Juegos";
	}
	@PostMapping("/buscarJuego")
	public String buscarJuego(@ModelAttribute Juegos j,  Model model) {
		System.out.println(j);
		model.addAttribute("juegos",repo.findById(j.getIdjuego()));
		return "Registrar_Juegos";
	}
	
	
}
