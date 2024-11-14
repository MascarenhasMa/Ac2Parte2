package com.ac2parte2.ac2parte2.repositories;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ac2parte2.ac2parte2.models.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {

    // Consulta para verificar conflito de horário de um professor em uma data específica
    @Query("SELECT a FROM Agenda a WHERE a.professor.id = :professorId " +
           "AND a.dataInicio = :data " +
           "AND ((:horarioInicio BETWEEN a.horarioInicio AND a.horarioFim) " +
           "OR (:horarioFim BETWEEN a.horarioInicio AND a.horarioFim) " +
           "OR (a.horarioInicio BETWEEN :horarioInicio AND :horarioFim) " +
           "OR (a.horarioFim BETWEEN :horarioInicio AND :horarioFim))")
    List<Agenda> findConflictingAgendas(
            @Param("professorId") Long professorId,
            @Param("data") LocalDate data,
            @Param("horarioInicio") LocalTime horarioInicio,
            @Param("horarioFim") LocalTime horarioFim);
}
