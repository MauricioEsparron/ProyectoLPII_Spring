package pe.com.cibertec.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.cibertec.model.entity.AuditoriaEntity;
import pe.com.cibertec.repository.AuditoriaRepository;
import pe.com.cibertec.service.AuditoriaService;

@Service
public class AuditoriaServiceImpl implements AuditoriaService {

    @Autowired
    private AuditoriaRepository auditoriaRepository;

    @Override
    public List<AuditoriaEntity> buscarAuditorias() {
        return auditoriaRepository.findAll();
    }

    @Override
    public void crearAuditoria(AuditoriaEntity auditoria) {
        auditoriaRepository.save(auditoria);
    }

    @Override
    public AuditoriaEntity buscarAuditoriaPorId(Integer id) {
        return auditoriaRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarAuditoria(Integer id) {
        AuditoriaEntity auditoriaEncontrada = buscarAuditoriaPorId(id);
        if (auditoriaEncontrada == null) {
            throw new RuntimeException("Auditoría no encontrada");
        }
        auditoriaRepository.delete(auditoriaEncontrada);
    }
}
