package org.gaming.controller;

import org.gaming.model.Usuarios;
import org.gaming.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class UsuarioController {
	@GetMapping("/cargar-usuario")
	public String cargarUsu(Model model) {
		model.addAttribute("usuarios", new Usuarios());
		return "crearUsuario";
	}
	@Autowired
	private IUsuarioRepository repo;
	@PostMapping("/grabar")
	public String guardarProd(@ModelAttribute Usuarios usuario) {
		//guardar producto
		repo.save(usuario); //merge - si el existe el producto lo actualiza sino lo agrega
		//grabas en pase de datos con persistence
		return "crearUsuario";
	}
	
	@GetMapping("/listar-usuario")
	public String listadoUsuario(Model model) {
		System.out.println("Estra a listado");
		model.addAttribute("lstUsuarios", repo.findAll());
		return "listarUsuario";
	}
	@PostMapping("/editar")
	public String buscarProd(@ModelAttribute Usuarios u, Model model) {
		model.addAttribute("usuario", repo.findById(String.valueOf(u.getIdusuario())));
		System.out.println(u);
		return "crudproducto";
	}
}
