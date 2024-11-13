package com.ac2parte2.ac2parte2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ac2parte2.ac2parte2.models.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    // Aqui você pode adicionar consultas personalizadas, se necessário
}
