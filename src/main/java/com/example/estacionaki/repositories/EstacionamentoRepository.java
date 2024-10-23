package com.example.estacionaki.repositories;

import com.example.estacionaki.models.Estacionamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstacionamentoRepository extends JpaRepository<Estacionamento, Long> {
}
