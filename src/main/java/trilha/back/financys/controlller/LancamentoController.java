package trilha.back.financys.controlller;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import trilha.back.financys.entities.Categoria;
import trilha.back.financys.entities.Lancamento;
import trilha.back.financys.repository.LancamentoRepository;
import trilha.back.financys.service.CategoriaService;
import trilha.back.financys.service.LancamentoService;

@RestController
@RequestMapping (path = "/lancamentos")

public class LancamentoController {

	@Autowired
	private LancamentoService lancamentoService;

	@GetMapping
	public ResponseEntity<Object> getLancamento(){
		return ResponseEntity.ok(lancamentoService.listarLancamento());
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Lancamento> validateCategoryById(@PathVariable Long id) {
		return ResponseEntity.ok(lancamentoService.criarLancamento());
	}

	@PostMapping
	public ResponseEntity<Lancamento> criarLancamento(@RequestBody Lancamento lancamento) {
		return lancamentoService.criarLancamento(lancamento);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> lancamentoDeletar(@PathVariable("id") Long id) {
		lancamentoService.lancamentoDeletar(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Object> atualiza(@PathVariable("id") Long id, @RequestBody Lancamento lancamento) {
		lancamentoService.atualizaLancamento(lancamento, id);
		return ResponseEntity.ok(lancamento);

	}



}
