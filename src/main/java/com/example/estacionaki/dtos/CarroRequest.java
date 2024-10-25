package com.example.estacionaki.dtos;

import com.example.estacionaki.models.Motorista;
import com.example.estacionaki.models.TipoAutomovel;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record CarroRequest(

        @NotBlank(message = "O tipo do automóvel é obrigatório")
        TipoAutomovel tipoAutomovel,

        @NotBlank(message = "A placa é obrigatória")
        String placa,

        @NotBlank(message = "O modelo é obrigatório")
        String modelo,

        @NotBlank(message = "A cor é obrigatória")
        String cor,

        @NotBlank(message = "O ano é obrigatório")
        String ano,

        @NotBlank(message = "O horário de entrada é obrigatório")
        Date horarioEntrada,

        @NotBlank(message = "O horário de saída é obrigatório")
        Date horarioSaida,

        @NotBlank(message = "O valor pago é obrigatório")
        Double valorPago,

        @NotBlank(message = "Informações sobre o motorista são obrigatórias")
        Motorista motorista
) {
}
