package com.klinkowski.spring.projetogodev.repository;

import com.klinkowski.spring.projetogodev.serviceTests.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    @Query(value = "select p.* from professor p where  p.id = :id", nativeQuery = true)
    List<Professor> findBy(Long id);

    @Query(value = "select p.* from professor p where  p.ativo = 'true'", nativeQuery = true)
    List<Professor> findByAtivoTrue();

    @Query(value = "select p.* from professor p where  p.ativo = 'false'", nativeQuery = true)
    List<Professor> findByAtivoFalse();

}
