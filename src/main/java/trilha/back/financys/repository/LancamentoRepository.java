package trilha.back.financys.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import trilha.back.financys.entities.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
}
