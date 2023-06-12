package com.klinkowski.spring.projetogodev.repository;

import com.klinkowski.spring.projetogodev.serviceTests.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long> {

    Optional<Materia> findById(Long id);

    List<Materia> findByAtivoIsTrue();

    List<Materia> findByAtivoIsFalse();

}
