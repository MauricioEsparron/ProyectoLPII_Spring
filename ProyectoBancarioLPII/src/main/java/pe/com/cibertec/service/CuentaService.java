package pe.com.cibertec.service;

import java.util.List;
import pe.com.cibertec.model.CuentaEntity;

public interface CuentaService {
    List<CuentaEntity> buscarCuentas();
    void crearCuenta(CuentaEntity cuenta);
    CuentaEntity buscarCuentaPorId(Integer id);
    void actualizarCuenta(Integer id, CuentaEntity cuentaEntity);
    void eliminarCuenta(Integer id);
}
