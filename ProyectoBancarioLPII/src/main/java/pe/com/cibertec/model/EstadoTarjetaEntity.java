package pe.com.cibertec.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_estado_tarjeta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstadoTarjetaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "estado_tarjeta_id", nullable = false)
	private Integer estadoTarjetaId;

	@Column(name = "descripcion", nullable = false)
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="tarjeta_id", nullable = false)
	private TarjetaEntity tarjeta;
}
