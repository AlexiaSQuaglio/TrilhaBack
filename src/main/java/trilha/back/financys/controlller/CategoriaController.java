package trilha.back.financys.controlller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import trilha.back.financys.entities.Categoria;
import trilha.back.financys.repository.CategoriaRepository;
import trilha.back.financys.service.CategoriaService;

@RestController
@RequestMapping (path = "/categorias")
public class CategoriaController {

	@Autowired
	CategoriaRepository categoriaRepository;

	@Autowired
	CategoriaService categoriaService;


	@GetMapping
	public ResponseEntity<Object> getCategoria() {
		return ResponseEntity.ok(categoriaService.listarCategoria());
	}


	@GetMapping(path = "/{id}")
	public Optional<Categoria> listaCategoriaId (@PathVariable(value="id") long id){
		return categoriaRepository.findById(id);
	}

    @PostMapping
	public ResponseEntity<Categoria> criarCategoria(@RequestBody Categoria categoria) {
		return categoriaService.criarCategoria(categoria);
	}


	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> categoriaDeletar(@PathVariable("id") Long id) {
		categoriaService.deletaCategoria(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Object> atualiza(@PathVariable("id") Long id, @RequestBody Categoria categoria) {
		categoriaService.atualizaCategoria(categoria, id);
		return ResponseEntity.ok(categoria);

	}

	}


}
