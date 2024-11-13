package com.ac2parte2.ac2parte2.repositories;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ac2parte2.ac2parte2.models.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {

    // Consulta para encontrar agendas de um professor dentro de um período de datas e horários
    List<Agenda> findByProfessorIdAndDataInicioBetweenAndHorarioInicioBetween(
        Long professorId, LocalDate dataInicio, LocalDate dataFim, LocalTime horarioInicio, LocalTime horarioFim);
}
