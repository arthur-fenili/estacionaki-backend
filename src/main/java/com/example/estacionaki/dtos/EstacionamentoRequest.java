package com.example.estacionaki.dtos;

import com.example.estacionaki.models.Carro;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record EstacionamentoRequest(
        @NotBlank(message = "O nome do estacionamento é obrigatório")
        String nomeEstacionamento,

        @NotBlank(message = "O número de vagas disponíveis é obrigatório")
        Integer vagasDisponiveis,

        @NotBlank(message = "O número de vagas ocupadas é obrigatório")
        Integer vagasOcupadas,

        @NotBlank(message = "O valor da hora é obrigatório")
        Double valorHora,

        @NotBlank(message = "Os carros estacionados são obrigatórios")
        List<Carro> carrosEstacionados
) {
}
