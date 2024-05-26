package br.com.wklinkowski.todolist.entity;

import br.com.wklinkowski.todolist.enums.TipoPrioridade;
import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

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
    @NotNull
    private String nomeTarefa;
    private String descricaoTarefa;
    @NotNull
    private boolean situacaoTarefa;
    @NotNull
    @Enumerated
    private TipoPrioridade prioridadeTarefa;

    public Todo(String nomeTarefa, String descricaoTarefa, boolean situacaoTarefa, TipoPrioridade prioridadeTarefa) {
        this.nomeTarefa = nomeTarefa;
        this.descricaoTarefa = descricaoTarefa;
        this.situacaoTarefa = situacaoTarefa;
        this.prioridadeTarefa = prioridadeTarefa;
    }
}
