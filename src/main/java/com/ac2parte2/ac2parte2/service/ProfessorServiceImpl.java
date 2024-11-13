package com.ac2parte2.ac2parte2.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ac2parte2.ac2parte2.models.Professor;
import com.ac2parte2.ac2parte2.repositories.ProfessorRepository;

@Service
public class ProfessorServiceImpl implements ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public List<Professor> findAll() { return professorRepository.findAll(); }

    @Override
    public Professor findById(Long id) { return professorRepository.findById(id).orElse(null); }

    @Override
    public Professor save(Professor professor) { return professorRepository.save(professor); }

    @Override
    public void deleteById(Long id) { professorRepository.deleteById(id); }
}

