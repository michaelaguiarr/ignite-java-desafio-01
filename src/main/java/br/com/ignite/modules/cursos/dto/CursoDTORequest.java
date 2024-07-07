package br.com.ignite.modules.cursos.dto;

import jakarta.validation.constraints.NotBlank;

public record CursoDTORequest(@NotBlank String nome, @NotBlank String categoria) {
}
