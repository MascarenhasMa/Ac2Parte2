package com.ac2parte2.ac2parte2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.ac2parte2.ac2parte2.models.Professor;
import com.ac2parte2.ac2parte2.models.Curso;
import com.ac2parte2.ac2parte2.repositories.ProfessorRepository;
import com.ac2parte2.ac2parte2.repositories.CursoRepository;
import java.util.List;

@SpringBootApplication
public class Ac2parte2Application {

    @Bean
    public CommandLineRunner init(
            @Autowired ProfessorRepository professorRepository,
            @Autowired CursoRepository cursoRepository) { 
        return args -> {
            // Criando Professores
System.out.println("*** CRIANDO PROFESSORES ***");
Professor p1 = new Professor("Carlos Silva", "2135546687", "335521455", "Americo 123", "(15)997854124"); // Remova o new ArrayList<>
Professor p2 = new Professor("Ana Costa", "45685245877", "556698421", "Antonio 456", "(16)888999562");
Professor p3 = new Professor("Luis Oliveira", "21358466625", "8888888888", "Artur tarcitane 169", "(18)99999999");

// Salvando os professores no repositório
professorRepository.save(p1);
professorRepository.save(p2);
professorRepository.save(p3);


            // Criando Cursos e associando os Professores
            System.out.println("*** CRIANDO CURSOS ***");
            Curso c1 = new Curso("Matemática", 200, "Descrição Matemática", "Ementa Matemática", p1);
            Curso c2 = new Curso("Física", 300, "Descrição Física", "Ementa Física", p2);
            Curso c3 = new Curso("Química", 500, "Descrição Química", "Ementa Química", p3);

            cursoRepository.save(c1);
            cursoRepository.save(c2);
            cursoRepository.save(c3);

            // Listando Professores
            System.out.println("*** LISTANDO PROFESSORES ***");
            List<Professor> listaProfessores = professorRepository.findAll();
            listaProfessores.forEach(professor -> System.out.println(professor.getNome()));

            // Listando Cursos
            System.out.println("*** LISTANDO CURSOS ***");
            List<Curso> listaCursos = cursoRepository.findAll();
            listaCursos.forEach(curso -> System.out.println(curso.getDescricao()));

            // Associação dos Professores aos Cursos
            System.out.println("*** ASSOCIANDO PROFESSORES AOS CURSOS ***");
            System.out.println("Professor " + p1.getNome() + " ensina o curso: " + c1.getDescricao());
            System.out.println("Professor " + p2.getNome() + " ensina o curso: " + c2.getDescricao());
            System.out.println("Professor " + p3.getNome() + " ensina o curso: " + c3.getDescricao());
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Ac2parte2Application.class, args);
    }
}
