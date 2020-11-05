package com.example.ac2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.ac2.model.Curso;
import com.example.ac2.model.Escola;
import com.example.ac2.repository.EscolaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EscolaService {

    @Autowired
    private EscolaRepository respositorioE;

    public List<Escola> getAllEscolas() {
        return respositorioE.getAllEscolas();
    }

    public Escola getEscolaByID(int id){
        Optional<Escola> op = respositorioE.getEscolaByID(id);
        return op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Escola não encontrada"));
    }

    public Escola cadastrarEscola(Escola escola){
        return respositorioE.cadastrarEscola(escola);
    }

    public void removerEscolaByID(int id){
        // adicionar condição de deletar
        Escola escola = getEscolaByID(id);
        if (escola.getCursos().size() > 0){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Escola possui cursos, por isso não pode ser apagada");
        }
        respositorioE.removerEscola(getEscolaByID(id));
    }

    public Escola alterarEscola(Escola escola){
        getEscolaByID(escola.getIdEscola());
        return respositorioE.alterarEscola(escola);
    }

    public ArrayList<Curso> cursosEscola(Escola escola){
        return respositorioE.cursosEscola(escola);
    }
    
}
