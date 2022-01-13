package trilha.back.financys.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import trilha.back.financys.dto.CategoriaDTO;
import trilha.back.financys.dominio.entities.CategoriaEntity;
import trilha.back.financys.repository.CategoriaRepository;

import java.util.List;
import java.util.Optional;


@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    ModelMapper mapper;

    public CategoriaService(CategoriaRepository categoriaRepository, ModelMapper mapper) {
        this.categoriaRepository = categoriaRepository;
        this.mapper = mapper;
    }
    public List<CategoriaEntity> getAll() {
        return ResponseEntity.ok().body(categoriaRepository.findAll()).getBody();
    }

    public CategoriaEntity getId(Long id) {
        Optional<CategoriaEntity> requestedCategoria = categoriaRepository.findById(id);
        if (requestedCategoria.isPresent()){
        }else{
            System.out.println("id nao encontrado");
        }
        return categoriaRepository.getById(id);
    }

    public void atualizaCategoria(CategoriaEntity categoria, Long id) {

            CategoriaEntity categoriaEdita = categoriaRepository.findById(id)
                    .orElseThrow();
            categoriaEdita.setName(categoria.getName());
            categoriaEdita.setDescription(categoria.getDescription());
            ResponseEntity.ok().body(categoriaRepository.save(categoriaEdita));

    }
        public void categoriaDeletar(Long id){
             categoriaRepository.deleteById(id);
        }

        public CategoriaEntity salvar(CategoriaEntity categoriaEntity){
             return categoriaRepository.save(categoriaEntity);
        }


    private CategoriaEntity  mapToDto(CategoriaDTO dto) {
        return mapper.map(dto,CategoriaEntity.class);
    }
    private CategoriaDTO  mapToEntity(CategoriaEntity entity) {
        return mapper.map(entity,CategoriaDTO.class);
    }

}