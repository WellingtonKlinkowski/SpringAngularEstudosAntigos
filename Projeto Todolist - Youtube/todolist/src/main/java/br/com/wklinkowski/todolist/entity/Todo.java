package br.com.wklinkowski.todolist.entity;

import br.com.wklinkowski.todolist.enums.TipoPrioridade;
import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTarefa;
    private String nomeTarefa;
    private String descricaoTarefa;
    private boolean situacaoTarefa;
    @Enumerated
    private TipoPrioridade prioridadeTarefa;
}
