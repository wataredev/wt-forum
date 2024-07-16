package com.watare.wt.forum.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUsuario(@NotBlank String login,
                                   @NotBlank String senha,
                                   @NotBlank @Email String email) {
}