package com.ac2parte2.ac2parte2.service;

import java.util.List;
import com.ac2parte2.ac2parte2.models.Curso;

public interface CursoService {
    List<Curso> findAll();
    Curso findById(Long id);
    Curso save(Curso curso);
    void deleteById(Long id);
}
