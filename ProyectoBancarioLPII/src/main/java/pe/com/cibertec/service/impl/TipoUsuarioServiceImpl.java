package pe.com.cibertec.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.cibertec.model.TipoUsuarioEntity;
import pe.com.cibertec.repository.TipoUsuarioRepository;
import pe.com.cibertec.service.TipoUsuarioService;

@Service
public class TipoUsuarioServiceImpl implements TipoUsuarioService {

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @Override
    public List<TipoUsuarioEntity> buscarTiposUsuario() {
        return tipoUsuarioRepository.findAll();
    }

    @Override
    public void crearTipoUsuario(TipoUsuarioEntity tipoUsuario) {
        tipoUsuarioRepository.save(tipoUsuario);
    }

    @Override
    public TipoUsuarioEntity buscarTipoUsuarioPorId(Integer id) {
        return tipoUsuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void actualizarTipoUsuario(Integer id, TipoUsuarioEntity tipoUsuarioActualizado) {
        TipoUsuarioEntity tipoUsuarioEncontrado = buscarTipoUsuarioPorId(id);
        if (tipoUsuarioEncontrado == null) {
            throw new RuntimeException("Tipo de usuario no encontrado");
        }
        try {
            tipoUsuarioEncontrado.setDescripcion(tipoUsuarioActualizado.getDescripcion());
            tipoUsuarioRepository.save(tipoUsuarioEncontrado);
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar");
        }
    }

    @Override
    public void eliminarTipoUsuario(Integer id) {
        TipoUsuarioEntity tipoUsuarioEncontrado = buscarTipoUsuarioPorId(id);
        if (tipoUsuarioEncontrado == null) {
            throw new RuntimeException("Tipo de usuario no encontrado");
        }
        tipoUsuarioRepository.delete(tipoUsuarioEncontrado);
    }
}
