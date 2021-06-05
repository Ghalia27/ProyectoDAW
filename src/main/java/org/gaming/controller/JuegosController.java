package org.gaming.controller;

import org.gaming.repository.IGeneros_JuegosRepository;
import org.gaming.repository.IJuegosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JuegosController {

	@Autowired
	private IJuegosRepository repo;
	
	@GetMapping("/listJuegos")
	public String listadoGenJuegos(Model model) {
		
		
		model.addAttribute("lstJuegos", repo.findAll());
		
		
		
		return "List_Juegos";
	}
	
	@GetMapping("/RgstJuegos")
	public String RgstJuegos(Model model) {

		
		return "Registrar_Juegos";
	}
	
}
