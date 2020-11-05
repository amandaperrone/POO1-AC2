package com.example.ac2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.ac2.dto.CursoDTO;
import com.example.ac2.model.Curso;
import com.example.ac2.model.Escola;
import com.example.ac2.repository.CursoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CursoService {
    
    @Autowired
    private CursoRepository repCurso;

    @Autowired
    private EscolaService escolaService;

    public CursoDTO toDTO(Curso curso){
        CursoDTO cursodto = new CursoDTO();
        cursodto.setNomeCurso(curso.getNomeCurso());
        cursodto.setIdCurso(curso.getIdCurso());
        cursodto.setLikes(curso.getLikes());
        cursodto.setValor(curso.getValor());
        cursodto.setDuracao(curso.getDuracao());
        return cursodto;
    } 

    public List<CursoDTO> toListDTO(List<Curso> listaCurso){
        ArrayList<CursoDTO> aux = new ArrayList<CursoDTO>();
        for (Curso c: listaCurso){
            aux.add(toDTO(c));
        }
        return aux;
    }

    public Curso cadastrarCurso(Curso curso, int id){
        Escola escola = escolaService.getEscolaByID(id);
        curso.setEscola(escola);
        escola.addCurso(curso);
        return repCurso.cadastrarCurso(curso);
    }

    public List<Curso> getAllCursos(){
        return repCurso.getAllCursos();
    }

    public Curso getCursoByID(int id){
        Optional<Curso> op = repCurso.getCursoByID(id);
        return op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não cadastrado"));
    }

    public void removerCurso(int id){
        repCurso.removerCurso(getCursoByID(id));
    }

    public Curso alterarCurso(Curso curso){
        getCursoByID(curso.getIdCurso());
        return repCurso.alterarCurso(curso);
    }
    
    
}
