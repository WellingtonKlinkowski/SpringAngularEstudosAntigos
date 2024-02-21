package br.com.wklinkowski.todolist.repository;

import br.com.wklinkowski.todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
