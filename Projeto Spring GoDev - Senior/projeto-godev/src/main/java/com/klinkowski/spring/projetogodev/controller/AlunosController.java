package com.klinkowski.spring.projetogodev.controller;

import com.klinkowski.spring.projetogodev.service.AlunosService;
import com.klinkowski.spring.projetogodev.serviceTests.Alunos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunosController {
    @Autowired
    AlunosService alunosService;

    @PostMapping("/cadastro")
    public ResponseEntity postAlunos(@RequestBody Alunos alunos){
       return new ResponseEntity<>(alunosService.postAlunos(alunos), HttpStatus.CREATED);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Alunos>> getAllAlunos(){
        return new ResponseEntity<>(alunosService.getAllAlunos(),HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Alunos>> getAlunosId(@PathVariable Long id){
        return new ResponseEntity<>(alunosService.findAlunoId(id), HttpStatus.OK);
    }

    @PutMapping(value = "/atualizar")
    public ResponseEntity<Alunos> putAlunosId(@RequestBody Alunos alunos){
        return new ResponseEntity<>(alunosService.putAlunos(alunos), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        alunosService.deleteAlunoId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/ativos")
    public ResponseEntity<List<Alunos>> findAlunosAtivos(){
        return new ResponseEntity<>(alunosService.findAlunoAtivo(),HttpStatus.OK);
    }

    @GetMapping("/inativos")
    public ResponseEntity<List<Alunos>> findAlunosInativos(){
        return new ResponseEntity<>(alunosService.findAlunoDesativos(),HttpStatus.OK);
    }
}
