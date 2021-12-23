package trilha.back.financys.controlller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.entities.CategoriaEntity;
import trilha.back.financys.service.CategoriaService;

import java.util.List;

@RestController
@RequestMapping (path = "/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;


	@GetMapping(value = "/listar")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<CategoriaEntity>> getAll() {
		return ResponseEntity.ok().body(categoriaService.getAll());
	}

	@GetMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity <CategoriaEntity>findById(@PathVariable Long id) {
		CategoriaEntity teste = categoriaService.findById(id);
		if (teste != null)
			return ResponseEntity.ok(teste);
		return ResponseEntity.noContent().build();
	}

	@PostMapping (path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity <CategoriaEntity>criarCategoria(@RequestBody CategoriaEntity categoria) {
		return categoriaService.criarCategoria(categoria);
	}

	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<CategoriaEntity> categoriaDeletar(@PathVariable("id") Long id) {
		categoriaService.categoriaDeletar(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity <CategoriaEntity>atualizaCategoria(@PathVariable("id") Long id, @RequestBody CategoriaEntity categoria) {
		categoriaService.atualizaCategoria(categoria,id);
		return ResponseEntity.ok(categoria);

	}
}


