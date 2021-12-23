package trilha.back.financys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import trilha.back.financys.entities.CategoriaEntity;
import trilha.back.financys.repository.CategoriaRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;

    public List<CategoriaEntity> getAll() {
        return new ArrayList<>(categoriaRepository.findAll());
    }

    public  CategoriaEntity findById(Long id) {
        Optional<CategoriaEntity> result = categoriaRepository.findById(id);
        if (result.isPresent())
            return result.get();
       return null;
    }

    public CategoriaEntity atualizaCategoria(CategoriaEntity categoria, Long id) {
        try {
            CategoriaEntity categoriaEdita = categoriaRepository.findById(id)
                    .orElseThrow();
            categoriaEdita.setName(categoria.getName());
            categoriaEdita.setDescription(categoria.getDescription());
            return categoriaRepository.save(categoriaEdita);
        } catch (Exception e) {
            return null;
        }
    }
        public CategoriaEntity categoriaDeletar(Long id){
        CategoriaEntity categoria = categoriaRepository.getById(id);
        if (id != null)
        categoriaRepository.deleteById(id);
        return null;
        }

        public ResponseEntity<CategoriaEntity>criarCategoria(CategoriaEntity categoriaEntity){
        if (categoriaEntity != null)
        categoriaRepository.save(categoriaEntity);
        return null;
        }

}