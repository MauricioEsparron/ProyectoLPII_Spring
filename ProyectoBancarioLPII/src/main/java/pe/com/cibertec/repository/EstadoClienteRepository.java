package pe.com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.cibertec.model.entity.EstadoClienteEntity;

@Repository
public interface EstadoClienteRepository extends JpaRepository<EstadoClienteEntity, Integer> {

}
