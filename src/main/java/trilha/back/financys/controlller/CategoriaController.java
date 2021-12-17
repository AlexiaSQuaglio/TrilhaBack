package trilha.back.financys.controlller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import trilha.back.financys.entities.Categoria;
import trilha.back.financys.repository.CategoriaRepository;

@RestController
@RequestMapping (path = "/categorias")
public class CategoriaController {

	@Autowired
	CategoriaRepository categoriaRepository;


	@GetMapping
	public List<Categoria> listarCategoria() {
		return categoriaRepository.findAll();
	}

	@GetMapping(path = "/{id}")
	public Optional<Categoria> listaCategoriaId (@PathVariable(value="id") long id){
		return categoriaRepository.findById(id);
	}

    @PostMapping
	public Categoria criarCategoria(@RequestBody Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	@DeleteMapping(path = "/{id}")
	public void deletaCategoria(@PathVariable(value="id") long id) {
		categoriaRepository.deleteById(id);
	}

	@PutMapping(path = "/{id}")
	public Categoria atualizaCategoria(@RequestBody Categoria categoria, @PathVariable(value="id") long id){
		//Pega a categoria pelo id que veio no path e coloca em uma variável
		Categoria categoriaEdita = categoriaRepository.findById(id)
				.orElseThrow();

		// edita a variável que você criou
		categoriaEdita.setName(categoria.getName());
		categoriaEdita.setDescription(categoria.getDescription());

		// salva a variável editada
		return categoriaRepository.save(categoriaEdita);
	}


}
