package com.ac2parte2.ac2parte2.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ac2parte2.ac2parte2.models.Curso;
import com.ac2parte2.ac2parte2.service.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    private CursoService service;

    @GetMapping
    public List<Curso> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Curso getById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public Curso create(@RequestBody Curso curso) { return service.save(curso); }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) { service.deleteById(id); }
}

