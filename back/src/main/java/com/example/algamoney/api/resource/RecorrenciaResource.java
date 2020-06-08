package com.example.algamoney.api.resource;

import com.example.algamoney.api.dto.RecorrenciaDTO;
import com.example.algamoney.api.event.RecursoCriadoEvent;
import com.example.algamoney.api.model.Recorrencia;
import com.example.algamoney.api.repository.RecorrenciaRepository;
import com.example.algamoney.api.service.RecorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import static com.example.algamoney.api.adapter.RecorrenciaAdapter.transformToDTO;
import static com.example.algamoney.api.adapter.RecorrenciaAdapter.transformToModel;

@CrossOrigin
@RestController
@RequestMapping("/recorrencias")
public class RecorrenciaResource {

    @Autowired
    private RecorrenciaRepository repository;

    @Autowired
    private RecorrenciaService service;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping("/total")
    public int total() {
        return service.total();
    }

    @PostMapping
    public ResponseEntity<RecorrenciaDTO> criar(@Valid @RequestBody RecorrenciaDTO dto, HttpServletResponse response) {
        Recorrencia recorrenciaSalva = service.salvar(transformToModel(dto));
        publisher.publishEvent(new RecursoCriadoEvent(this, response, recorrenciaSalva.getCodigo()));
        return ResponseEntity.status(HttpStatus.CREATED).body(transformToDTO(recorrenciaSalva));
    }

    @GetMapping
    public Page<Recorrencia> pesquisar(@RequestParam(required = false, defaultValue = "%") String nome, Pageable pageable) {
        return repository.findByNomeContaining(nome, pageable);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Recorrencia> buscarPeloCodigo(@PathVariable Long codigo) {
        Recorrencia recorrencia = repository.findOne(codigo);
        return recorrencia != null ? ResponseEntity.ok(recorrencia) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long codigo) {
        repository.delete(codigo);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Recorrencia> atualizar(@PathVariable Long codigo, @Valid @RequestBody Recorrencia recorrencia) {
        Recorrencia recorrenciaSalva = service.atualizar(codigo, recorrencia);
        return ResponseEntity.ok(recorrenciaSalva);
    }



}
