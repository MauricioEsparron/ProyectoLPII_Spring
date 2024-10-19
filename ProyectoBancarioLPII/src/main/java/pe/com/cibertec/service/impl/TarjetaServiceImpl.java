package pe.com.cibertec.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.cibertec.model.TarjetaEntity;
import pe.com.cibertec.repository.TarjetaRepository;
import pe.com.cibertec.service.TarjetaService;

@Service
public class TarjetaServiceImpl implements TarjetaService {

    @Autowired
    private TarjetaRepository tarjetaRepository;

    @Override
    public List<TarjetaEntity> buscarTarjetas() {
        return tarjetaRepository.findAll();
    }

    @Override
    public void crearTarjeta(TarjetaEntity tarjeta) {
        tarjetaRepository.save(tarjeta);
    }

    @Override
    public TarjetaEntity buscarTarjetaPorId(Integer id) {
        return tarjetaRepository.findById(id).orElse(null);
    }

    @Override
    public void actualizarTarjeta(Integer id, TarjetaEntity tarjetaActualizada) {
        TarjetaEntity tarjetaEncontrada = buscarTarjetaPorId(id);
        if (tarjetaEncontrada == null) {
            throw new RuntimeException("Tarjeta no encontrada");
        }
        try {
            tarjetaEncontrada.setNumeroTarjeta(tarjetaActualizada.getNumeroTarjeta());
            tarjetaEncontrada.setFechaVencimiento(tarjetaActualizada.getFechaVencimiento());
            tarjetaEncontrada.setCvv(tarjetaActualizada.getCvv());
            tarjetaRepository.save(tarjetaEncontrada);
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar");
        }
    }

    @Override
    public void eliminarTarjeta(Integer id) {
        TarjetaEntity tarjetaEncontrada = buscarTarjetaPorId(id);
        if (tarjetaEncontrada == null) {
            throw new RuntimeException("Tarjeta no encontrada");
        }
        tarjetaRepository.delete(tarjetaEncontrada);
    }
}
