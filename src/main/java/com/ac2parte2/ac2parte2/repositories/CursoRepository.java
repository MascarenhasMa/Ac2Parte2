package com.ac2parte2.ac2parte2.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ac2parte2.ac2parte2.models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    // Aqui você pode adicionar consultas personalizadas, se necessário
}
