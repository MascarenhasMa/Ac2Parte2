package com.ac2parte2.ac2parte2.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ac2parte2.ac2parte2.models.Curso;
import com.ac2parte2.ac2parte2.repositories.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<Curso> findAll() { return cursoRepository.findAll(); }

    @Override
    public Curso findById(Long id) { return cursoRepository.findById(id).orElse(null); }

    @Override
    public Curso save(Curso curso) { return cursoRepository.save(curso); }

    @Override
    public void deleteById(Long id) { cursoRepository.deleteById(id); }
}
