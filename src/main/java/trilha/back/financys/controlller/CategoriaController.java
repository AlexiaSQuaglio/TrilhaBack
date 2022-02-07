package trilha.back.financys.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.dominio.entities.CategoriaEntity;
import trilha.back.financys.service.CategoriaService;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping (path = "/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<CategoriaEntity> getAll() {
		return ResponseEntity.ok().body(categoriaService.getAll()).getBody();
	}

	@GetMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity <CategoriaEntity>findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(categoriaService.getId(id));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity <CategoriaEntity>salvar(@RequestBody @Valid CategoriaEntity categoria) {
		return ResponseEntity.ok().body(categoriaService.salvar(categoria));
	}

	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) {
		categoriaService.categoriaDeletar(id);

	}

	@PutMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable("id") Long id, @RequestBody @Valid CategoriaEntity categoria) {
		categoriaService.atualizaCategoria(categoria, id);

	}
}


