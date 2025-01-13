package com.gestionhumana.create.msrrhhcr.repositories;

import com.gestionhumana.create.msrrhhcr.entities.Candidatos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;

public interface CandidatoRepository extends JpaRepository<Candidatos, Long> {
    Optional<Candidatos> findById(long id);

    @Query("SELECT c FROM Candidatos c WHERE " +
            "( :id IS NULL OR c.Id = :id ) AND " +
            "( :fechaInicio IS NULL OR c.FechaCreacion >= :fechaInicio ) AND " +
            "( :fechaFin IS NULL OR c.FechaCreacion <= :fechaFin )")
    Page<Candidatos> findByFilters(Long id, LocalDate fechaInicio, LocalDate fechaFin, Pageable pageable);

    Page<Candidatos> findByIdAndFechaCreacionBetween(Long id, LocalDate fechaInicio, LocalDate fechaFin, Pageable pageable);

    Page<Candidatos> findByFechaCreacionBetween(LocalDate fechaInicio, LocalDate fechaFin, Pageable pageable);
    Page<Candidatos> findById(Long id, Pageable pageable);
}
