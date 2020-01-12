package com.example.algamoney.api.resource;

import com.example.algamoney.api.event.RecursoCriadoEvent;
import com.example.algamoney.api.model.Recorrencia;
import com.example.algamoney.api.repository.RecorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/recorrencias")
public class RecorrenciaResource {

    @Autowired
    private RecorrenciaRepository recorrenciaRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public List<Recorrencia> listar() {
        return recorrenciaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Recorrencia> criar(@Valid @RequestBody Recorrencia recorrencia, HttpServletResponse response) {
        Recorrencia recorrenciaSalva = recorrenciaRepository.save(recorrencia);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, recorrenciaSalva.getCodigo()));
        return ResponseEntity.status(HttpStatus.CREATED).body(recorrenciaSalva);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Recorrencia> buscarPeloCodigo(@PathVariable Long codigo) {
        Recorrencia recorrencia = recorrenciaRepository.findOne(codigo);
        return recorrencia != null ? ResponseEntity.ok(recorrencia) : ResponseEntity.notFound().build();
    }




}
