package pe.com.cibertec.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.cibertec.model.UsuarioEntity;
import pe.com.cibertec.repository.UsuarioRepository;
import pe.com.cibertec.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioEntity> buscarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public void crearUsuario(UsuarioEntity usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioEntity buscarUsuarioPorId(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void actualizarUsuario(Integer id, UsuarioEntity usuarioActualizado) {
        UsuarioEntity usuarioEncontrado = buscarUsuarioPorId(id);
        if (usuarioEncontrado == null) {
            throw new RuntimeException("Usuario no encontrado");
        }
        try {
            usuarioEncontrado.setCorreo(usuarioActualizado.getCorreo());
            usuarioEncontrado.setPassword(usuarioActualizado.getPassword());
            usuarioRepository.save(usuarioEncontrado);
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar");
        }
    }

    @Override
    public void eliminarUsuario(Integer id) {
        UsuarioEntity usuarioEncontrado = buscarUsuarioPorId(id);
        if (usuarioEncontrado == null) {
            throw new RuntimeException("Usuario no encontrado");
        }
        usuarioRepository.delete(usuarioEncontrado);
    }
}
