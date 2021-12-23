package trilha.back.financys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import trilha.back.financys.entities.LancamentoEntity;
import trilha.back.financys.repository.LancamentoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class LancamentoService {

    @Autowired

    private LancamentoRepository lancamentoRepository;


    public List<LancamentoEntity> getAll() {
        return new ArrayList<>(lancamentoRepository.findAll());
    }

    public LancamentoEntity findById(Long id) {
        Optional<LancamentoEntity> result = lancamentoRepository.findById(id);
        if (result.isPresent())
            return result.get();
        return null;
    }

    public LancamentoEntity atualizaLancamento(LancamentoEntity lancamento, Long id) {
        try {
            LancamentoEntity lancamentoEdita = lancamentoRepository.findById(id)
                    .orElseThrow();
            lancamentoEdita.setName(lancamento.getName());
            lancamentoEdita.setDescription(lancamento.getDescription());
            lancamentoEdita.setAmount(lancamento.getAmount());
            lancamentoEdita.setPaid(lancamento.isPaid());
            lancamentoEdita.setType(lancamento.getType());
            lancamentoEdita.setDate(lancamento.getDate());
            lancamentoEdita.setCategoryId(lancamentoEdita.getCategoryId());
            return lancamentoRepository.save(lancamentoEdita);
        } catch (Exception e) {
            return null;
        }
    }
    public LancamentoEntity lancamentoDeletar(Long id){
        if (id != null)
            lancamentoRepository.deleteById(id);
        return null;
    }
    public ResponseEntity<LancamentoEntity>criarLancamento(LancamentoEntity lancamentoEntity){
        lancamentoRepository.save(lancamentoEntity);
        return ResponseEntity.ok().body(lancamentoEntity);
    }

}









