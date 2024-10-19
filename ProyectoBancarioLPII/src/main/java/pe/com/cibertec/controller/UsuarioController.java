package pe.com.cibertec.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.cibertec.model.UsuarioEntity;
import pe.com.cibertec.service.UsuarioService;

@Controller
@RequestMapping("/usuarios") 
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public String listarUsuario(Model model) {
        List<UsuarioEntity> listaUsuario = usuarioService.buscarUsuarios();
        model.addAttribute("lista_usuario", listaUsuario);
        return "listar_usuarios";
    }

    @GetMapping("/registrar_usuario")
    public String mostrarRegistrarUsuario(Model model) {
        model.addAttribute("user", new UsuarioEntity());
        return "registrar_usuario";
    }

    @PostMapping("/registrar_usuario")
    public String registrarUsuario(@ModelAttribute("user") UsuarioEntity usuario, Model model) {
        usuarioService.crearUsuario(usuario);
        return "redirect:/usuarios/";  // Aquí deberías ser redirigido a la lista de usuarios
    }

    @GetMapping("/detalle_usuario/{id}")
    public String verDetalle(Model model, @PathVariable("id") Integer id) {
        UsuarioEntity user = usuarioService.buscarUsuarioPorId(id);
        model.addAttribute("user", user);
        return "detalle_usuario";
    }

    @GetMapping("/delete/{id}")
    public String deleteUsuario(@PathVariable("id") Integer id) {
        usuarioService.eliminarUsuario(id);
        return "redirect:/usuarios/";  // Redirigir después de eliminar
    }

    @GetMapping("/editar_usuario/{id}")
    public String mostrarActualizar(@PathVariable("id") Integer id, Model model) {
        UsuarioEntity user = usuarioService.buscarUsuarioPorId(id);
        model.addAttribute("user", user);
        return "editar_usuario";
    }

    @PostMapping("/editar_usuario/{id}")
    public String actualizarUsuario(@PathVariable("id") Integer id, @ModelAttribute("user") UsuarioEntity user) {
        usuarioService.actualizarUsuario(id, user);
        return "redirect:/usuarios/";  // Redirigir después de actualizar
    }
}
