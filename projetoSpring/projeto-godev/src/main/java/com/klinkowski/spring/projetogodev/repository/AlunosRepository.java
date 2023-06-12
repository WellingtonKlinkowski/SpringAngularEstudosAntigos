package com.klinkowski.spring.projetogodev.repository;

import com.klinkowski.spring.projetogodev.serviceTests.Alunos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlunosRepository extends JpaRepository<Alunos, Long> {

    @Query(value = "select a.* from alunos a where  a.id = :id", nativeQuery = true)
    Optional<Alunos> findBy(Long id);

    @Query(value = "select a.* from alunos a where  a.ativo = 'true'", nativeQuery = true)
    List<Alunos> findByAtivoTrue();

    @Query(value = "select a.* from alunos a where  a.ativo = 'false'", nativeQuery = true)
    List<Alunos> findByAtivoFalse();

}
