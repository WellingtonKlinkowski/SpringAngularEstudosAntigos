package br.com.wklinkowski.todolist.controller;

import br.com.wklinkowski.todolist.entity.Todo;
import br.com.wklinkowski.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService serviceTodo;

    @PostMapping
    public void createTodo(@RequestBody Todo todo){
        serviceTodo.createTodo(todo);
    }

    @DeleteMapping("/{id}")
    public void deleteTodoById(@PathVariable("id") Long idTodo){
        serviceTodo.deleteTodoById(idTodo);
    }

    @DeleteMapping
    public void deleteAllTodo(){
        serviceTodo.deleteAllTodo();
    }

    @PutMapping
    public void updateTodo(@RequestBody Todo todo){
        serviceTodo.updateTodo(todo);
    }

    @GetMapping("/{id}")
    public Optional<Todo> getTodoById(@PathVariable("id") Long idTodo){
        return serviceTodo.getTodoById(idTodo);
    }

    @GetMapping
    public List<Todo> getAllTodos(){
        return  serviceTodo.getAllTodos();
    }
}
