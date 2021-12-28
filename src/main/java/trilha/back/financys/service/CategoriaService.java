package trilha.back.financys.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import trilha.back.financys.dto.CategoriaDTO;
import trilha.back.financys.entities.CategoriaEntity;
import trilha.back.financys.repository.CategoriaRepository;

import java.util.List;
import java.util.stream.Collectors;


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
    public List<CategoriaDTO> getAll() {
        return   categoriaRepository
                .findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
           }



    public CategoriaEntity findById(Long id) {
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

        public CategoriaEntity criarCategoria(CategoriaEntity categoriaEntity){
             return categoriaRepository.save(categoriaEntity);
        }
    private CategoriaDTO  mapToDto(CategoriaEntity categoria) {
        return mapper.map(categoria,CategoriaDTO.class );
    }
    private CategoriaEntity  mapToEntity(CategoriaDTO dto) {
        return mapper.map(dto,CategoriaEntity.class );
    }

}