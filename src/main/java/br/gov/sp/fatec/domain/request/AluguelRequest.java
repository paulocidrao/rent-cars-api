package br.gov.sp.fatec.domain.request;

import br.gov.sp.fatec.domain.entity.Carro;
import br.gov.sp.fatec.domain.entity.Cliente;
import br.gov.sp.fatec.domain.enums.AluguelStatus;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Date;

@Builder
public record AluguelRequest(
        Long id,
        LocalDateTime datainico,
        LocalDateTime datafim,
        AluguelStatus aluguelStatus,
        Carro carro,
        Cliente cliente

) {}
