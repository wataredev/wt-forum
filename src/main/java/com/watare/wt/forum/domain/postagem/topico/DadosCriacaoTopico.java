package com.watare.wt.forum.domain.postagem.topico;

import com.watare.wt.forum.domain.postagem.Curso;
import jakarta.validation.constraints.NotNull;

public record DadosCriacaoTopico(@NotNull
                                 String titulo,
                                 @NotNull
                                 String mensagem,
                                 @NotNull
                                 Long idAutor,
                                 @NotNull
                                 Curso curso) {
}