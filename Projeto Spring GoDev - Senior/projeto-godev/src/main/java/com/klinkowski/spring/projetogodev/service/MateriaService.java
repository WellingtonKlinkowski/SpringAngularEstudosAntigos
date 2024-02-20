package com.klinkowski.spring.projetogodev.service;

import com.klinkowski.spring.projetogodev.repository.MateriaRepository;
import com.klinkowski.spring.projetogodev.repository.ProfessorRepository;
import com.klinkowski.spring.projetogodev.serviceTests.Materia;
import com.klinkowski.spring.projetogodev.serviceTests.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MateriaService {
    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    private ProfessorRepository professorRepository;
    public Materia postMateria(Materia materia){
        Optional<Professor> valdiationAtivo = professorRepository.findById(materia.getProfessor().getId());
        Professor professor = valdiationAtivo.orElseThrow(() -> {
            throw new IllegalArgumentException("Professor não encontrado!");
        });
        if(professor.getAtivo() == false){
            throw new IllegalArgumentException("Professor inativo!");
        }
        return materiaRepository.save(materia);
    }

    public List<Materia> getAllMateria(){
        return materiaRepository.findAll();
    }

    public  Optional<Materia> findMateriaId(Long id){
        return materiaRepository.findById(id);
    }

    public Materia putMateria (Materia materia){
        return materiaRepository.save(materia);
    }

    public void deleteMateriaId(Long id){
        Optional<Materia> optionalMateria = materiaRepository.findById(id);
        Materia materia = optionalMateria.orElseThrow(() -> {
            throw new IllegalArgumentException("Materia não encontrado!");
        });
        materia.setAtivo(false);
       materiaRepository.save(materia);
    }

    public List<Materia> findMateriaAtivo(){
        return materiaRepository.findByAtivoIsTrue();
    }

    public List<Materia> findMateriaFalse(){
        return materiaRepository.findByAtivoIsFalse();
    }
}
