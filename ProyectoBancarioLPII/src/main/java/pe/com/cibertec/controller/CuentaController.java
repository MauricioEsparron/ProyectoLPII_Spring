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

import pe.com.cibertec.model.entity.CuentaEntity;
import pe.com.cibertec.model.entity.EstadoCuentaEntity;
import pe.com.cibertec.model.entity.TipoCuentaEntity;
import pe.com.cibertec.service.CuentaService;
import pe.com.cibertec.service.EstadoCuentaService;
import pe.com.cibertec.service.TipoCuentaService;

@Controller
@RequestMapping("/cuentas")
public class CuentaController {

	@Autowired
	private CuentaService cuentaService;

	@Autowired
	private TipoCuentaService tipoCuentaService;

	@Autowired
	private EstadoCuentaService estadoCuentaService;

	@GetMapping("/")
	public String listarCuentas(Model model) {
		List<CuentaEntity> listaCuentas = cuentaService.buscarCuentas();
		model.addAttribute("lista_cuentas", listaCuentas);
		return "listar_cuentas";
	}

	@GetMapping("/registrar_cuenta")
	public String mostrarRegistrarCuenta(Model model) {
		model.addAttribute("cuenta", new CuentaEntity());

		List<TipoCuentaEntity> listaTipoCuenta = tipoCuentaService.buscarTiposCuenta();
		model.addAttribute("lista_tiposCuenta", listaTipoCuenta);
		List<EstadoCuentaEntity> listaEstadoCuenta = estadoCuentaService.buscarEstadoCuentas();
		model.addAttribute("lista_estadosCuenta", listaEstadoCuenta);

		return "registrar_cuenta";
	}

	@PostMapping("/registrar_cuenta")
	public String registrarCuenta(@ModelAttribute("cuenta") CuentaEntity cuenta, Model model) {
		cuentaService.crearCuenta(cuenta);
		return "redirect:/cuentas/";
	}

	@GetMapping("/detalle_cuenta/{id}")
	public String verDetalleCuenta(@PathVariable("id") Integer id, Model model) {
		CuentaEntity cuenta = cuentaService.buscarCuentaPorId(id);
		model.addAttribute("cuenta", cuenta);
		return "detalle_cuenta";
	}

	@GetMapping("/delete_cuenta/{id}")
	public String deleteCuenta(@PathVariable("id") Integer id) {
		cuentaService.eliminarCuenta(id);
		return "redirect:/cuentas/";
	}

	@GetMapping("/editar_cuenta/{id}")
	public String mostrarActualizarCuenta(@PathVariable("id") Integer id, Model model) {
		CuentaEntity cuenta = cuentaService.buscarCuentaPorId(id);
		model.addAttribute("cuenta", cuenta);
		return "editar_cuenta";
	}

	@PostMapping("/editar_cuenta/{id}")
	public String actualizarCuenta(@PathVariable("id") Integer id, @ModelAttribute("cuenta") CuentaEntity cuenta) {
		cuentaService.actualizarCuenta(id, cuenta);
		return "redirect:/cuentas/";
	}
}
