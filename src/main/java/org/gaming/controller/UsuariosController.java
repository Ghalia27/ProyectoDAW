package org.gaming.controller;

import org.gaming.Security.util.Passgenerator;
import org.gaming.model.Usuarios;
import org.gaming.repository.IGenerosRepository;
import org.gaming.repository.IPerfilesRepository;
import org.gaming.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UsuariosController {
	@GetMapping("/cargarUsuario")
	public String cargarUsuario(Model model) {
		model.addAttribute("usuarios", new Usuarios());
		model.addAttribute("ListPerfiles", repo_perfiles.findAll());
		model.addAttribute("ListGeneros", repo_generos.findAll());
		return "Registrar_Usuarios";
	}
	@Autowired
	private IUsuarioRepository repo;
	@Autowired
	private IPerfilesRepository repo_perfiles;
	@Autowired
	private IGenerosRepository repo_generos;
	@PostMapping("/grabarUsuario")
	public String guardarUsuario(@ModelAttribute Usuarios usuario, Model model,BindingResult bindingResult, RedirectAttributes redirectAttrs) throws Exception{
		Passgenerator pass = new Passgenerator();
		String contra="vacio";
		
		//guardar producto
		if (bindingResult.hasErrors()) {
	        return "Registrar_Usuarios";
	    }
	    if (repo.findFirstByIdusuario(usuario.getIdusuario()) != null) {
	    	 repo.save(usuario);
	        redirectAttrs
	                .addFlashAttribute("mensaje", "Este Id ya se encuentra registrado")
	                .addFlashAttribute("clase", "warning");
	        return "Editar_Usuario";
	    }
	    repo.save(new Usuarios(usuario.getIdusuario(),usuario.getNombres(),usuario.getApellidos(),
 				usuario.getEdad(),usuario.getDireccion(),usuario.getEmail(),pass.CrearContra(usuario.getContrasenia()),
				usuario.getEstado(),usuario.getIdperfil(),usuario.getIdgenero(),usuario.getDni(),usuario.getNrocuenta()));
	    redirectAttrs
	            .addFlashAttribute("mensaje", "Agregado correctamente")
	            .addFlashAttribute("clase", "success");
	    contra=pass.CrearContra(usuario.getContrasenia());
		System.out.println(contra);
	    return "redirect:/cargarUsuario";
	}
	
	@GetMapping("/listarUsuario")
	public String listadoUsuario(Model model) {
		System.out.println("Estra a listado");
		model.addAttribute("lstUsuarios", repo.findAll());
		model.addAttribute("ListPerfiles", repo_perfiles.findAll());
		model.addAttribute("ListGeneros", repo_generos.findAll());
		return "Listar_Usuarios";
	}
	
	@PostMapping("/eliminarUsuario")
	public String eliminarUsuario(@ModelAttribute Usuarios u, Model model) {
		System.out.println(u);
		repo.delete(u);
		model.addAttribute("usuarios",repo.findById(u.getIdusuario()));
		return "Listar_Usuario";
	}
	@PostMapping("/buscarUsuario")
	public String buscarUsuario(@ModelAttribute Usuarios u,  Model model) {
		System.out.println(u);
		model.addAttribute("usuarios",repo.findById(u.getIdusuario()));
		model.addAttribute("ListPerfiles", repo_perfiles.findAll());
		model.addAttribute("ListGeneros", repo_generos.findAll());
		return "Editar_Usuario";
	}
	@PostMapping("/editarUsuario")
	public ModelAndView actualizarUsuario(@ModelAttribute  Usuarios usuario, Model model, BindingResult bindingResult) throws Exception{	
		System.out.println(usuario);
		ModelAndView vista = new ModelAndView();
		
		Usuarios posibleUsuarioExistente = repo.findFirstByIdusuario(usuario.getIdusuario());
		if (posibleUsuarioExistente != null && !(posibleUsuarioExistente.getIdusuario() ==usuario.getIdusuario())){
			vista.addObject("mensaje", "Error");
			vista.addObject("clase", "danger");
			model.addAttribute("ListPerfiles", repo_perfiles.findAll());
			model.addAttribute("ListGeneros", repo_generos.findAll());
			vista.setViewName("Editar_Usuario");		
			return vista;
		}
		repo.save(usuario);
		vista.addObject("mensaje", "Registrado Correctamente");
		vista.addObject("clase", "success");
		model.addAttribute("ListPerfiles", repo_perfiles.findAll());
		model.addAttribute("ListGeneros", repo_generos.findAll());
		vista.setViewName("Editar_Usuario");		
		return vista;
		
	}

}
