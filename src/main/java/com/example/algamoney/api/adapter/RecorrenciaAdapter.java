package com.example.algamoney.api.adapter;

import com.example.algamoney.api.dto.RecorrenciaDTO;
import com.example.algamoney.api.model.Recorrencia;

public class RecorrenciaAdapter {

    public static Recorrencia transformToModel(RecorrenciaDTO dto){
        return Recorrencia.builder()
                .nome(dto.getNome())
                .build();
    }

    public static RecorrenciaDTO transformToDTO(Recorrencia recorrencia){
        return RecorrenciaDTO.builder()
                .nome(recorrencia.getNome())
                .build();
    }
}
