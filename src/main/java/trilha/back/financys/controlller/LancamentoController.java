package trilha.back.financys.controlller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import trilha.back.financys.entities.CategoriaEntity;
import trilha.back.financys.entities.LancamentoEntity;
import trilha.back.financys.service.LancamentoService;

@RestController
@RequestMapping (path = "/lancamentos")

public class LancamentoController {

	@Autowired
	private LancamentoService lancamentoService;


	@GetMapping(value = "/listar")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<LancamentoEntity>> getAll() {
		return ResponseEntity.ok().body(lancamentoService.getAll());
	}

	@GetMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity <LancamentoEntity>findById(@PathVariable Long id) {
		LancamentoEntity teste = lancamentoService.findById(id);
		if (teste != null)
			return ResponseEntity.ok(teste);
		return ResponseEntity.noContent().build();
	}

	@PostMapping (path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<LancamentoEntity>criarLancamento(@RequestBody LancamentoEntity lancamento) {
		return lancamentoService.criarLancamento(lancamento);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<LancamentoEntity> lancamentoDeletar(@PathVariable("id") Long id) {
		LancamentoEntity delete = lancamentoService.lancamentoDeletar(id);
		if (delete != null)
			return ResponseEntity.ok(delete);
		return ResponseEntity.noContent().build();
	}


	@PutMapping(path = "/{id}")
	public ResponseEntity <LancamentoEntity>atualizaLancamento(@PathVariable("id") Long id, @RequestBody LancamentoEntity lancamento) {
		lancamentoService.atualizaLancamento(lancamento,id);
		return ResponseEntity.ok(lancamento);
	}
}
