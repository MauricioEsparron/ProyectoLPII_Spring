package pe.com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.cibertec.model.entity.TipoOperacionEntity;

@Repository
public interface TipoOperacionRepository extends JpaRepository<TipoOperacionEntity, Integer> {

}
