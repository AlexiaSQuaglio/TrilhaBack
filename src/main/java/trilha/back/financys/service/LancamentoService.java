package trilha.back.financys.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import trilha.back.financys.dominio.entities.CategoriaEntity;
import trilha.back.financys.dominio.entities.LancamentoEntity;
import trilha.back.financys.dto.ChartDTO;
import trilha.back.financys.dto.LancamentoDTO;
import trilha.back.financys.exception.DivisaoPorZeroException;
import trilha.back.financys.exception.LancamentoNotFoundException;
import trilha.back.financys.exception.ObjectNotFoundException;
import trilha.back.financys.repository.CategoriaRepository;
import trilha.back.financys.repository.LancamentoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


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
        lancamentoEdita.setPaid(lancamento.getPaid());
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

    public List<ChartDTO> listByCategoria() {
        List<CategoriaEntity> categoria = new ArrayList<CategoriaEntity>();
        categoria = categoriaRepository.findAll();
        List<ChartDTO> chartDTO = new ArrayList<ChartDTO>();

        for (CategoriaEntity objCategoria : categoria){
            List<LancamentoEntity> lancamento = lancamentoRepository.findAll();
            double total = 0;
            ChartDTO dto = new ChartDTO();
            dto.setName(objCategoria.getName());

            for (LancamentoEntity objLancamento : lancamento){
                if (objLancamento.getCategoryId().getId() == objCategoria.getId()){
                    total += objLancamento.getAmount();
                }
            }
            dto.setAmount(total);
            chartDTO.add(dto);
        }
        return chartDTO;
    }

    public List<ChartDTO> ListDTO(){
        List<ChartDTO> listDTO = new ArrayList<ChartDTO>();
        categoriaRepository.findAll()
                .stream()
                .forEach(categoriaEntity -> {
                    ChartDTO dto = new ChartDTO();
                    dto.setName(categoriaEntity.getName());
                    dto.setAmount(0.0);
                    categoriaEntity.getLancamentoEntity().forEach(lancamento ->{
                        dto.setAmount(lancamento.getAmount()+dto.getAmount());
                    });
                    listDTO.add(dto);
                });
        return listDTO;
    }

   public Integer calculaMedia(Integer x, Integer y){
      try {
          return (x/y);
      }
       catch (ArithmeticException e){
          throw new DivisaoPorZeroException("Erro ao dividir por 0");
       }
    }

    public List<LancamentoEntity>getLancamentoDependentes(String date, Double amount, Boolean paid){
       if (date == null || amount == null){
           throw new ObjectNotFoundException("Parâmetros com valores errados");
       }
       List<LancamentoEntity> lancamento = lancamentoRepository.findAll()
               .stream()
               .filter(lancamentoEntity -> lancamentoEntity.getDate().equals(date)
                    && lancamentoEntity.getAmount().equals(amount)
                    && lancamentoEntity.getPaid() == paid)
               .collect(Collectors.toList());
       if (CollectionUtils.isEmpty(lancamento)){
           throw new LancamentoNotFoundException("lancamento não encontrado");
       }
       return lancamento;
    }

}









