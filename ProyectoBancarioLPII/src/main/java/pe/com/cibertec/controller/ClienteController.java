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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.com.cibertec.model.entity.ClienteEntity;
import pe.com.cibertec.model.entity.EstadoClienteEntity;
import pe.com.cibertec.service.ClienteService;
import pe.com.cibertec.service.EstadoClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private EstadoClienteService estadoClienteService;

	@GetMapping("/")
	public String listarClientes(Model model) {
		List<ClienteEntity> listaClientes = clienteService.buscarClientes();
		model.addAttribute("lista_clientes", listaClientes);
		return "listar_clientes";
	}

	@GetMapping("/registrar_cliente")
	public String mostrarRegistrarCliente(Model model) {
		model.addAttribute("cliente", new ClienteEntity());
		List<EstadoClienteEntity> listaEstadoCliente = estadoClienteService.buscarEstadoClientes();
		model.addAttribute("listarEstadoCliente", listaEstadoCliente);
		return "registrar_cliente";
	}

	@PostMapping("/registrar_cliente")
	public String registrarCliente(@ModelAttribute("cliente") ClienteEntity cliente,
			RedirectAttributes redirectAttributes) {
		clienteService.crearCliente(cliente);
		redirectAttributes.addFlashAttribute("mensaje", "Cliente registrado exitosamente");
		return "redirect:/clientes/";
	}

	@GetMapping("/detalle_cliente/{id}")
	public String verDetalleCliente(@PathVariable("id") Integer id, Model model) {
		ClienteEntity cliente = clienteService.buscarClientePorId(id);
		model.addAttribute("cliente", cliente);
		return "detalle_cliente";
	}

	@GetMapping("/delete_cliente/{id}")
	public String deleteCliente(@PathVariable("id") Integer id) {
		clienteService.eliminarCliente(id);
		return "redirect:/clientes/";
	}

	@GetMapping("/editar_cliente/{id}")
	public String mostrarActualizarCliente(@PathVariable("id") Integer id, Model model) {
		ClienteEntity cliente = clienteService.buscarClientePorId(id);
		model.addAttribute("cliente", cliente);
		return "editar_cliente";
	}

	@PostMapping("/editar_cliente/{id}")
	public String actualizarCliente(@PathVariable("id") Integer id, @ModelAttribute("cliente") ClienteEntity cliente,
			RedirectAttributes redirectAttributes) {
		try {
			clienteService.actualizarCliente(id, cliente);
			redirectAttributes.addFlashAttribute("mensaje", "Cliente actualizado exitosamente");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", "Error al actualizar el cliente");
		}
		return "redirect:/clientes/";
	}

}
