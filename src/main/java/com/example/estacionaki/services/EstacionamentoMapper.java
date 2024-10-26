package com.example.estacionaki.services;

import com.example.estacionaki.dtos.EstacionamentoRequest;
import com.example.estacionaki.dtos.EstacionamentoResponse;
import com.example.estacionaki.models.Estacionamento;
import org.springframework.stereotype.Service;

@Service
public class EstacionamentoMapper {

    public Estacionamento requestToEstacionamento(EstacionamentoRequest estacionamentoRequest){
        Estacionamento estacionamento = new Estacionamento();
        estacionamento.setNomeEstacionamento(estacionamentoRequest.nomeEstacionamento());
        estacionamento.setVagasDisponiveis(estacionamentoRequest.vagasDisponiveis());
        estacionamento.setVagasOcupadas(estacionamentoRequest.vagasOcupadas());
        estacionamento.setPrecoHora(estacionamentoRequest.precoHora());
        estacionamento.setCarrosEstacionados(estacionamentoRequest.carrosEstacionados());
        return estacionamento;
    }

    public EstacionamentoResponse estacionamentoToResponse(Estacionamento estacionamento){
        return new EstacionamentoResponse(
                estacionamento.getId(),
                estacionamento.getNomeEstacionamento(),
                estacionamento.getVagasDisponiveis(),
                estacionamento.getVagasOcupadas(),
                estacionamento.getPrecoHora(),
                estacionamento.getCarrosEstacionados());
    }
}
