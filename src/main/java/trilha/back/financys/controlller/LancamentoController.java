package trilha.back.financys.controlller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.dominio.entities.LancamentoEntity;
import trilha.back.financys.dto.ChartDTO;
import trilha.back.financys.exception.LancamentoNotFoundException;
import trilha.back.financys.service.LancamentoService;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping (path = "/lancamentos")

public class LancamentoController {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private LancamentoService lancamentoService;


	@GetMapping(value = "/listar")
	@ResponseStatus(HttpStatus.OK)
	public List<LancamentoEntity> getAll() {
		return ResponseEntity.ok().body(lancamentoService.getAll()).getBody();
	}

	@GetMapping(path = "/buscar/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<LancamentoEntity> getId(@PathVariable("id") Long id) {
		return ResponseEntity.ok().body(lancamentoService.getId(id));
	}

	@PostMapping(path = "/salvar")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<LancamentoEntity> salvar(@RequestBody @Valid LancamentoEntity lancamento) {
		return ResponseEntity.ok().body(lancamentoService.salvar(lancamento));
	}

	@DeleteMapping(path = "/deletar/{id}")
	public void delete(@PathVariable("id") Long id) {
		lancamentoService.lancamentoDeletar(id);
	}

	@PutMapping(path = "/update/{id}")
	public void update(@PathVariable("id") Long id, @RequestBody @Valid LancamentoEntity lancamento) {
		lancamentoService.atualizaLancamento(lancamento, id);
	}

	@GetMapping(path = "/calcula/{x}&{y}")
	public ResponseEntity<Integer> calculo(@PathVariable Integer x, @PathVariable Integer y) {
		return ResponseEntity.ok(lancamentoService.calculaMedia(x,y));
	}

	@GetMapping("/dto")
	public ResponseEntity<List<ChartDTO>> listaDTO(){
		return ResponseEntity.ok(lancamentoService.listByCategoria());
	}

	@GetMapping("/filter")
	public ResponseEntity<List<LancamentoEntity>> getLancamentoDependentes(
			@RequestParam(value = "data_lancamento", required = false) String date,
			@RequestParam(value = "amount", required = false) Double amount,
			@RequestParam(value = "paid", required = false) boolean paid)
	throws LancamentoNotFoundException, NullPointerException {
		return new ResponseEntity<>(lancamentoService.getLancamentoDependentes(date,amount,paid), HttpStatus.OK);
	}
}