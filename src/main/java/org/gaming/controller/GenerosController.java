package org.gaming.controller;

import org.gaming.model.Generos;
import org.gaming.model.Perfiles;
import org.gaming.repository.IGenerosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GenerosController {
	@Autowired
	private IGenerosRepository repo;
	
	@GetMapping("/cargarGenero")
	public String cargarGeneros(Model model) {
		model.addAttribute("generos", new Generos());
		return "Mantener_Generos";
	}
	
	@PostMapping("/grabarGenero")
	public ModelAndView guardarGeneros(@ModelAttribute Generos generos, Model model) throws Exception{	
		System.out.println(generos);
		ModelAndView vista = new ModelAndView();
		repo.save(generos);
			
		if (repo.findById(generos.getIdgenero()).isPresent()){
			vista.addObject("mensaje", "Registrado Correctamente");
			vista.addObject("clase", "success");
			vista.setViewName("Mantener_Generos");		
			return vista;
		}else {
			vista.addObject("mensaje", "Error");
			vista.addObject("clase", "danger");
			vista.setViewName("Mantener_Generos");		

			return vista;
		}
		
	}
	
	@GetMapping("/listarGenero")
	public String listadoGeneros(Model model) {	
		model.addAttribute("lstGeneros", repo.findAll());
		return "Listar_Generos";
	}
	
	@PostMapping("/eliminarGenero")
	public String eliminarGenero(@ModelAttribute Generos g, Model model) {
		System.out.println(g);
		repo.delete(g);
		model.addAttribute("generos",repo.findById(g.getIdgenero()));
		return "Listar_Generos";
	}
	@PostMapping("/buscarGenero")
	public String buscarGeneros(@ModelAttribute Generos g, Model model) {
		System.out.println(g);
		model.addAttribute("generos",repo.findById(g.getIdgenero()));
		model.addAttribute("lstGeneros", repo.findAll());
		return "Mantener_Generos";
	}
}
