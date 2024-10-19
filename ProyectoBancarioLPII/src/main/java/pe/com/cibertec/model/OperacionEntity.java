package pe.com.cibertec.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_operacion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OperacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer operacion_id;

    @Column(name = "tipo_operacion", nullable = false)
    private String tipoOperacion; // ej. "depósito", "retiro", "transferencia"

    @Column(name = "monto", nullable = false)
    private Double monto;

    @Column(name = "fecha", nullable = false)
    private String fecha; // Considera usar LocalDate

    @Column(name = "hora", nullable = false)
    private String hora; // Considera usar LocalTime

    @ManyToOne
    @JoinColumn(name = "cuenta_origen_id", nullable = true)
    private CuentaEntity cuentaOrigen;

    @ManyToOne
    @JoinColumn(name = "cuenta_destino_id", nullable = true)
    private CuentaEntity cuentaDestino;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario;

    @Column(name = "estado")
    private String estado; // ej. "completada", "pendiente", "fallida"
}
