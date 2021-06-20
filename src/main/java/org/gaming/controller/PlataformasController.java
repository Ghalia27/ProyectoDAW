package org.gaming.controller;

import org.gaming.model.Plataformas;
import org.gaming.model.Perfiles;
import org.gaming.repository.IPlataformaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlataformasController {
	@Autowired
	private IPlataformaRepository repo;
	
	@GetMapping("/cargarPlataforma")
	public String cargarPlataforma(Model model) {
		model.addAttribute("plataformas", new Plataformas());
		return "Mantener_Plataforma";
	}
	
	@PostMapping("/grabarPlataforma")
	public ModelAndView guardarPlataforma(@ModelAttribute Plataformas plataformas, Model model) throws Exception{	
		System.out.println(plataformas);
		ModelAndView vista = new ModelAndView();
		repo.save(plataformas);
			
		if (repo.findById(plataformas.getIdplataforma()).isPresent()){
			vista.addObject("mensaje", "Modificado Correctamente");
			vista.setViewName("Mantener_Plataforma");		
			return vista;
		}else {
			vista.addObject("mensaje", "Error");
			vista.setViewName("Mantener_Plataforma");		

			return vista;
		}
		
	}
	
	@GetMapping("/listarPlataformas")
	public String listadoPlataformas(Model model) {	
		model.addAttribute("lstPlataformas", repo.findAll());
		return "Listar_Plataformas";
	}
	
	@PostMapping("/eliminarPlataforma")
	public String eliminarPlataforma(@ModelAttribute Plataformas p, Model model) {
		System.out.println(p);
		repo.delete(p);
		model.addAttribute("plataformas",repo.findById(p.getIdplataforma()));
		return "Listar_Plataformas";
	}
	@PostMapping("/buscarPlataforma")
	public String buscarPlataforma(@ModelAttribute Plataformas g, Model model) {
		System.out.println(g);
		model.addAttribute("plataformas",repo.findById(g.getIdplataforma()));
		model.addAttribute("lstPlataformas", repo.findAll());
		return "Mantener_Plataforma";
	}
}
