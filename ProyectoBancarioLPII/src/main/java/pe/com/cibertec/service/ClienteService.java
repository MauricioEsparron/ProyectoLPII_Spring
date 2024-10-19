package pe.com.cibertec.service;

import java.util.List;
import pe.com.cibertec.model.ClienteEntity;

public interface ClienteService {
    List<ClienteEntity> buscarClientes();
    void crearCliente(ClienteEntity cliente);
    ClienteEntity buscarClientePorId(Integer id);
    void actualizarCliente(Integer id, ClienteEntity clienteEntity);
    void eliminarCliente(Integer id);
}
