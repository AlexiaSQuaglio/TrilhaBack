package trilha.back.financys.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import trilha.back.financys.entities.LancamentoEntity;

public interface LancamentoRepository extends JpaRepository<LancamentoEntity, Long> {

}
