package com.example.estacionaki.dtos;

import com.example.estacionaki.models.Carro;

import java.util.List;

public record EstacionamentoResponse(
        Long id,
        String nomeEstacionamento,
        Integer vagasDisponiveis,
        Integer vagasOcupadas,
        Double valorHora,
        List<Carro> carrosEstacionados
) {
}
