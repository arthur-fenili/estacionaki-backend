package com.example.estacionaki.repositories;

import com.example.estacionaki.models.Carro;
import com.example.estacionaki.models.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

}
