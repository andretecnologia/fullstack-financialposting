package com.example.algamoney.api.repository;

import com.example.algamoney.api.model.Pessoa;
import com.example.algamoney.api.model.Recorrencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecorrenciaRepository extends JpaRepository<Recorrencia, Long> {

    public Page<Recorrencia> findByNomeContaining(String nome, Pageable pageable);
}
