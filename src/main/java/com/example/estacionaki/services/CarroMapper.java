package com.example.estacionaki.services;

import com.example.estacionaki.dtos.CarroRequest;
import com.example.estacionaki.dtos.CarroResponse;
import com.example.estacionaki.models.Carro;
import org.springframework.stereotype.Service;

@Service
public class CarroMapper {

    public Carro requestToCarro(CarroRequest carroRequest){
        Carro carro = new Carro();
        carro.setPlaca(carroRequest.placa());
        carro.setCor(carroRequest.cor());
        carro.setModelo(carroRequest.modelo());
        carro.setMotorista(carroRequest.motorista());
        return carro;
    }

    public CarroResponse carroToResponse(Carro carro){
        return new CarroResponse(
                carro.getId(),
                carro.getTipoAutomovel(),
                carro.getPlaca(),
                carro.getModelo(),
                carro.getCor(),
                carro.getAno(),
                carro.getHorarioEntrada(),
                carro.getHorarioSaida(),
                carro.getValorPago(),
                carro.getMotorista()
        );
    }
}
