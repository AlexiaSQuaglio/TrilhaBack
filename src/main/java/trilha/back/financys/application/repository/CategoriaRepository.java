package trilha.back.financys.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trilha.back.financys.application.entities.CategoriaEntity;


@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {



}
