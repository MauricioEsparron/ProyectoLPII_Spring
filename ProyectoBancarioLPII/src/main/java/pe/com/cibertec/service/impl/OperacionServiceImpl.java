package pe.com.cibertec.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.cibertec.model.OperacionEntity; // Usar el nombre correcto de la entidad
import pe.com.cibertec.repository.OperacionRepository; // Cambiar a OperacionRepository
import pe.com.cibertec.service.OperacionService; // Usar el nombre correcto de la interfaz

@Service
public class OperacionServiceImpl implements OperacionService { // Cambiar a OperacionServiceImpl

    @Autowired
    private OperacionRepository operacionRepository; // Cambiar a OperacionRepository

    @Override
    public List<OperacionEntity> buscarOperaciones() {
        return operacionRepository.findAll(); // Método correcto en el repositorio
    }

    @Override
    public void crearOperacion(OperacionEntity operacion) {
        operacionRepository.save(operacion); // Guardar la operación
    }

    @Override
    public OperacionEntity buscarOperacionPorId(Integer id) {
        return operacionRepository.findById(id).orElse(null); // Buscar operación por ID
    }

    @Override
    public void actualizarOperacion(Integer id, OperacionEntity operacionActualizada) {
        OperacionEntity operacionEncontrada = buscarOperacionPorId(id);
        if (operacionEncontrada == null) {
            throw new RuntimeException("Operación no encontrada");
        }
        try {
            operacionEncontrada.setTipoOperacion(operacionActualizada.getTipoOperacion());
            operacionEncontrada.setMonto(operacionActualizada.getMonto());
            operacionEncontrada.setFecha(operacionActualizada.getFecha());
            operacionEncontrada.setHora(operacionActualizada.getHora());
            operacionRepository.save(operacionEncontrada); // Guardar la operación actualizada
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar: " + e.getMessage());
        }
    }

    @Override
    public void eliminarOperacion(Integer id) {
        OperacionEntity operacionEncontrada = buscarOperacionPorId(id);
        if (operacionEncontrada == null) {
            throw new RuntimeException("Operación no encontrada");
        }
        operacionRepository.delete(operacionEncontrada); // Eliminar la operación
    }
}
