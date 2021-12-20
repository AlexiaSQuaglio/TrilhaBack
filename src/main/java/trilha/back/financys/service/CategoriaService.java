package trilha.back.financys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import trilha.back.financys.entities.Categoria;
import trilha.back.financys.exceptions.CategoriaNotFound;
import trilha.back.financys.repository.CategoriaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;


    public List<Categoria> listarCategoria() {
        return categoriaRepository.findAll();
    }

    public Categoria getCategoriaById(long id) {
        Optional<Categoria> listaCategoriaId = categoriaRepository.findById(id);
            if (listaCategoriaId.isEmpty()) {
                throw new CategoriaNotFound(String.format("Categoria nao encontrada", id));
            }
            return listaCategoriaId.get();
    }

    public ResponseEntity<Categoria> criarCategoria( Categoria categoria) {
        categoriaRepository.save(categoria);
        return ResponseEntity.ok().body(categoria);
    }

    public void deletaCategoria(@PathVariable(value = "id") long id) {
        categoriaRepository.deleteById(id);
    }
    public Categoria atualizaCategoria(@RequestBody Categoria categoria, @PathVariable(value="id") long id){
        Categoria categoriaEdita = categoriaRepository.findById(id)
                .orElseThrow();
        categoriaEdita.setName(categoria.getName());
        categoriaEdita.setDescription(categoria.getDescription());
        return categoriaRepository.save(categoriaEdita);
    }
}
