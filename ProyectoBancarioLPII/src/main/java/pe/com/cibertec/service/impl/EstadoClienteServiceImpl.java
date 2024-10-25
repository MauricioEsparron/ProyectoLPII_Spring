package pe.com.cibertec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.cibertec.model.entity.EstadoClienteEntity;
import pe.com.cibertec.repository.EstadoClienteRepository;
import pe.com.cibertec.service.EstadoClienteService;

@Service
public class EstadoClienteServiceImpl implements EstadoClienteService {

	@Autowired
	private EstadoClienteRepository estadoClienteRepository;

	@Override
	public List<EstadoClienteEntity> buscarEstadoClientes() {
		return estadoClienteRepository.findAll();
	}

	@Override
	public void crearEstadoCliente(EstadoClienteEntity estadocliente) {
		estadoClienteRepository.save(estadocliente);
	}

	@Override
	public EstadoClienteEntity buscarEstadoClientePorId(Integer id) {
		return estadoClienteRepository.findById(id).orElse(null);
	}

	@Override
	public void actualizarEstadoCliente(Integer id, EstadoClienteEntity estadoclienteActualizado) {
		EstadoClienteEntity estadoClienteEncontrado = buscarEstadoClientePorId(id);
		if (estadoClienteEncontrado == null) {
			throw new RuntimeException("Estado cliente no encontrado");
		}
		try {
			estadoClienteEncontrado.setDescripcion(estadoclienteActualizado.getDescripcion());
			estadoClienteRepository.save(estadoClienteEncontrado);
		} catch (Exception e) {
			throw new RuntimeException("Error al actualizar el estado cliente", e);
		}
	}

	@Override
	public void eliminarEstadoCliente(Integer id) {
		EstadoClienteEntity estadoClienteEncontrado = buscarEstadoClientePorId(id);
		if (estadoClienteEncontrado == null) {
			throw new RuntimeException("Estado cliente no encontrado");
		}
		estadoClienteRepository.delete(estadoClienteEncontrado);
	}
}
