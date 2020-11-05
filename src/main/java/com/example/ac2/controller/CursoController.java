package com.example.ac2.controller;

import java.util.List;

import com.example.ac2.model.Curso;
import com.example.ac2.service.CursoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping ("/cursos")
public class CursoController {
    
    @Autowired
    private CursoService cursoService;

    @GetMapping()
    public List<Curso> getAllCursos(){
        return cursoService.getAllCursos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> getCursoByID (@PathVariable int id){
        Curso curso = cursoService.getCursoByID(id);
        return ResponseEntity.ok(curso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagarCurso(@PathVariable int id){
        cursoService.removerCurso(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> atualizarCurso(@PathVariable int id, @RequestBody Curso curso){
        curso.setIdCurso(id);
        curso = cursoService.alterarCurso(curso);
        return ResponseEntity.ok(curso);
    }

}
