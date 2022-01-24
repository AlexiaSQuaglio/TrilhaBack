package teste;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import trilha.back.financys.dominio.entities.LancamentoEntity;
import trilha.back.financys.exception.LancamentoNotFoundException;
import trilha.back.financys.repository.LancamentoRepository;
import trilha.back.financys.service.LancamentoService;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class TrilhaBackTestes {
    @InjectMocks
    private LancamentoService lancamentoService;
    @Mock
    private LancamentoRepository lancamentoRepository;
    @Test
    public void testeLancamento() throws LancamentoNotFoundException {
        List<LancamentoEntity> lancamentoEntities = new ArrayList();
        LancamentoEntity lancamento = new LancamentoEntity();
        lancamento.setDate("27/04/2000");
        lancamento.setAmount(360.50);
        lancamento.setPaid(true);
        lancamentoEntities.add(lancamento);

        Mockito.when(lancamentoRepository.findAll()).thenReturn(lancamentoEntities);
        Assertions.assertFalse(lancamentoService.getAll().isEmpty());
        Assertions.assertEquals(1, lancamentoService.getLancamentoDependentes("27/04/2000", "360.50", true));
    }
}
