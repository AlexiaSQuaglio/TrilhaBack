package trilha.back.financys.controlller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import trilha.back.financys.entities.Lancamento;

@RestController
@RequestMapping (path = "/lancamentos")

public class LancamentoController<lista> {
	private List<Lancamento> lista = new ArrayList<Lancamento>();


	@GetMapping
	public List<Lancamento> listarLancamentos() {
		Collections.sort(lista);
		return lista;
	}  
	
	@PostMapping
	public int criarLancamento(@RequestBody Lancamento lancamento) {
		lista.add(lancamento);
		return lista.size();
	}


}
