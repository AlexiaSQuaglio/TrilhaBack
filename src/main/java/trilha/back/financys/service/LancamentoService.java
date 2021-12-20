package trilha.back.financys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import trilha.back.financys.entities.Categoria;
import trilha.back.financys.entities.Lancamento;
import trilha.back.financys.repository.CategoriaRepository;
import trilha.back.financys.repository.LancamentoRepository;

import java.util.List;


@Service
public class LancamentoService {
    @Autowired
    private LancamentoRepository lancamentoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Lancamento> listarLancamento() {
        return lancamentoRepository.findAll();
    }

    private boolean validateEntryById(Long categoryid) {
        return true;
    }

    public ResponseEntity<Lancamento> criarLancamento(Lancamento lancamento) {
        if (validateEntryById(lancamento.getCategoryId())) {
            return ResponseEntity.ok(lancamentoRepository.save(lancamento));
        }
        System.out.println("Não existe categoria para este lancamento");
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<Lancamento> gerarlancamento(Lancamento lancamento) {
        lancamentoRepository.save(lancamento);
        return ResponseEntity.ok().body(lancamento);
    }

    public void lancamentoDeletar(long id) {
        lancamentoRepository.deleteById(id);
    }

    public Lancamento atualizaLancamento(Lancamento lancamento, long id) {
        Lancamento lancamentoEdita = lancamentoRepository.findById(id)
                .orElseThrow();
        lancamentoEdita.setName(lancamento.getName());
        lancamentoEdita.setDescription(lancamento.getDescription());
        lancamentoEdita.setType(lancamento.getType());
        lancamentoEdita.setDate(lancamento.getDate());
        lancamentoEdita.setAmount(lancamento.getAmount());
        lancamentoEdita.setPaid(lancamento.isPaid());
        lancamentoEdita.setCategoryId(lancamento.getCategoryId());
        return lancamentoRepository.save(lancamentoEdita);
    }

}









