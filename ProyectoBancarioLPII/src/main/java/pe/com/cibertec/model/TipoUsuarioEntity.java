package pe.com.cibertec.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_tipo_usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoUsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_usuario_id")
    private Integer tipoUsuarioId;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    // Definición de la columna como JSON en la base de datos
    @Column(name = "permisos", columnDefinition = "JSON")
    private String permisos;

    // Relación bidireccional con UsuarioEntity
    @OneToMany(mappedBy = "tipoUsuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UsuarioEntity> usuarios;
}
