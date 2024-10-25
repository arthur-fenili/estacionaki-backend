package com.example.estacionaki.dtos;

import com.example.estacionaki.models.Carro;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record MotoristaRequest(
    @NotBlank(message = "O nome do motorista é obrigatório")
    String nome,

    @NotBlank(message = "O CPF é obrigatório")
    String cpf,

    @NotBlank(message = "O telefone é obrigatório")
    String telefone,

    @NotBlank(message = "Os carros relacionados ao motorista são obrigatórios")
    List<Carro> carros

) {
}
