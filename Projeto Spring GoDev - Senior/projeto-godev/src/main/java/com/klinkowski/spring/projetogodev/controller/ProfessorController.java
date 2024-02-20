package com.klinkowski.spring.projetogodev.controller;

import com.klinkowski.spring.projetogodev.service.ProfessorService;
import com.klinkowski.spring.projetogodev.serviceTests.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    ProfessorService professorService;

    @PostMapping("/cadastro")
    public ResponseEntity postProfessor(@RequestBody Professor professor){
        return new ResponseEntity<>(professorService.postProfessor(professor), HttpStatus.CREATED);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Professor>> getAllProfessor(){
        return new ResponseEntity<>(professorService.getAllProfessor(),HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<Professor>> getProfessorId(@PathVariable Long id){
        return new ResponseEntity<>(professorService.findProfessorId(id), HttpStatus.OK);
    }

    @PutMapping("/atualizar")
    public ResponseEntity putProfessor(@RequestBody Professor professor){
        return new ResponseEntity<>(professorService.postProfessor(professor), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        professorService.deleteProfessorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/ativos")
    public ResponseEntity<List<Professor>> findProfessorAtivos(){
        return new ResponseEntity<>(professorService.findProfessorTrue(),HttpStatus.OK);
    }

    @GetMapping("/inativos")
    public ResponseEntity<List<Professor>> findProfessorInativos(){
        return new ResponseEntity<>(professorService.findProfessorFalse(),HttpStatus.OK);
    }
}
