package com.klinkowski.spring.projetogodev.service;

import com.klinkowski.spring.projetogodev.repository.AlunosRepository;
import com.klinkowski.spring.projetogodev.serviceTests.Alunos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunosService {
    @Autowired
    private AlunosRepository alunosRepository;

    public Alunos postAlunos(Alunos alunos){
       return alunosRepository.save(alunos);
    }

    public List<Alunos> getAllAlunos(){
        return alunosRepository.findAll();
    }

    public Optional<Alunos> findAlunoId(Long id){
        return alunosRepository.findBy(id);
    }

    public Alunos putAlunos(Alunos alunos){
        return alunosRepository.save(alunos);
    }

    public void deleteAlunoId(Long id){
        Optional<Alunos> optionalAluno = alunosRepository.findBy(id);
        Alunos alunos = optionalAluno.orElseThrow(() -> {
            throw new IllegalArgumentException("Aluno não encontrado!");
        });
        alunos.setAtivo(false);
        alunosRepository.save(alunos);
    }

    public List<Alunos> findAlunoAtivo(){
        return alunosRepository.findByAtivoTrue();
    }

    public List<Alunos> findAlunoDesativos(){
        return alunosRepository.findByAtivoFalse();
    }


}
