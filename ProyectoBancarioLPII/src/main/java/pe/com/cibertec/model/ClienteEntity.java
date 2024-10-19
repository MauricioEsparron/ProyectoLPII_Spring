package pe.com.cibertec.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cliente_id")
	private Integer clienteId;

	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private UsuarioEntity usuario;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "edad")
	private Integer edad;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "fecha_nacimiento")
	private String fechaNacimiento; // Considera usar LocalDate

	@Column(name = "documento_identidad")
	private String documentoIdentidad;

	@Column(name = "fecha_creacion")
	private String fechaCreacion; // Considera usar LocalDateTime

	@Column(name = "estado")
	private String estado; // "activo", "inactivo"
}
