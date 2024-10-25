package pe.com.cibertec.controller;

//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import pe.com.cibertec.model.entity.UsuarioEntity;
import pe.com.cibertec.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/")
	public String listarUsuario(Model model) {
		List<UsuarioEntity> listaUsuario = usuarioService.buscarUsuarios();
		model.addAttribute("lista_usuarios", listaUsuario);
		return "listar_usuarios";
	}

	@GetMapping("/registrar_usuario")
	public String mostrarRegistrarUsuario(Model model) {
		model.addAttribute("usuario", new UsuarioEntity());
		return "registrar_usuario";
	}

	@PostMapping("/registrar_usuario")
	public String registrarUsuario(@ModelAttribute("usuario") UsuarioEntity usuario, Model model,
			@RequestParam("foto") MultipartFile foto) {

//		if (!foto.isEmpty()) {
//			String imagenUrl = almacenarImagen(foto);
//			usuario.setUrlImagen(imagenUrl);
//		}
		usuarioService.crearUsuario(usuario);
		return "redirect:/productos/";
	}

//	private String almacenarImagen(MultipartFile file) {
//		// Define la ruta donde quieres guardar la imagen
//		String directorioDestino = "src/main/resources/static/images";
//		String nombreArchivo = file.getOriginalFilename();
//		Path rutaDestino = Paths.get(directorioDestino, nombreArchivo);
//		int contador = 1;
//		while (Files.exists(rutaDestino)) {
//			String nuevoNombreArchivo = nombreArchivo.substring(0, nombreArchivo.lastIndexOf('.')) + "_" + contador
//					+ nombreArchivo.substring(nombreArchivo.lastIndexOf('.'));
//			rutaDestino = Paths.get(directorioDestino, nuevoNombreArchivo);
//			contador++;
//		}
//
//		try {
//			Files.createDirectories(rutaDestino.getParent());
//			Files.copy(file.getInputStream(), rutaDestino);
//			return "/images/" + rutaDestino.getFileName().toString();
//		} catch (IOException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}

	@GetMapping("/detalle_usuario/{id}")
	public String verDetalle(Model model, @PathVariable("id") String correo) {
		UsuarioEntity user = usuarioService.buscarUsuarioPorCorreo(correo);
		model.addAttribute("usuario", user);
		return "detalle_usuario";
	}

	@GetMapping("/delete/{id}")
	public String deleteUsuario(@PathVariable("id") String correo) {
		usuarioService.eliminarUsuario(correo);
		return "redirect:/usuarios/";
	}

	@GetMapping("/editar_usuario/{id}")
	public String mostrarActualizar(@PathVariable("id") String correo, Model model) {
		UsuarioEntity user = usuarioService.buscarUsuarioPorCorreo(correo);
		model.addAttribute("usuario", user);
		return "editar_usuario";
	}

	@PostMapping("/editar_usuario/{id}")
	public String actualizarUsuario(@PathVariable("id") String correo, @ModelAttribute("usuario") UsuarioEntity user) {
		usuarioService.actualizarUsuario(correo, user);
		return "redirect:/usuarios/";
	}

	@GetMapping("/login")
	public String mostrarLogin(Model model) {
		model.addAttribute("usuario", new UsuarioEntity());
		return "login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute("usuario") UsuarioEntity usuarioFormulario, Model model, HttpSession session) {
		boolean usuarioValidado = usuarioService.validarUsuario(usuarioFormulario);
		if (usuarioValidado) {
			session.setAttribute("usuario", usuarioFormulario.getCorreo());
			return "redirect:/menu";
		}
		model.addAttribute("loginInvalido", "No existe el usuario");
		model.addAttribute("usuario", new UsuarioEntity());
		return "login";
	}

	@GetMapping("/logout")
	public String logout(HttpSession sesion) {
		sesion.invalidate();
		return "redirect:/home";
	}
}
