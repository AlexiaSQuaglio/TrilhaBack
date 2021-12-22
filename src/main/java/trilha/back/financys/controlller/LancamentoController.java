package trilha.back.financys.controlller;



import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import trilha.back.financys.entities.LancamentoEntity;
import trilha.back.financys.repository.LancamentoRepository;
import trilha.back.financys.service.LancamentoService;

@RestController
@RequestMapping (path = "/lancamentos")

public class LancamentoController {

	@Autowired
	private LancamentoService lancamentoService;
	@Autowired
	private LancamentoRepository lancamentoRepository;

	@GetMapping(path = "/{lista}")
	public List<LancamentoEntity> listarLancamento() {
		return lancamentoRepository.findAll();
	}


	@GetMapping(path = "/{id}")
	public ResponseEntity findById(@PathVariable Long id) {
		Optional<LancamentoEntity> result = lancamentoRepository.findById(id);
		if (result.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("lancamento não encontrado");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(result);
		}
	}

	@PostMapping(path = "/{id}")
	public ResponseEntity criarLancamento(@RequestBody LancamentoEntity lancamento) {
		return lancamentoService.validateCategoriaById(lancamento.getCategoryId()) ?
				ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lancamento nao encontrado"):
				ResponseEntity.status(HttpStatus.CREATED).body(lancamentoRepository.save(lancamento));
	}


	@DeleteMapping(path = "/{id}")
	public ResponseEntity lacamentoDeletar(@PathVariable("id") Long id) {
		lancamentoRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Lancamento nao encontrado");
	}


	@PutMapping(path = "/{id}")
	public ResponseEntity atualizaLancamento(LancamentoEntity lancamento, Long id) {
		try {
			LancamentoEntity lancamentoEdita = lancamentoRepository.findById(id)
					.orElseThrow();
			lancamentoEdita.setName(lancamento.getName());
			lancamentoEdita.setDescription(lancamento.getDescription());
			lancamentoEdita.setType(lancamento.getType());
			lancamentoEdita.setDate(lancamento.getDate());
			lancamentoEdita.setAmount(lancamento.getAmount());
			lancamentoEdita.setPaid(lancamento.isPaid());
			lancamentoEdita.setCategoryId(lancamento.getCategoryId());
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(lancamentoRepository.save(lancamentoEdita));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Lancamento nao foi encontrado");
		}

	}
}
