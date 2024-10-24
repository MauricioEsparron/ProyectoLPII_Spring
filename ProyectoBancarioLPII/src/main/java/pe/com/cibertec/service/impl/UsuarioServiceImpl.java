package pe.com.cibertec.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import pe.com.cibertec.model.UsuarioEntity;
import pe.com.cibertec.repository.UsuarioRepository;
import pe.com.cibertec.service.UsuarioService;
import pe.com.cibertec.utils.Utilitarios;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

	private final UsuarioRepository usuarioRepository;

	@Override
	public List<UsuarioEntity> buscarUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public void crearUsuario(UsuarioEntity usuario, MultipartFile foto) {
		String nombreFoto = Utilitarios.guardarImagen(foto);
		usuario.setUrlImagen(nombreFoto);
		String passwordHash = Utilitarios.extraerHash(usuario.getPassword());
		usuario.setPassword(passwordHash);
		usuarioRepository.save(usuario);
	}

	@Override
	public boolean validarUsuario(UsuarioEntity usuarioFormulario) {
		UsuarioEntity usuarioEncontrado = usuarioRepository.findByCorreo(usuarioFormulario.getCorreo());
		if (usuarioEncontrado == null) {
			return false;
		}
		if (!Utilitarios.checkPassword(usuarioFormulario.getPassword(), usuarioEncontrado.getPassword())) {
			return false;
		}
		return true;
	}

	@Override
	public UsuarioEntity buscarUsuarioPorCorreo(String correo) {
		return usuarioRepository.findByCorreo(correo);
	}

	@Override
	public void actualizarUsuario(String correo, UsuarioEntity usuarioActualizado) {
		UsuarioEntity usuarioEncontrado = buscarUsuarioPorCorreo(correo);
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
	public void eliminarUsuario(String correo) {
		UsuarioEntity usuarioEncontrado = buscarUsuarioPorCorreo(correo);
		if (usuarioEncontrado == null) {
			throw new RuntimeException("Usuario no encontrado");
		}
		usuarioRepository.delete(usuarioEncontrado);
	}

}
