package com.ac2parte2.ac2parte2.service;

import java.util.List;

import com.ac2parte2.ac2parte2.models.Professor;

public interface ProfessorService {
    List<Professor> findAll();
    Professor findById(Long id);
    Professor save(Professor professor);
    void deleteById(Long id);
    
}
