package trilha.back.financys.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import trilha.back.financys.dto.ChartDTO;
import trilha.back.financys.dto.LancamentoDTO;
import trilha.back.financys.entities.CategoriaEntity;
import trilha.back.financys.entities.LancamentoEntity;
import trilha.back.financys.exception.DivisaoPorZeroException;
import trilha.back.financys.repository.CategoriaRepository;
import trilha.back.financys.repository.LancamentoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    ModelMapper mapper;


    public LancamentoService(LancamentoRepository lancamentoRepository, ModelMapper mapper) {
        this.lancamentoRepository = lancamentoRepository;
        this.mapper = mapper;
    }

    public List<LancamentoEntity> getAll() {
        return ResponseEntity.ok().body(lancamentoRepository.findAll()).getBody();
    }

    public LancamentoEntity getId(Long id) {
       Optional<LancamentoEntity> requestedLancamento = lancamentoRepository.findById(id);
       if (requestedLancamento.isPresent()){
           lancamentoRepository.getById(id);
       }else{
           System.out.println("id nao encontrado");
       }
       return lancamentoRepository.getById(id);
    }

    public void atualizaLancamento(LancamentoEntity lancamento, Long id) {

        LancamentoEntity lancamentoEdita = lancamentoRepository.findById(id)
                .orElseThrow();
        lancamentoEdita.setName(lancamento.getName());
        lancamentoEdita.setDescription(lancamento.getDescription());
        lancamentoEdita.setAmount(lancamento.getAmount());
        lancamentoEdita.setPaid(lancamento.isPaid());
        lancamentoEdita.setType(lancamento.getType());
        lancamentoEdita.setDate(lancamento.getDate());
        lancamentoEdita.setCategoryId(lancamentoEdita.getCategoryId());
        ResponseEntity.ok().body(lancamentoRepository.save(lancamentoEdita));
    }

    public void lancamentoDeletar(Long id) {
        lancamentoRepository.deleteById(id);
    }

    public LancamentoEntity salvar(LancamentoEntity lancamentoEntity) {
        return lancamentoRepository.save(lancamentoEntity);
    }


    private LancamentoEntity mapToDto(LancamentoDTO dto) {
        return mapper.map(dto,LancamentoEntity.class );
    }

    private LancamentoDTO mapToEntity(LancamentoEntity entity) {
        return mapper.map(entity,LancamentoDTO.class );
    }

public List<ChartDTO> grafico(){
        List<ChartDTO> lists = new ArrayList<>();
        categoriaRepository.findAll().stream()
                .forEach(categoria -> {
                    ChartDTO chartDTO = new ChartDTO();
                    chartDTO.setName(categoria.getName());
                    chartDTO.setTotal(0.0);
                    categoria.getLancamento().forEach(lancamentoEntity -> {
                        chartDTO.setTotal(lancamentoEntity.getAmount() + chartDTO.getTotal());
                    });
                    lists.add(chartDTO);
                });
        return lists;
}


   public Integer calculaMedia(Integer x, Integer y){
      try {
          return (x/y);
      }
       catch (ArithmeticException e){
          throw new DivisaoPorZeroException("Erro ao dividir por 0");
       }
    }



}









