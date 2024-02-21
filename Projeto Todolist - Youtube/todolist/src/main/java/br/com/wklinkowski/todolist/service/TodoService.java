package br.com.wklinkowski.todolist.service;

import br.com.wklinkowski.todolist.entity.Todo;
import br.com.wklinkowski.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public void createTodo(Todo todo){
        todoRepository.save(todo);
    }

    public void deleteTodoById(Long idTodo){
        todoRepository.deleteById(idTodo);
    }

    public void deleteAllTodo(){
        todoRepository.deleteAll();
    }

    public void updateTodo(Todo todo){
        todoRepository.save(todo);
    }

    public Optional<Todo> getTodoById(Long idTodo){
        return todoRepository.findById(idTodo);
    }

    public List<Todo> getAllTodos(){
        Sort sort = Sort.by("prioridadeTarefa").ascending().and(
                Sort.by("nomeTarefa").ascending()
        );

        return todoRepository.findAll(sort);
    }

}
