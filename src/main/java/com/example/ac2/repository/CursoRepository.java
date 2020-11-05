package com.example.ac2.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.ac2.model.Curso;

import org.springframework.stereotype.Component;

@Component
public class CursoRepository {
    
    private List<Curso> cursos = new ArrayList<Curso>();
    private int nextIdCurso = 1;

    public Curso cadastrarCurso(Curso curso){
        curso.setIdCurso(nextIdCurso++);
        cursos.add(curso);
        return curso;
    }

    public List<Curso> getAllCursos(){
        return cursos;
    }

    public Optional<Curso> getCursoByID(int id){
        for (Curso aux: cursos){
            if(aux.getIdCurso() == id){
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }

    public void removerCurso(Curso curso){
        cursos.remove(curso);
    }

    public Curso alterarCurso(Curso curso){
        Curso aux = getCursoByID(curso.getIdCurso()).get();

        if(aux!=null){
            aux.setLikes(curso.getLikes());
        }

        return aux;
    }
    

}
