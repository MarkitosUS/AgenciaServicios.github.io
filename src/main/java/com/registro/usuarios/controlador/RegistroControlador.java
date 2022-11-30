package com.registro.usuarios.controlador;

import com.registro.usuarios.modelo.Producto;
import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.servicio.IproductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.registro.usuarios.servicio.UsuarioServicio;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Controller
public class RegistroControlador {

	@Autowired
	private IproductoService Pservice;

	@Autowired
	private UsuarioServicio Uservicio;

	@GetMapping("/login")
	public String iniciarSesion() {
		return "login";
	}

	@GetMapping("/usuarios")
	public String verPaginaDeInicio(Model modelo) {
		modelo.addAttribute("usuarios", Uservicio.listarUsuarios());
		return "usuarios";
	}

	@GetMapping("/inicio")
	public String inicio() {

		return "index";

	}

	@GetMapping("/f1")
	public String fase1() {

		return "webinicio";

	}

	@GetMapping("/inventario")
	public String   listar(Model model) {
		List<Producto> productos=Pservice.listar();
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
		Pservice.save(p);
		return "redirect:/inventario";

	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model){
		Optional<Producto> producto=Pservice.listarId(id);
		model.addAttribute("producto", producto);
		return "formi";

	}

	@GetMapping("/eliminar/{id}")
	public String delete(Model model, @PathVariable int id){
		Pservice.delete(id);
		return "redirect:/inventario";

	}

	@GetMapping("/editarU/{id}")
	public String editarU(@PathVariable int id, Model model){
		Optional<Usuario>usuario=Uservicio.listarId(id);
		model.addAttribute("usuario", usuario);
		return "registrador";

	}

	@GetMapping("/eliminarU/{id}")
	public String eliminarU(Model model, @PathVariable int id){
		Uservicio.delete(id);
		return "redirect:/usuarios";

	}

}
