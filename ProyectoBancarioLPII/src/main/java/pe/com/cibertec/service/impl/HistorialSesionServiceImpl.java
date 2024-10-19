package pe.com.cibertec.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.cibertec.model.HistorialSesionEntity;
import pe.com.cibertec.repository.HistorialSesionRepository;
import pe.com.cibertec.service.HistorialSesionService;

@Service
public class HistorialSesionServiceImpl implements HistorialSesionService {

    @Autowired
    private HistorialSesionRepository historialSesionRepository;

    @Override
    public List<HistorialSesionEntity> buscarHistorialSesiones() {
        return historialSesionRepository.findAll();
    }

    @Override
    public void crearHistorialSesion(HistorialSesionEntity historialSesion) {
        historialSesionRepository.save(historialSesion);
    }

    @Override
    public HistorialSesionEntity buscarHistorialSesionPorId(Integer id) {
        return historialSesionRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarHistorialSesion(Integer id) {
        HistorialSesionEntity historialSesionEncontrado = buscarHistorialSesionPorId(id);
        if (historialSesionEncontrado == null) {
            throw new RuntimeException("Historial de sesión no encontrado");
        }
        historialSesionRepository.delete(historialSesionEncontrado);
    }
}
