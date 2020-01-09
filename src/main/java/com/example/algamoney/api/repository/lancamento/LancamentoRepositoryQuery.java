package com.example.algamoney.api.repository.lancamento;

import com.example.algamoney.api.dto.LancamentoEstatisticaCategoria;
import com.example.algamoney.api.dto.LancamentoEstatisticaDia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.algamoney.api.model.Lancamento;
import com.example.algamoney.api.repository.filter.LancamentoFilter;

import java.time.LocalDate;
import java.util.List;

public interface LancamentoRepositoryQuery {

	public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);

	public List<LancamentoEstatisticaCategoria> porCategoria(LocalDate mesReferencia);

	public List<LancamentoEstatisticaDia> porDia(LocalDate mesReferencia);

}
