package com.example.estacionaki.dtos;

import com.example.estacionaki.models.Carro;

import java.util.List;

public record MotoristaResponse(
        Long id,
        String nome,
        String cpf,
        String telefone,
        List<Carro> carros
) {
}
