package com.klinkowski.spring.projetogodev.service;

import com.klinkowski.spring.projetogodev.serviceTests.Professor;
import com.klinkowski.spring.projetogodev.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public Professor postProfessor(Professor professor){
        return professorRepository.save(professor);
    }

    public List<Professor> getAllProfessor(){
        return professorRepository.findAll();
    }

    public List<Professor> findProfessorId(Long id){
        return professorRepository.findBy(id);
    }

    public Professor putProfessor(Professor professor){
        return professorRepository.save(professor);
    }

    public void deleteProfessorId(Long id){
        Optional<Professor> optionalProfessor = professorRepository.findById(id);
        Professor professor = optionalProfessor.orElseThrow(() -> {
            throw new IllegalArgumentException("Professor não encontrado!");
        });
        professor.setAtivo(false);
       professorRepository.save(professor);
    }

    public List<Professor> findProfessorFalse(){
        return professorRepository.findByAtivoFalse();
    }

    public List<Professor> findProfessorTrue(){
        return professorRepository.findByAtivoTrue();
    }

}
