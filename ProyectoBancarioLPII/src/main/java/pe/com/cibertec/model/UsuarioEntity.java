package pe.com.cibertec.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity {

	@Id
	@Column(name = "correo", nullable = false, unique = true)
	private String correo;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "url_imagen")
	private String urlImagen;

	@ManyToOne
	@JoinColumn(name = "tipo_usuario_id", nullable = false)
	private TipoUsuarioEntity tipoUsuario;
}
