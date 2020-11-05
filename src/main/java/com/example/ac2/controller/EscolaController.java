package com.example.ac2.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.ac2.dto.CursoDTO;
import com.example.ac2.model.Curso;
import com.example.ac2.model.Escola;
import com.example.ac2.service.CursoService;
import com.example.ac2.service.EscolaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/escolas")
public class EscolaController {
    
    @Autowired
    private EscolaService escolaService;

    @Autowired
    private CursoService cursoService;

    @GetMapping()
    public List<Escola> getEscolas(){
        return escolaService.getAllEscolas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Escola> getEscola(@PathVariable int id){
        Escola escola = escolaService.getEscolaByID(id);
        return ResponseEntity.ok(escola);
    }
    
    @PostMapping()
    public ResponseEntity<Void> salvarEscola(@RequestBody Escola escola, HttpServletRequest request,UriComponentsBuilder builder){
        escola = escolaService.cadastrarEscola(escola);
        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + escola.getIdEscola()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagarEscola(@PathVariable int id){
        escolaService.removerEscolaByID(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Escola> atualizarEscola(@PathVariable int id, @RequestBody Escola escola){
        escola.setIdEscola(id);
        escola = escolaService.alterarEscola(escola);
        return ResponseEntity.ok(escola);
    }

    @PostMapping("{id}/cursos")
    public ResponseEntity<Void> cadastrarCurso(@PathVariable int id, @RequestBody Curso curso, HttpServletRequest request, UriComponentsBuilder builder) {
        curso = cursoService.cadastrarCurso(curso, id);
        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + curso.getIdCurso()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @GetMapping("{id}/cursos") //fazer o mesmo para pegar os cursos de uma escola (GET MAPPING) para devolver os cursos da escola
    public List<CursoDTO> getAllCursosEscola(@PathVariable int id) {
        Escola escola = escolaService.getEscolaByID(id); 
        return cursoService.toListDTO(escola.getCursos());
    }
    
}
