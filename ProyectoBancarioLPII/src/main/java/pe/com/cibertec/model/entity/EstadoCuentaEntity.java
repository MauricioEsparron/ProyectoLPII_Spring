package pe.com.cibertec.model.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_estado_cuenta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstadoCuentaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "estado_cuenta_id", nullable = false)
	private Integer estadoCuentaId;

	@Column(name = "descripcion", nullable = false)
	private String descripcion;

	@OneToMany(mappedBy = "estadoCuenta", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CuentaEntity> cuentas;
}
