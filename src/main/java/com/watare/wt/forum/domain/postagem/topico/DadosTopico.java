package com.watare.wt.forum.domain.postagem.topico;

import com.watare.wt.forum.domain.autor.DadosAutor;
import com.watare.wt.forum.domain.postagem.Curso;

import java.time.LocalDateTime;

public record DadosTopico(Long id,
                          String titulo,
                          String mensagem,
                          LocalDateTime data,
                          Boolean duvidaResolvida,
                          DadosAutor autor,
                          Curso curso) {
}