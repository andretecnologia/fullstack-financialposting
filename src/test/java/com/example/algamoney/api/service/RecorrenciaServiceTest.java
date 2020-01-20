package com.example.algamoney.api.service;

import com.example.algamoney.api.AlgamoneyApiApplication;
import com.example.algamoney.api.dto.RecorrenciaDTO;
import com.example.algamoney.api.model.Lancamento;
import com.example.algamoney.api.model.Recorrencia;
import com.example.algamoney.api.repository.LancamentoRepository;
import com.example.algamoney.api.repository.RecorrenciaRepository;
import com.example.algamoney.api.resource.RecorrenciaResource;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.*;

@RunWith( SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { AlgamoneyApiApplication.class,
        RecorrenciaService.class,
        Recorrencia.class,
        RecorrenciaDTO.class,
        RecorrenciaResource.class,
        RecorrenciaRepository.class})
public class RecorrenciaServiceTest {

    @MockBean
    private RecorrenciaRepository recorrenciaRepository;

    @Autowired
    private RecorrenciaService recorrenciaService;

    @MockBean
    Recorrencia recorrencia;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Ignore
    public void deveSalvarRecorrenciaSemNome() {

        recorrenciaService.salvar( createOne() );
        RecorrenciaRepository mockedRecorrenciaRepository = Mockito.mock(RecorrenciaRepository.class);
        //verify(recorrenciaRepository, times(1)).save(any(RecorrenciaRepository.class));

    }

    @Ignore
    public void verifyAllToDoList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/categorias").accept(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$", hasSize(7))).andDo(print());
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testarEnvioEmailSobreLancamentosVencidos() {

        doReturn(Lists.list(new Lancamento()))
                .when(lancamentoRepository)
                .findByDataVencimentoLessThanEqualAndDataPagamentoIsNull((any(LocalDate.class)));

        doReturn(Lists.list(new Usuario()))
                .when(usuarioRepository)
                .findByPermissoesDescricao(any());

        lancamentoService.avisarSobreLancamentosVencidos();
        verify(mailer, times(1)).avisarSobreLancamentosVencidos(any(), any());
    }

    //	@Test
//	public void buscarPeloCodigo() {
//		ResponseEntity<Categoria> reponseEntity = restTemplate.getForEntity("/categorias/1}", Categoria.class);
//		Assertions.assertThat(reponseEntity.getStatusCodeValue()).isEqualTo(400);
//	}
    @Ignore
    public void testGetAllCategorias() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/categorias", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }


    @Ignore
    public void verifyToDoById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/categorias/3").accept(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$.codigo").exists()).andExpect(jsonPath("$.nome").exists()).andExpect(jsonPath("$.codigo").value(3))
                .andExpect(jsonPath("$.nome").value("Supermercado")).andDo(print());
    }

    @Test
    public void createOneWithSucess() {

        when( recorrenciaService.salvar( Mockito.any() ) )
                .thenReturn( createOne() );
        when( recorrenciaRepository.findByCodigo( recorrencia.getCodigo() ) )
                .thenReturn( recorrencia );
    }

    private Recorrencia createOne(){
        return Recorrencia.builder()
                .codigo( 99L )
                .nome( "abcdef" )
                .build();
    }
}
