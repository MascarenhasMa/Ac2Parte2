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
import com.ac2parte2.ac2parte2.models.Agenda;
import com.ac2parte2.ac2parte2.service.AgendaService;

@RestController
@RequestMapping("/agendas")
public class AgendaController {
    @Autowired
    private AgendaService service;

    @GetMapping
    public List<Agenda> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Agenda getById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public Agenda create(@RequestBody Agenda agenda) { System.out.println("Criando agenda: " + agenda); return service.save(agenda); }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) { service.deleteById(id); }
}
