
package com.example.algamoney.api.service;

import com.example.algamoney.api.model.Recorrencia;
import com.example.algamoney.api.repository.RecorrenciaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class RecorrenciaService {

    @Autowired
    private RecorrenciaRepository recorrenciaRepository;

    public Recorrencia salvar(Recorrencia recorrencia) {

        return recorrenciaRepository.save(recorrencia);
    }

    public Recorrencia atualizar(Long codigo, Recorrencia recorrencia) {
        Recorrencia recorrenciaSalva = buscarRecorrenciaPeloCodigo(codigo);

        BeanUtils.copyProperties(recorrencia, recorrenciaSalva, "codigo");
        return recorrenciaRepository.save(recorrenciaSalva);
    }

    public Recorrencia buscarRecorrenciaPeloCodigo(Long codigo) {
        Recorrencia pessoaSalva = recorrenciaRepository.findOne(codigo);
        if (pessoaSalva == null) {
            throw new EmptyResultDataAccessException(1);
        }
        return pessoaSalva;
    }

}
