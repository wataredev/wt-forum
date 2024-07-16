package com.watare.wt.forum.domain.autor;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroAutor(@NotBlank
                                 String nome) {
}