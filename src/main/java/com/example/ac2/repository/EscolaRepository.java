package com.example.ac2.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import com.example.ac2.model.Curso;
import com.example.ac2.model.Escola;

import org.springframework.stereotype.Component;

@Component
public class EscolaRepository {
    private List<Escola> escolas;
    private int nextIdEscola;

    @PostConstruct
    public void criarEscolas(){
        Escola e1 = new Escola();
        e1.setIdEscola(1);
        e1.setNome("Bonitas Artes");
        e1.setEndereco("Rua 9 de Julho, 123");
        e1.setSlogan("Ensinar com alegria");
        e1.setNotaMEC(4);

        Escola e2 = new Escola();
        e2.setIdEscola(2);
        e2.setNome("Unicampos");
        e2.setEndereco("Rua 15 de Maio, 321");
        e2.setSlogan("Aprender com quem sabe");
        e2.setNotaMEC(5);

        escolas = new ArrayList<Escola>();
        escolas.add(e1);
        escolas.add(e2);
        nextIdEscola = 3;
    }

    public List<Escola> getAllEscolas(){
        return escolas;
    }

    public Optional<Escola> getEscolaByID (int id){
        for (Escola aux: escolas){
            if (aux.getIdEscola() == id) {
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }

    public Escola cadastrarEscola(Escola escola){
        escola.setIdEscola(nextIdEscola++);
        escolas.add(escola);
        return escola;
    }
    /*
    public Optional<Escola> removerEscola(Escola escola){
        aux = 
        if(escola.getCursos() != null){
            escolas.remove(escola);
            System.out.println("Excluído com sucesso");
            return Optional.empty();
        } else {
            return Optional.of("value");
        }
        
    }*/

    public Escola alterarEscola(Escola escola){
        Escola aux = getEscolaByID(escola.getIdEscola()).get();

        if(aux!=null){
            aux.setEndereco(escola.getEndereco());
            aux.setNotaMEC(escola.getNotaMEC());
        }

        return aux;
    }

    public ArrayList<Curso> cursosEscola(Escola escola){
        return escola.getCursos();
    }
    
}
