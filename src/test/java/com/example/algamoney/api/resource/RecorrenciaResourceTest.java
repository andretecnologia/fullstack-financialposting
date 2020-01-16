package com.example.algamoney.api.resource;

import com.example.algamoney.api.model.Recorrencia;
import com.example.algamoney.api.repository.RecorrenciaRepository;
import com.example.algamoney.api.service.RecorrenciaService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

@RunWith( MockitoJUnitRunner.class)
public class RecorrenciaResourceTest {

    @Autowired
    private  RecorrenciaResource recorrenciaResource;

    @Mock
    RecorrenciaService recorrenciaService;

    @Autowired
    Recorrencia recorrencia;

    private static final String NOME_VAZIO = "";

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void naoDeveSalvarRecorrenciaSemNome(){
        Mockito.when( recorrenciaService.salvar(recorrencia) );

    }

    private Recorrencia mockRecorrencia(){
        recorrencia.setNome( NOME_VAZIO );
    }
}
