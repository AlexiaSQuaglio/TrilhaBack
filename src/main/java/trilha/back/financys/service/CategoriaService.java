package trilha.back.financys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trilha.back.financys.entities.CategoriaEntity;
import trilha.back.financys.repository.CategoriaRepository;

import java.util.ArrayList;


@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;

public long idCategoriabyName(String categoriaName){
    ArrayList<CategoriaEntity> result = categoriaRepository.findByName(categoriaName);
    return result.isEmpty() ? 0 : result.get(0).getId();
}

}
