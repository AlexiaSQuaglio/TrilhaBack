package trilha.back.financys.controlller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import trilha.back.financys.dto.CategoriaDTO;
import trilha.back.financys.entities.CategoriaEntity;
import trilha.back.financys.service.CategoriaService;

import java.util.List;

@RestController
@RequestMapping (path = "/categorias")
public class CategoriaController {

     @Autowired
	 private ModelMapper mapper;


	@Autowired
	private CategoriaService categoriaService;


	@GetMapping(value = "/listar")
	@ResponseStatus(HttpStatus.OK)
	public List<CategoriaDTO> getAll() {

		return ResponseEntity.ok().body(categoriaService.getAll()).getBody();
	}

	@GetMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity <CategoriaEntity>findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(categoriaService.findById(id));
	}

	@PostMapping (path = "/criar")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity <CategoriaEntity>criarCategoria(@RequestBody CategoriaEntity categoria) {
		return ResponseEntity.ok().body(categoriaService.criarCategoria(categoria));
	}

	@DeleteMapping(path = "/deletar")
	@ResponseStatus(HttpStatus.OK)
	public void categoriaDeletar(@PathVariable("id") Long id) {
		categoriaService.categoriaDeletar(id);

	}

	@PutMapping(path = "/update")
	@ResponseStatus(HttpStatus.OK)
	public void atualizaCategoria(@PathVariable("id") Long id, @RequestBody CategoriaEntity categoria) {
		categoriaService.atualizaCategoria(categoria, id);

	}
}


