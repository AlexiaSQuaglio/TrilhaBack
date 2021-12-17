package trilha.back.financys.controlller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import trilha.back.financys.entities.Categoria;
import trilha.back.financys.entities.Lancamento;
import trilha.back.financys.repository.LancamentoRepository;

@RestController
@RequestMapping (path = "/lancamentos")

public class LancamentoController {

	@Autowired
	LancamentoRepository lancamentoRepository;


	@GetMapping
	public List<Lancamento> listarLancamentos() {
		return lancamentoRepository.findAll();
	}

	@GetMapping(path = "/{id}")
	public Optional<Lancamento> lista (@PathVariable(value="id") long id){
		return lancamentoRepository.findById(id);
	}

	@PostMapping
	public Lancamento criarLancamento(@RequestBody Lancamento lancamento) {
		return lancamentoRepository.save(lancamento);
	}

	@DeleteMapping(path = "/{id}")
	public void detetaLancamento(@PathVariable(value="id") long id){
		lancamentoRepository.deleteById(id);
	}

	@PutMapping(path = "/{id}")
	public Lancamento atualizaLancamento(@RequestBody Lancamento lancamento, @PathVariable(value="id") long id){
		Lancamento lancamentoEdita = lancamentoRepository.findById(id)
				.orElseThrow();
		lancamentoEdita.setName(lancamento.getName());
		lancamentoEdita.setDescription(lancamento.getDescription());
		lancamentoEdita.setType(lancamento.getType());
		lancamentoEdita.setDate(lancamento.getDate());
		lancamentoEdita.setAmount(lancamentoEdita.getAmount());
		lancamentoEdita.setCategoryId(lancamento.getCategoryId());
		lancamentoEdita.setPaid(lancamento.isPaid());
		return lancamentoRepository.save(lancamentoEdita);
	}



}
