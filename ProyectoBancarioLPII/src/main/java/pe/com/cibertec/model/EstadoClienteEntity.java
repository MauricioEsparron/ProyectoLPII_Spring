package pe.com.cibertec.model;

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
@Table(name = "tb_estado_cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstadoClienteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "estado_cliente_id", nullable = false)
	private Integer estadoClienteId;

	@Column(name = "descripcion", nullable = false)
	private String descripcion;

	@OneToMany(mappedBy = "estado", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ClienteEntity> clientes;
}
