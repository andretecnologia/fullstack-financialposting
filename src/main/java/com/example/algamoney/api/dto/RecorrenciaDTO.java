package com.example.algamoney.api.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Data
public class RecorrenciaDTO {

    private Long codigo;

    @NotNull
    @Size(min = 3, max = 20)
    private String nome;

}
