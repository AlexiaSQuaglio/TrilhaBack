package trilha.back.financys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import trilha.back.financys.entities.LancamentoEntity;
import trilha.back.financys.repository.CategoriaRepository;
import trilha.back.financys.repository.LancamentoRepository;

import java.util.List;


@Service
public class LancamentoService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public boolean validateCategoriaById (Long idCategoria){
        return categoriaRepository.existsById(idCategoria);
    }

}









