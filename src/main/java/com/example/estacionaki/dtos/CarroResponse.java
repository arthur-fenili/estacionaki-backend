package com.example.estacionaki.dtos;

import com.example.estacionaki.models.Motorista;
import com.example.estacionaki.models.TipoAutomovel;

import java.util.Date;

public record CarroResponse(
        Long id,
    TipoAutomovel tipo,
    String placa,
    String modelo,
    String cor,
    Integer ano,
    Date horarioEntrada,
    Date horarioSaida,
    Double valorPago,
    Motorista motorista
) {
}
