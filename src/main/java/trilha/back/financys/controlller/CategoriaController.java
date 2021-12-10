package trilha.back.financys.controlller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import trilha.back.financys.entities.Categoria;

@RestController
@RequestMapping (path = "/categorias")
public class CategoriaController {
	
	private List<Categoria> lista = new ArrayList<Categoria>();
	
	@GetMapping
	public List<Categoria> listarCategoria() {
		return lista;
	}  
	
	@PostMapping
	public int criarCategoria(@RequestBody Categoria categoria) {
		lista.add(categoria);
		
		return lista.size();
	} 
	
	
	
}
