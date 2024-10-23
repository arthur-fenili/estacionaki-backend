package com.example.estacionaki.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoAutomovel tipo;

    @Column(name = "plate")
    private String placa;

    @Column(name = "model")
    private String modelo;

    @Column(name = "color")
    private String cor;

    @Column(name = "ano")
    private int ano;

    @Column(name = "horario_entrada")
    private Date horarioEntrada;

    @Column(name = "horario_saida")
    private Date horarioSaida;

    @Column(name = "valor_pago")
    private double valorPago;

    @ManyToOne
    @JoinColumn(name = "motorista_id")
    private Motorista motorista;

    public Date getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(Date horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public Date getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(Date horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoAutomovel getTipo() {
        return tipo;
    }

    public void setTipo(TipoAutomovel tipo) {
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }
}
