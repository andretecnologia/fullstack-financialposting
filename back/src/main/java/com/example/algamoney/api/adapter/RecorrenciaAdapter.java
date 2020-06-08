package com.example.algamoney.api.adapter;

import com.example.algamoney.api.dto.RecorrenciaDTO;
import com.example.algamoney.api.model.Recorrencia;

public class RecorrenciaAdapter {

    public static Recorrencia transformToModel(RecorrenciaDTO dto){
        return Recorrencia.builder()
                .codigo(dto.getCodigo())
                .nome(dto.getNome())
                .build();
    }

    public static RecorrenciaDTO transformToDTO(Recorrencia recorrencia){
        return RecorrenciaDTO.builder()
                .codigo(recorrencia.getCodigo())
                .nome(recorrencia.getNome())
                .build();
    }
}
