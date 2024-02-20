package com.klinkowski.spring.projetogodev.service;

import com.klinkowski.spring.projetogodev.repository.AlunosRepository;
import com.klinkowski.spring.projetogodev.repository.MateriaRepository;
import com.klinkowski.spring.projetogodev.repository.MatriculaRepository;
import com.klinkowski.spring.projetogodev.serviceTests.Alunos;
import com.klinkowski.spring.projetogodev.serviceTests.Materia;
import com.klinkowski.spring.projetogodev.serviceTests.Matricula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaService {
    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunosRepository alunosRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    public Matricula postMatricula(Matricula matricula){
        Optional<Alunos> valdiationAlunoAtivo = alunosRepository.findById(matricula.getAlunos().getId());
        Alunos alunos = valdiationAlunoAtivo.orElseThrow(() -> {
            throw new IllegalArgumentException("Aluno não encontrado!");
        });
        if(alunos.getAtivo() == false){
            throw new IllegalArgumentException("Aluno inativo!");
        }
        Optional<Materia> valdiationMateriaAtivo = materiaRepository.findById(matricula.getMateria().getId());
        Materia materia = valdiationMateriaAtivo.orElseThrow(() -> {
            throw new IllegalArgumentException("Materia não encontrado!");
        });
        if(materia.getAtivo() == false){
            throw new IllegalArgumentException("Materia inativo!");
        }
        return matriculaRepository.save(matricula);
    }

    public List<Matricula> getAllMatriculas(){
        return matriculaRepository.findAll();
    }

    public Optional<Matricula> getMatriculaId(Long id){
        return matriculaRepository.findById(id);
    }

    public Matricula putMatricula(Matricula matricula){
        return matriculaRepository.save(matricula);
    }

    public void deleteMateriaId(Long id){
        Optional<Matricula> optionalMatricula = matriculaRepository.findById(id);
        Matricula matricula = optionalMatricula.orElseThrow(() -> {
            throw new IllegalArgumentException("Matricula não encontrado!");
        });
        matricula.setAtivo(false);
        matriculaRepository.save(matricula);
    }
    public List<Matricula> findMatriculaFalse(){
        return matriculaRepository.findByAtivoIsFalse();
    }

    public List<Matricula> findMatriculaTrue(){
        return matriculaRepository.findByAtivoIsTrue();
    }
}
