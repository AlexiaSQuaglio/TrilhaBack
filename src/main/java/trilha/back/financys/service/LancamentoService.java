package trilha.back.financys.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import trilha.back.financys.dto.LancamentoDTO;
import trilha.back.financys.entities.LancamentoEntity;
import trilha.back.financys.repository.LancamentoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;
    @Autowired
    ModelMapper mapper;


    public LancamentoService(LancamentoRepository lancamentoRepository, ModelMapper mapper) {
        this.lancamentoRepository = lancamentoRepository;
        this.mapper = mapper;
    }
    public List<LancamentoDTO> getAll() {
        return  lancamentoRepository
                .findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
    public LancamentoEntity findById(Long id) {
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

    public LancamentoEntity criarLancamento(LancamentoEntity lancamentoEntity) {
        return lancamentoRepository.save(lancamentoEntity);
    }
    private LancamentoDTO mapToDto(LancamentoEntity lancamento) {
        return mapper.map(lancamento,LancamentoDTO.class );
    }
    private LancamentoEntity mapToEntity(LancamentoDTO dto) {
        return mapper.map(dto,LancamentoEntity.class );
    }
    public List <LancamentoDTO> listByCategoria () {
        List<LancamentoDTO> lancamentoAnterior = getAll();
        List<LancamentoDTO> lancamentoRetorno = new ArrayList<LancamentoDTO>();
        for (var i = 0; i < lancamentoAnterior.size(); i++) {
            LancamentoDTO item = lancamentoAnterior.get(i);
            if (lancamentoAnterior.contains(item.getCategoryId()) ){
                lancamentoRetorno = lancamentoAnterior;
                return lancamentoRetorno;
        }
            else{
                lancamentoAnterior.add();
            }
        }

        return lancamentoRetorno;
    }
}









