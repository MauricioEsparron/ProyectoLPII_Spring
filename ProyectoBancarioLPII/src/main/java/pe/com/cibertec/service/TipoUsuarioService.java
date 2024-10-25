package pe.com.cibertec.service;

import java.util.List;

import pe.com.cibertec.model.entity.TipoUsuarioEntity;

public interface TipoUsuarioService {
    List<TipoUsuarioEntity> buscarTiposUsuario();
    void crearTipoUsuario(TipoUsuarioEntity tipoUsuario);
    TipoUsuarioEntity buscarTipoUsuarioPorId(Integer id);
    void actualizarTipoUsuario(Integer id, TipoUsuarioEntity tipoUsuarioEntity);
    void eliminarTipoUsuario(Integer id);
}
