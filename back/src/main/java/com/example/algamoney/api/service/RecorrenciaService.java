
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
    private RecorrenciaRepository repository;

    public int total(){
        return repository.total();
    }

    public Recorrencia salvar(Recorrencia recorrencia) {

        return repository.save(recorrencia);
    }

    public Recorrencia atualizar(Long codigo, Recorrencia recorrencia) {
        Recorrencia recorrenciaSalva = buscarRecorrenciaPeloCodigo(codigo);

        BeanUtils.copyProperties(recorrencia, recorrenciaSalva, "codigo");
        return repository.save(recorrenciaSalva);
    }

    public Recorrencia buscarRecorrenciaPeloCodigo(Long codigo) {
        Recorrencia pessoaSalva = repository.findOne(codigo);
        if (pessoaSalva == null) {
            throw new EmptyResultDataAccessException(1);
        }
        return pessoaSalva;
    }

}
