package pe.com.cibertec.service;

import java.util.List;

import pe.com.cibertec.model.entity.UsuarioEntity;

public interface UsuarioService {
	List<UsuarioEntity> buscarUsuarios();

	void crearUsuario(UsuarioEntity usuarioEntity);

	boolean validarUsuario(UsuarioEntity usuarioEntity);

	void actualizarUsuario(String correo, UsuarioEntity usuarioEntity);

	void eliminarUsuario(String correo);

	UsuarioEntity buscarUsuarioPorCorreo(String correo);
}
