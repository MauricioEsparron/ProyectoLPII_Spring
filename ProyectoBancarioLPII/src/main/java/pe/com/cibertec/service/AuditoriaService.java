package pe.com.cibertec.service;

import java.util.List;
import pe.com.cibertec.model.AuditoriaEntity;

public interface AuditoriaService {
    List<AuditoriaEntity> buscarAuditorias();
    void crearAuditoria(AuditoriaEntity auditoria);
    AuditoriaEntity buscarAuditoriaPorId(Integer id);
    void eliminarAuditoria(Integer id);
}
