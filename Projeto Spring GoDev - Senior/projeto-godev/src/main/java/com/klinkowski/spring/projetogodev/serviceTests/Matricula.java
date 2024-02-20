package com.klinkowski.spring.projetogodev.serviceTests;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "matricula")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private LocalDate data = LocalDate.now();
    private Boolean ativo;
    @ManyToOne
    @JoinColumn(name = "id_alunos")
    private Alunos alunos;
    @ManyToOne
    @JoinColumn(name = "id_materia")
    private Materia materia;


    public Matricula(Alunos alunos, Materia materia) {
        this.alunos = alunos;
        this.materia = materia;
    }
}
