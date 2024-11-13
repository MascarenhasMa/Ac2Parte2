package com.ac2parte2.ac2parte2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ac2parte2.ac2parte2.models.Curso;
import com.ac2parte2.ac2parte2.models.Professor;
import com.ac2parte2.ac2parte2.service.CursoService;
import com.ac2parte2.ac2parte2.service.ProfessorService;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;
    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<Professor> getAll() { return professorService.findAll(); }

    @GetMapping("/{id}")
    public Professor getById(@PathVariable Long id) { return professorService.findById(id); }

    @PostMapping
    public Professor create(@RequestBody Professor professor) { return professorService.save(professor); }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {professorService.deleteById(id); }

    @PostMapping("/{professorId}/cursos/{cursoId}")
    public ResponseEntity<String> addCursoToProfessor(@PathVariable Long professorId, @PathVariable Long cursoId) {
        Professor professor = professorService.findById(professorId);
        Curso curso = cursoService.findById(cursoId);

        if (professor == null || curso == null) {
            return ResponseEntity.notFound().build();
        }

        professor.getCursos().add(curso);
        professorService.save(professor);

        return ResponseEntity.ok("Curso adicionado ao professor com sucesso!");
    }
}






