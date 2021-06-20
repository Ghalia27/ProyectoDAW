package org.gaming.controller;

import org.gaming.model.Ediciones;
import org.gaming.model.Perfiles;
import org.gaming.repository.IEdicionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EdicionesController {
	@Autowired
	private IEdicionRepository repo;
	
	@GetMapping("/cargarEdicion")
	public String cargarEdicion(Model model) {
		model.addAttribute("ediciones", new Ediciones());
		return "Mantener_Edicion";
	}
	
	@PostMapping("/grabarEdicion")
	public ModelAndView guardarEdicion(@ModelAttribute Ediciones ediciones, Model model) throws Exception{	
		System.out.println(ediciones);
		ModelAndView vista = new ModelAndView();
		repo.save(ediciones);
			
		if (repo.findById(ediciones.getIdedicion()).isPresent()){
			vista.addObject("mensaje", "Modificado Correctamente");
			vista.setViewName("Mantener_Edicion");		
			return vista;
		}else {
			vista.addObject("mensaje", "Error");
			vista.setViewName("Mantener_Edicion");		

			return vista;
		}
		
	}
	
	@GetMapping("/listarEdiciones")
	public String listadoEdiciones(Model model) {	
		model.addAttribute("lstEdiciones", repo.findAll());
		return "Listar_Ediciones";
	}
	
	@PostMapping("/eliminarEdicion")
	public String eliminarEdicion(@ModelAttribute Ediciones e, Model model) {
		System.out.println(e);
		repo.delete(e);
		model.addAttribute("ediciones",repo.findById(e.getIdedicion()));
		model.addAttribute("lstEdiciones", repo.findAll());
		return "Listar_Ediciones";
	}
	@PostMapping("/buscarEdicion")
	public String buscarEdicion(@ModelAttribute Ediciones e, Model model) {
		System.out.println(e);
		model.addAttribute("ediciones",repo.findById(e.getIdedicion()));
		model.addAttribute("lstEdiciones", repo.findAll());
		return "Mantener_Edicion";
	}
}
