package pe.com.cibertec.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.cibertec.model.ClienteEntity;
import pe.com.cibertec.repository.ClienteRepository;
import pe.com.cibertec.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteEntity> buscarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public void crearCliente(ClienteEntity cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public ClienteEntity buscarClientePorId(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public void actualizarCliente(Integer id, ClienteEntity clienteActualizado) {
        ClienteEntity clienteEncontrado = buscarClientePorId(id);
        if (clienteEncontrado == null) {
            throw new RuntimeException("Cliente no encontrado");
        }
        try {
            clienteEncontrado.setNombre(clienteActualizado.getNombre());
            clienteEncontrado.setDireccion(clienteActualizado.getDireccion());
            clienteEncontrado.setFechaNacimiento(clienteActualizado.getFechaNacimiento());
            clienteEncontrado.setDocumentoIdentidad(clienteActualizado.getDocumentoIdentidad());
            clienteRepository.save(clienteEncontrado);
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar");
        }
    }

    @Override
    public void eliminarCliente(Integer id) {
        ClienteEntity clienteEncontrado = buscarClientePorId(id);
        if (clienteEncontrado == null) {
            throw new RuntimeException("Cliente no encontrado");
        }
        clienteRepository.delete(clienteEncontrado);
    }
}
