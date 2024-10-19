package pe.com.cibertec.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_tipo_cuenta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoCuentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_cuenta_id")
    private Integer tipoCuentaId;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "interes_anual")
    private Double interesAnual;

    @Column(name = "comision")
    private Double comision;
    
    @OneToMany(mappedBy = "tipoCuenta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CuentaEntity> cuentas;
}
