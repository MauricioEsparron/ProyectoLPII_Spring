package pe.com.cibertec.service;

import java.util.List;

import pe.com.cibertec.model.entity.HistorialSesionEntity;

public interface HistorialSesionService {
    List<HistorialSesionEntity> buscarHistorialSesiones();
    void crearHistorialSesion(HistorialSesionEntity historialSesion);
    HistorialSesionEntity buscarHistorialSesionPorId(Integer id);
    void eliminarHistorialSesion(Integer id);
}
