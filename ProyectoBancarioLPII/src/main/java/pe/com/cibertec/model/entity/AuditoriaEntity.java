package pe.com.cibertec.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_auditoria")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuditoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer auditoria_id;

    @Column(name = "accion", nullable = false)
    private String accion; // ej. "crear", "actualizar", "eliminar"

    @Column(name = "tabla_afectada", nullable = false)
    private String tablaAfectada;

    @Column(name = "registro_id", nullable = false)
    private Integer registroId; // ID del registro afectado

    @Column(name = "fecha", nullable = false)
    private String fecha; // Considera usar LocalDateTime

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario;
}
