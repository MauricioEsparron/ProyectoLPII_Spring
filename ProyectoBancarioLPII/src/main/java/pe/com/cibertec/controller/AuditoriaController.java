package pe.com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.cibertec.model.AuditoriaEntity;
import pe.com.cibertec.service.AuditoriaService;

@Controller
@RequestMapping("/auditorias")
public class AuditoriaController {

    @Autowired
    private AuditoriaService auditoriaService;

    // Listar todas las auditorías
    @GetMapping("/")
    public String listarAuditorias(Model model) {
        List<AuditoriaEntity> listaAuditorias = auditoriaService.buscarAuditorias();
        model.addAttribute("lista_auditorias", listaAuditorias);
        return "listar_auditorias"; // Vista que mostrará la lista de auditorías
    }

    // Detalle de una auditoría específica
    @GetMapping("/auditoria/{id}")
    public String verDetalleAuditoria(Model model, @PathVariable("id") Integer id) {
        AuditoriaEntity auditoria = auditoriaService.buscarAuditoriaPorId(id);
        model.addAttribute("auditoria", auditoria);
        return "detalle_auditoria"; // Vista que mostrará los detalles de la auditoría
    }
}
