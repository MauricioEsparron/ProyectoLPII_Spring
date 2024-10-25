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

import pe.com.cibertec.model.entity.HistorialSesionEntity;
import pe.com.cibertec.service.HistorialSesionService;

@Controller
@RequestMapping("/historialsesiones")
public class HistorialSesionController {

	@Autowired
	private HistorialSesionService historialSesionService;

	@GetMapping("/")
	public String listarHistorialSesion(Model model) {
		List<HistorialSesionEntity> listaHistorial = historialSesionService.buscarHistorialSesiones();
		model.addAttribute("lista_historial", listaHistorial);
		return "listar_historialsesion";
	}

	@GetMapping("/registrar_historial")
	public String mostrarRegistrarHistorialSesion(Model model) {
		model.addAttribute("historial", new HistorialSesionEntity());
		return "registrar_historial_sesion";
	}

	@PostMapping("/registrar_historial")
	public String registrarHistorialSesion(@ModelAttribute("historial") HistorialSesionEntity historial, Model model) {
		historialSesionService.crearHistorialSesion(historial);
		return "redirect:/historialsesiones/";
	}

	@GetMapping("/detalle_historial/{id}")
	public String verDetalleHistorialSesion(@PathVariable("id") Integer id, Model model) {
		HistorialSesionEntity historial = historialSesionService.buscarHistorialSesionPorId(id);
		model.addAttribute("historial", historial);
		return "detalle_historialsesion";
	}

	@GetMapping("/delete_historial/{id}")
	public String deleteHistorial(@PathVariable("id") Integer id) {
		historialSesionService.eliminarHistorialSesion(id);
		return "redirect:/historialsesiones/";
	}

	@GetMapping("/editar_historial/{id}")
	public String mostrarActualizarHistorialSesion(@PathVariable("id") Integer id, Model model) {
		HistorialSesionEntity historial = historialSesionService.buscarHistorialSesionPorId(id);
		model.addAttribute("historial", historial);
		return "editar_historialsesion";
	}

}
