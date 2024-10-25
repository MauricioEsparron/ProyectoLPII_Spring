package pe.com.cibertec.model.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_tarjeta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TarjetaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tarjeta_id")
	private Integer tarjetaId;

	@Column(name = "numero_tarjeta", nullable = false)
	private String numeroTarjeta;

	@Column(name = "fecha_activacion", nullable = false)
	private LocalDate fechaActivacion;

	@Column(name = "fecha_vencimiento", nullable = false)
	private LocalDate fechaVencimiento;

	@Column(name = "cvv", nullable = false)
	private String cvv;

	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private ClienteEntity cliente;

	@ManyToOne
	@JoinColumn(name = "tipo_tarjeta_id", nullable = false)
	private TipoTarjetaEntity tipoTarjeta;

	@Column(name = "estado_tarjeta")
	private String estadoTajeta;
}
