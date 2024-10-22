package pe.com.cibertec.model;

import java.time.LocalDate;

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

	@Column(name = "apellidos", nullable = false)
	private String apellidos;

	@Column(name = "edad")
	private Integer edad;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "telefono", length = 9)
	private String telefono;

	@Column(name = "fecha_nacimiento")
	private String fechaNacimiento;

	@Column(name = "dni", length = 8)
	private String dni;

	@Column(name = "correo")
	private String correo;

	@Column(name = "fecha_afiliacion")
	private LocalDate fechaAfiliacion;

	@ManyToOne
	@JoinColumn(name = "estado_cliente", nullable = false)
	private EstadoClienteEntity estado;
}
