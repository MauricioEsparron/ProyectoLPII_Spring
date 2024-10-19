package pe.com.cibertec.service;

import java.util.List;
import pe.com.cibertec.model.TipoTarjetaEntity;

public interface TipoTarjetaService {
    List<TipoTarjetaEntity> buscarTiposTarjeta();
    void crearTipoTarjeta(TipoTarjetaEntity tipoTarjeta);
    TipoTarjetaEntity buscarTipoTarjetaPorId(Integer id);
    void actualizarTipoTarjeta(Integer id, TipoTarjetaEntity tipoTarjetaEntity);
    void eliminarTipoTarjeta(Integer id);
}
