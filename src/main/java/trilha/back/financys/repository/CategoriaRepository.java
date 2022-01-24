package trilha.back.financys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trilha.back.financys.dominio.entities.CategoriaEntity;


@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {



}
