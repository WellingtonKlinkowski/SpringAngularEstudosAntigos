package com.klinkowski.locadoraveiculos.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//Não usei "(name="pessoa")" pois não é uma palavra reservada
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String nome;
    @NotNull
    @Column(unique = true)
    private String nroDocumento;
    @NotNull
    @Column(unique = true)
    private String nroCnh;
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date dataNasc;
    @NotNull
    //Lazy para ter uma carregamento simples e não travar a aplicação
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Endereco endereco;
    private String telefone;
    @Column(unique = true)
    private String email;
    @NotNull
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date dataCadastro;
}
