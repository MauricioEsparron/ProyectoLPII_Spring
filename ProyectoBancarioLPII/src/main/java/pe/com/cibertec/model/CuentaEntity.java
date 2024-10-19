package pe.com.cibertec.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_cuenta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CuentaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cuenta_id", nullable = false)
	private Integer cuentaId;

	@Column(name = "numero_cuenta", nullable = false)
	private String numeroCuenta;

	@Column(name = "saldo", nullable = false)
	private Double saldo;

	@Column(name = "fecha_apertura", nullable = false)
	private String fechaApertura;

	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private ClienteEntity cliente;

	@ManyToOne
	@JoinColumn(name = "tipo_cuenta_id", nullable = false)
	private TipoCuentaEntity tipoCuenta;

	@Column(name = "estado")
	private String estado;
}
