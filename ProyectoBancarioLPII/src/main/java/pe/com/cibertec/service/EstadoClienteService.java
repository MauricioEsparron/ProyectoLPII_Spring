package pe.com.cibertec.service;

import java.util.List;

import pe.com.cibertec.model.entity.EstadoClienteEntity;

public interface EstadoClienteService {
	List<EstadoClienteEntity> buscarEstadoClientes();

	void crearEstadoCliente(EstadoClienteEntity estadocliente);

	EstadoClienteEntity buscarEstadoClientePorId(Integer id);

	void actualizarEstadoCliente(Integer id, EstadoClienteEntity estadoclienteEntity);

	void eliminarEstadoCliente(Integer id);

}
