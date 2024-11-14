package com.ac2parte2.ac2parte2.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import com.ac2parte2.ac2parte2.models.Agenda;

public interface AgendaService {
    List<Agenda> findAll();
    Agenda findById(Long id);
    Agenda save(Agenda agenda);
    void deleteById(Long id);

    // Método para verificar a disponibilidade do professor em uma data e horário específico
    boolean isProfessorAvailable(Long professorId, LocalDate dataInicio, 
                                 LocalTime horarioInicio, LocalTime horarioFim);
}
