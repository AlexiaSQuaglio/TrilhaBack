package trilha.back.financys;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import trilha.back.financys.dominio.entities.LancamentoEntity;
import trilha.back.financys.repository.LancamentoRepository;
import trilha.back.financys.service.LancamentoService;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class FinancysApplicationTests {
	@InjectMocks
	private LancamentoService lancamentoService;
	@Mock
	private LancamentoRepository lancamentoRepository;
	@Test
	void contextLoads() {
		List<LancamentoEntity> lancamentoEntities = new ArrayList();
		LancamentoEntity lancamento = new LancamentoEntity();
		lancamento.setDate("27/04/2000");
		lancamento.setAmount(360.50);
		lancamento.setPaid(true);
		lancamentoEntities.add(lancamento);

		LancamentoEntity lancamentoTest = new LancamentoEntity();
		lancamentoTest.setDate("30/05/2022");
		lancamentoTest.setAmount(760.36);
		lancamentoTest.setPaid(false);
		lancamentoEntities.add(lancamentoTest);


		Mockito.when(lancamentoRepository.findAll()).thenReturn(lancamentoEntities);
		Assertions.assertEquals(1, lancamentoService.getLancamentoDependentes("27/04/2000", 360.50, true).size());


	}
	}
