package org.gaming.controller;

import org.gaming.model.Clasificaciones;
import org.gaming.repository.IClasificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClasificacionesController {
	@Autowired
	private IClasificacionRepository repo;
	
	@GetMapping("/cargarClasificacion")
	public String cargarClasificacion(Model model) {
		model.addAttribute("clasificaciones", new Clasificaciones());
		return "Mantener_Clasificacion";
	}
	
	@PostMapping("/grabarClasificacion")
	public ModelAndView guardarClasificacion(@ModelAttribute Clasificaciones clasificaciones, Model model) throws Exception{	
		System.out.println(clasificaciones);
		ModelAndView vista = new ModelAndView();
		repo.save(clasificaciones);
			
		if (repo.findById(clasificaciones.getIdclasificacion()).isPresent()){
			vista.addObject("mensaje", "Modificado Correctamente");
			vista.setViewName("Mantener_Clasificacion");		
			return vista;
		}else {
			vista.addObject("mensaje", "Error");
			vista.setViewName("Mantener_Clasificacion");
			return vista;
		}
		
	}
	
	@GetMapping("/listarClasificaciones")
	public String listadoClasificaciones(Model model) {	
		model.addAttribute("lstClasificaciones", repo.findAll());
		return "Listar_Clasificaciones";
	}
	
	@PostMapping("/eliminarClasificacion")
	public String eliminarClasificacion(@ModelAttribute Clasificaciones c, Model model) {
		System.out.println(c);
		repo.delete(c);
		model.addAttribute("clasificaciones",repo.findById(c.getIdclasificacion()));
		return "Listar_Clasificaciones";
	}
	@PostMapping("/buscarClasificacion")
	public String buscarClasificacion(@ModelAttribute Clasificaciones c, Model model) {
		System.out.println(c);
		model.addAttribute("clasificaciones",repo.findById(c.getIdclasificacion()));
		model.addAttribute("lstClasificaciones", repo.findAll());
		return "Mantener_Clasificacion";
	}
	@GetMapping("/partial_up")
    public String getPartial() {
        return "partial_up.html";
    }
    @GetMapping("/partial_down")
    public String getHome() {
        return "partial_down.html";
    }
}
