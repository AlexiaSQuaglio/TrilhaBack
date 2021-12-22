package trilha.back.financys.controlller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.entities.CategoriaEntity;
import trilha.back.financys.repository.CategoriaRepository;
import trilha.back.financys.service.CategoriaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (path = "/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private CategoriaService categoriaService;


	@GetMapping
	public ResponseEntity findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.findAll());
	}


	@GetMapping(path = "/{id}")
	public ResponseEntity findById(@PathVariable Long id) {
		Optional<CategoriaEntity> result = categoriaRepository.findById(id);
		if (result.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(result);
		}
	}

	@PostMapping
	public ResponseEntity criarCategoria(@RequestBody CategoriaEntity categoria) {
		return categoriaService.idCategoriabyName(categoria.getName()) > 0 ?
				ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria nao encontrada"):
				ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
	}


	@DeleteMapping(path = "/{id}")
	public ResponseEntity categoriaDeletar(@PathVariable("id") Long id) {
		categoriaRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Categoria nao encontrada");
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity atualizaCategoria(CategoriaEntity categoria, Long id) {
		try {
			CategoriaEntity categoriaEdita = categoriaRepository.findById(id)
					.orElseThrow();
			categoriaEdita.setName(categoria.getName());
			categoriaEdita.setDescription(categoria.getDescription());
			return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.save(categoriaEdita));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Categoria nao foi encontrada");
		}

	}
}


