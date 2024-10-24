package pe.com.cibertec.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import pe.com.cibertec.model.UsuarioEntity;

public interface UsuarioService {
	List<UsuarioEntity> buscarUsuarios();

	void crearUsuario(UsuarioEntity usuarioEntity, MultipartFile foto);

	boolean validarUsuario(UsuarioEntity usuarioEntity);

	void actualizarUsuario(String correo, UsuarioEntity usuarioEntity);

	void eliminarUsuario(String correo);

	UsuarioEntity buscarUsuarioPorCorreo(String correo);
}
