package com.registro.usuarios.controlador;

import com.registro.usuarios.modelo.Producto;
import com.registro.usuarios.servicio.IproductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.registro.usuarios.controlador.dto.UsuarioRegistroDTO;
import com.registro.usuarios.servicio.UsuarioServicio;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/registrador")
public class RegistroUsuarioControlador {

	@Autowired
	private IproductoService productoservice;
	private UsuarioServicio usuarioServicio;

	public RegistroUsuarioControlador(UsuarioServicio usuarioServicio, IproductoService productoservice) {
		super();
		this.usuarioServicio = usuarioServicio;
		this.productoservice = productoservice;
	}
	
	@ModelAttribute("usuario")
	public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
		return new UsuarioRegistroDTO();
	}

	@GetMapping
	public String mostrarFormularioDeRegistro() {
		return "registrador";
	}
	
	@PostMapping
	public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO) {
		usuarioServicio.guardar(registroDTO);
		return "redirect:/registrador?exito";
	}

	// productos

	// INVENTARIO

	@GetMapping("/inventario")
	public String   listar(Model model) {
		List<Producto> productos=productoservice.listar();
		model.addAttribute("productos", productos);
		return "inventario";

	}

	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("producto", new Producto());
		return "formi";
	}

	@PostMapping("/save")
	public String save(@Valid Producto p, Model model){
		productoservice.save(p);
		return "redirect:/inventario";

	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model){
		Optional<Producto> producto=productoservice.listarId(id);
		model.addAttribute("producto", producto);
		return "formi";

	}

	@GetMapping("/eliminar/{id}")
	public String delete(Model model, @PathVariable int id){
		productoservice.delete(id);
		return "redirect:/inventario";

	}


}
