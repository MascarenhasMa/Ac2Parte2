package com.ac2parte2.ac2parte2.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ac2parte2.ac2parte2.models.Agenda;
import com.ac2parte2.ac2parte2.models.Curso;
import com.ac2parte2.ac2parte2.models.Professor;
import com.ac2parte2.ac2parte2.repositories.CursoRepository;
import com.ac2parte2.ac2parte2.repositories.ProfessorRepository;
import com.ac2parte2.ac2parte2.repositories.AgendaRepository;

@Service
public class AgendaServiceImpl implements AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private CursoRepository cursoRepository;  // Adicione isso

    @Autowired
    private ProfessorRepository professorRepository;  // Adicione isso

    @Override
    public List<Agenda> findAll() {
        return agendaRepository.findAll(); // Retorna todas as agendas
    }

    @Override
    public Agenda findById(Long id) {
        return agendaRepository.findById(id).orElse(null); // Retorna a agenda ou null caso não exista
    }

    @Override
public Agenda save(Agenda agenda) {
    // Recupera o Curso e o Professor do banco de dados pelos seus IDs
    Curso curso = cursoRepository.findById(agenda.getCurso().getId())
        .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

    Professor professor = professorRepository.findById(agenda.getProfessor().getId())
        .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

    // Verifica a disponibilidade do professor para o novo horário
    if (!isProfessorAvailable(professor.getId(), agenda.getDataInicio(), 
            agenda.getHorarioInicio(), agenda.getHorarioFim())) {
                throw new RuntimeException("Conflito de horário: o professor já possui uma agenda neste período.");
    }

    // Associa o Curso e o Professor à Agenda
    agenda.setCurso(curso);
    agenda.setProfessor(professor);

    // Salva a agenda no banco de dados
    return agendaRepository.save(agenda);
}


 



    @Override
    public void deleteById(Long id) {
        agendaRepository.deleteById(id); // Deleta a agenda por id
    }

    @Override
public boolean isProfessorAvailable(Long professorId, LocalDate dataInicio, 
                                    LocalTime horarioInicio, LocalTime horarioFim) {
    // Verifica se o professor já possui agendas que conflitam com o horário fornecido
    List<Agenda> agendas = agendaRepository.findConflictingAgendas(
            professorId, dataInicio, horarioInicio, horarioFim);
    return agendas.isEmpty(); // Se a lista está vazia, não há conflitos
}

}
