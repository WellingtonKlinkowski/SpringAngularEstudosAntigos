package com.klinkowski.spring.projetogodev.controller;

import com.klinkowski.spring.projetogodev.service.MatriculaService;
import com.klinkowski.spring.projetogodev.serviceTests.Matricula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/matricula")
public class MatriculaController {

    @Autowired
    MatriculaService matriculaService;

    @PostMapping("/cadastro")
    public ResponseEntity postMatricula(@RequestBody Matricula matricula){
        return new ResponseEntity<>(matriculaService.postMatricula(matricula), HttpStatus.CREATED);
    }

    @GetMapping("/todos")
    public ResponseEntity<?> getAllMatricula(){
        return new ResponseEntity<>( matriculaService.getAllMatriculas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Matricula>> getMatriculaId(@PathVariable Long id){
        return new ResponseEntity<>( matriculaService.getMatriculaId(id), HttpStatus.OK);
    }

    @PutMapping("/atualizar")
    public ResponseEntity putMatricula(@RequestBody Matricula matricula){
        return new ResponseEntity<>(matriculaService.postMatricula(matricula), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        matriculaService.deleteMateriaId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/ativos")
    public ResponseEntity<List<Matricula>> findMatriculaAtivos(){
        return new ResponseEntity<>(matriculaService.findMatriculaTrue(),HttpStatus.OK);
    }

    @GetMapping("/inativos")
    public ResponseEntity<List<Matricula>> findMatriculaInativos(){
        return new ResponseEntity<>(matriculaService.findMatriculaFalse(),HttpStatus.OK);
    }
}
