package com.example.estacionaki.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Estacionamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_estacionamento")
    private String nomeEstacionamento;

    @Column(name = "vagas_disponiveis")
    private int vagasDisponiveis;

    @Column(name = "vagas_ocupadas")
    private int vagasOcupadas;

    @Column(name = "preco_hora")
    private double precoHora;

    @OneToMany(mappedBy = "estacionamento", cascade = CascadeType.ALL)
    private List<Carro> carrosEstacionados;

    public List<Carro> getCarrosEstacionados() {
        return carrosEstacionados;
    }

    public void setCarrosEstacionados(List<Carro> carrosEstacionados) {
        this.carrosEstacionados = carrosEstacionados;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeEstacionamento() {
        return nomeEstacionamento;
    }

    public void setNomeEstacionamento(String nomeEstacionamento) {
        this.nomeEstacionamento = nomeEstacionamento;
    }

    public int getVagasDisponiveis() {
        return vagasDisponiveis;
    }

    public void setVagasDisponiveis(int vagasDisponiveis) {
        this.vagasDisponiveis = vagasDisponiveis;
    }

    public int getVagasOcupadas() {
        return vagasOcupadas;
    }

    public void setVagasOcupadas(int vagasOcupadas) {
        this.vagasOcupadas = vagasOcupadas;
    }

    public double getPrecoHora() {
        return precoHora;
    }

    public void setPrecoHora(double precoHora) {
        this.precoHora = precoHora;
    }

}
