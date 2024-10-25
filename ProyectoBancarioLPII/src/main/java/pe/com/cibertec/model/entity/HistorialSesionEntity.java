package pe.com.cibertec.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_historial_sesion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HistorialSesionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sesion_id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDateTime fechaInicio; // Fecha y hora de inicio de sesión

    @Column(name = "fecha_fin")
    private LocalDateTime fechaFin; // Fecha y hora de cierre de sesión

    @Column(name = "ip_direccion")
    private String ipDireccion; // Dirección IP del usuario

    // Consideraciones adicionales
    // Puedes agregar un método para calcular la duración de la sesión
    public long calcularDuracionSesion() {
        if (fechaFin != null) {
            return java.time.Duration.between(fechaInicio, fechaFin).toMinutes(); // Retorna la duración en minutos
        }
        return 0; // Retorna 0 si no hay fecha de fin
    }
}
