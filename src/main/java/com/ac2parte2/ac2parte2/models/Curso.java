package com.ac2parte2.ac2parte2.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer cargaHoraria;
    private String descricao;
    private String ementa;

    // Relacionamento muitos para muitos com Professores
    @ManyToMany(mappedBy = "cursos")
    private List<Professor> professores = new ArrayList<>();

    public Curso(String nome, Integer cargaHoraria, String descricao, String ementa, Professor professor) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.descricao = descricao;
        this.ementa = ementa;
        this.professores.add(professor);
    }
}
