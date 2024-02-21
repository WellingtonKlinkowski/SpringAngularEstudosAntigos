package br.com.wklinkowski.todolist.enums;

import jakarta.persistence.Enumerated;

public enum TipoPrioridade {

    URGENTE(5),
    ALTA(4),
    MEDIA(3),
    BAIXA(2),
    SEM(1);

    private Integer ordemPrioridade;
    TipoPrioridade(Integer ordemPrioridade) {
        this.ordemPrioridade = ordemPrioridade;
    }

    public Integer getOrdemPrioridade(){
        return this.ordemPrioridade;
    }

}
