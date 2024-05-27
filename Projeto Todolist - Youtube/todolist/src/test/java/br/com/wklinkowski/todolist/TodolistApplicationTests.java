package br.com.wklinkowski.todolist;

import br.com.wklinkowski.todolist.controller.TodoController;
import br.com.wklinkowski.todolist.entity.Todo;
import br.com.wklinkowski.todolist.enums.TipoPrioridade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodolistApplicationTests {

	@Autowired
	private TodoController controller;

	@Test
	void testCreateTodo() {
		var newTodo = new Todo("Criando tarefa", "Criando teste de criação da todo", false, TipoPrioridade.ALTA);

	}

	@Test
	void testCreateTodoFailure() {
		Todo todo = new Todo(null, "Criando teste de criação da todo", false, TipoPrioridade.ALTA);
	}

}
