package br.gov.sp.fatec.domain.request;

import lombok.Builder;

@Builder
public record ClienteRequest(
        Long id,
        String nome,
        String cpf,
        String telefone
) {}
