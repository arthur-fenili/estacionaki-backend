package com.example.estacionaki.services;

import com.example.estacionaki.dtos.MotoristaRequest;
import com.example.estacionaki.dtos.MotoristaResponse;
import com.example.estacionaki.models.Motorista;
import org.springframework.stereotype.Service;

@Service
public class MotoristaMapper {

    public Motorista requestToMotorista(MotoristaRequest motoristaRequest){
        Motorista motorista = new Motorista();
        motorista.setNome(motoristaRequest.nome());
        motorista.setCpf(motoristaRequest.cpf());
        motorista.setTelefone(motoristaRequest.telefone());
        motorista.setCarros(motoristaRequest.carros());
        return motorista;
    }

    public MotoristaResponse motoristaToResponse(Motorista motorista){
        return new MotoristaResponse(
                motorista.getId(),
                motorista.getNome(),
                motorista.getCpf(),
                motorista.getTelefone(),
                motorista.getCarros());
    }

}
