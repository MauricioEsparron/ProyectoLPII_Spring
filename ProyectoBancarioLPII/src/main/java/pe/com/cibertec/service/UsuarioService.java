package pe.com.cibertec.service;

import java.util.List;
import pe.com.cibertec.model.UsuarioEntity;

public interface UsuarioService {
	List<UsuarioEntity> buscarUsuarios();

	void crearUsuario(UsuarioEntity usuario);

	UsuarioEntity buscarUsuarioPorId(Integer id);

	void actualizarUsuario(Integer id, UsuarioEntity usuarioEntity);

	void eliminarUsuario(Integer id);
}
