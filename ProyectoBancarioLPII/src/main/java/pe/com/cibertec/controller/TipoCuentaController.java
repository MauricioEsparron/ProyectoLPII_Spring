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

import pe.com.cibertec.model.entity.TipoCuentaEntity;
import pe.com.cibertec.service.TipoCuentaService;

@Controller
@RequestMapping("/tipocuentas")
public class TipoCuentaController {

	@Autowired
	private TipoCuentaService tipoCuentaService;

	@GetMapping("/")
	public String listarTipoCuentas(Model model) {
		List<TipoCuentaEntity> listaTipoCuentas = tipoCuentaService.buscarTiposCuenta();
		model.addAttribute("lista_tipocuentas", listaTipoCuentas);
		return "listar_tipocuentas";
	}

	@GetMapping("/registrar_tipocuenta")
	public String mostrarRegistrarTipoCuenta(Model model) {
		model.addAttribute("tipocuenta", new TipoCuentaEntity());
		return "registrar_tipocuenta";
	}

	@PostMapping("/registrar_tipocuenta")
	public String registrarTipoCuenta(@ModelAttribute("tipocuenta") TipoCuentaEntity tipoCuenta, Model model) {
		tipoCuentaService.crearTipoCuenta(tipoCuenta);
		return "redirect:/tipocuentas/";
	}

	@GetMapping("/detalle_tipocuenta/{id}")
	public String verDetalleTipoCuenta(@PathVariable("id") Integer id, Model model) {
		TipoCuentaEntity tipoCuenta = tipoCuentaService.buscarTipoCuentaPorId(id);
		model.addAttribute("tipocuenta", tipoCuenta);
		return "detalle_tipocuenta";
	}

	@GetMapping("/delete_tipocuenta/{id}")
	public String deleteTipoCuenta(@PathVariable("id") Integer id) {
		tipoCuentaService.eliminarTipoCuenta(id);
		return "redirect:/tipocuentas/";
	}

	@GetMapping("/editar_tipocuenta/{id}")
	public String mostrarActualizarTipoCuenta(@PathVariable("id") Integer id, Model model) {
		TipoCuentaEntity tipoCuenta = tipoCuentaService.buscarTipoCuentaPorId(id);
		model.addAttribute("tipocuenta", tipoCuenta);
		return "editar_tipocuenta";
	}

	@PostMapping("/editar_tipocuenta/{id}")
	public String actualizarTipoCuenta(@PathVariable("id") Integer id,
			@ModelAttribute("tipocuenta") TipoCuentaEntity tipoCuenta) {
		tipoCuentaService.actualizarTipoCuenta(id, tipoCuenta);
		return "redirect:/tipocuentas/";
	}
}
