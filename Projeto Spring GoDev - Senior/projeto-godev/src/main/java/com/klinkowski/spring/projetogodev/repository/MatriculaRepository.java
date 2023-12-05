package com.klinkowski.spring.projetogodev.repository;

import com.klinkowski.spring.projetogodev.serviceTests.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    Optional<Matricula> findById(Long id);

    List<Matricula> findByAtivoIsTrue();

    List<Matricula> findByAtivoIsFalse();
}
