package br.gov.sp.fatec.domain.response;

import br.gov.sp.fatec.domain.entity.Carro;
import br.gov.sp.fatec.domain.entity.Cliente;
import br.gov.sp.fatec.domain.enums.AluguelStatus;

import java.time.LocalDateTime;


public record AluguelResponse(
        Long id,
        LocalDateTime datainico,
        LocalDateTime datafim,
        Double valor,
        AluguelStatus status,
        Carro carro,
        Cliente cliente

) { }
