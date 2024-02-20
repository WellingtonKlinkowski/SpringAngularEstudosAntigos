package com.klinkowski.spring.projetogodev.controller;

import com.klinkowski.spring.projetogodev.service.MateriaService;
import com.klinkowski.spring.projetogodev.serviceTests.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/materia")
public class MateriaController {

    @Autowired
    MateriaService materiaService;

    @PostMapping("/cadastro")
    public ResponseEntity postMateria(@RequestBody Materia materia){
        return new ResponseEntity<>(materiaService.postMateria(materia), HttpStatus.CREATED);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Materia>> getAllMateria(){
        return new ResponseEntity<>(materiaService.getAllMateria(),HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity< Optional<Materia>> getProfessorId(@PathVariable Long id){
        return new ResponseEntity<>(materiaService.findMateriaId(id), HttpStatus.OK);
    }

    @PutMapping("/atualizar")
    public ResponseEntity putMateria(@RequestBody Materia materia){
        return new ResponseEntity<>(materiaService.postMateria(materia), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        materiaService.deleteMateriaId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/ativos")
    public ResponseEntity<List<Materia>> findMateriaAtivos(){
        return new ResponseEntity<>(materiaService.findMateriaAtivo(),HttpStatus.OK);
    }

    @GetMapping("/inativos")
    public ResponseEntity<List<Materia>> findMateriaInativos(){
        return new ResponseEntity<>(materiaService.findMateriaFalse(),HttpStatus.OK);
    }
}
