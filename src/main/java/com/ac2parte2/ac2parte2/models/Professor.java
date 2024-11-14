package com.ac2parte2.ac2parte2.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor  // Construtor com todos os parâmetros
@NoArgsConstructor   // Construtor vazio necessário para o JPA
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String rg;
    private String endereco;
    private String celular;

    // Relacionamento muitos para muitos com Cursos
    @ManyToMany
    @JoinTable(
        name = "professor_curso",
        joinColumns = @JoinColumn(name = "professor_id"),
        inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private List<Curso> cursos = new ArrayList<>(); // Inicializando a lista de cursos

    // Relacionamento um para muitos com Agenda
    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, orphanRemoval = true)
    
    private List<Agenda> agendas = new ArrayList<>(); // Inicializando a lista de agendas

    // Construtor sem cursos (caso o professor não tenha cursos inicialmente)
    public Professor(String nome, String cpf, String rg, String endereco, String celular) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.celular = celular;
        this.cursos = new ArrayList<>(); // Inicializa a lista de cursos como vazia
    }
}
