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

import pe.com.cibertec.model.TipoUsuarioEntity;
import pe.com.cibertec.service.TipoUsuarioService;

@Controller
@RequestMapping("/tipousuarios")
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioService tipoUsuarioService;
    
    @GetMapping("/")
    public String listarTipoUsuarios(Model model) {
        List<TipoUsuarioEntity> listaTipoUsuarios = tipoUsuarioService.buscarTiposUsuario();
        model.addAttribute("lista_tipousuarios", listaTipoUsuarios);
        return "listar_tipousuarios";
    }
    
    @GetMapping("/registrar_tipousuario")
    public String mostrarRegistrarTipoUsuario(Model model) {
        model.addAttribute("tipousuario", new TipoUsuarioEntity());
        return "registrar_tipousuario";
    }
    
    @PostMapping("/registrar_tipousuario")
    public String registrarTipoUsuario(@ModelAttribute("tipousuario") TipoUsuarioEntity tipoUsuario, Model model) {
        tipoUsuarioService.crearTipoUsuario(tipoUsuario);
        return "redirect:/tipousuarios/";
    }
    
    @GetMapping("/detalle_tipousuario/{id}")
    public String verDetalleTipoUsuario(@PathVariable("id") Integer id, Model model) {
        TipoUsuarioEntity tipoUsuario = tipoUsuarioService.buscarTipoUsuarioPorId(id);
        model.addAttribute("tipousuario", tipoUsuario);
        return "detalle_tipousuario";
    }
    
    @GetMapping("/delete_tipousuario/{id}")
    public String deleteTipoUsuario(@PathVariable("id") Integer id) {
        tipoUsuarioService.eliminarTipoUsuario(id);
        return "redirect:/tipousuarios/";
    }
    
    @GetMapping("/editar_tipousuario/{id}")
    public String mostrarActualizarTipoUsuario(@PathVariable("id") Integer id, Model model) {
        TipoUsuarioEntity tipoUsuario = tipoUsuarioService.buscarTipoUsuarioPorId(id);
        model.addAttribute("tipousuario", tipoUsuario);
        return "editar_tipousuario";
    }
    
    @PostMapping("/editar_tipousuario/{id}")
    public String actualizarTipoUsuario(@PathVariable("id") Integer id, @ModelAttribute("tipousuario") TipoUsuarioEntity tipoUsuario) {
        tipoUsuarioService.actualizarTipoUsuario(id, tipoUsuario);
        return "redirect:/tipousuarios/";
    }
}
