package trilha.back.financys.controlller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import trilha.back.financys.dto.LancamentoDTO;
import trilha.back.financys.entities.LancamentoEntity;
import trilha.back.financys.service.LancamentoService;

@RestController
@RequestMapping (path = "/lancamentos")

public class LancamentoController {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private LancamentoService lancamentoService;


	@GetMapping(value = "/listar")
	@ResponseStatus(HttpStatus.OK)
		public List<LancamentoDTO> getAll() {
			return ResponseEntity.ok().body(lancamentoService.getAll()).getBody();
		}

	@GetMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity <LancamentoEntity>findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(lancamentoService.findById(id));
			}

	@PostMapping (path = "/criar")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<LancamentoEntity>criarLancamento(@RequestBody LancamentoEntity lancamento) {
		return ResponseEntity.ok().body(lancamentoService.criarLancamento(lancamento));
	}

	@DeleteMapping(path = "/deletar")
	public void lancamentoDeletar(@PathVariable("id") Long id) {
		lancamentoService.lancamentoDeletar(id);
	}


	@PutMapping(path = "/update")
	public void atualizaLancamento(@PathVariable("id") Long id, @RequestBody LancamentoEntity lancamento) {
		lancamentoService.atualizaLancamento(lancamento, id);
	}
	@GetMapping ( path = " / dto" )
	public ResponseEntity<List<LancamentoDTO>>listByCategoria(){
		return ResponseEntity.ok(lancamentoService.listByCategoria());
	}

}
