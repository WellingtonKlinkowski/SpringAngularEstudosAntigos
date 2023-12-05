package com.klinkowski.locadoraveiculos.entities;

import com.klinkowski.locadoraveiculos.enums.TipoCambio;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String marca;
    @NotNull
    private String nome;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private TipoVeiculo tipo;
    @NotNull
    private String cor;
    @NotNull
    private int qtdLugares;
    @NotNull
    private TipoCambio cambio;
    @NotNull
    private int bancoDeCouro;
    @NotNull
    private int arCondicionado;
    @NotNull
    private int direcaoHidra;
    @NotNull
    private int vidroElec;
    @NotNull
    private int sensorDeRe;
    @NotNull
    private int cameraDeRe;
    @NotNull
    private int disponivel;
    @NotNull
    private String placa;
    @NotNull
    private int cilindradas;
    @NotNull
    @Digits(integer=10, fraction=2)
    private BigDecimal valorDiaria;
}
