package com.example.ac2.model;

import java.util.ArrayList;


public class Escola {
    private int idEscola;
    private String nome;
    private String endereco;
    private String slogan;
    private double notaMEC;

    // Uma escola tem vários cursos
    private ArrayList<Curso> cursos = new ArrayList<Curso>();

    // ------------------- MÉTODOS -------------------
    public boolean addCurso(Curso curso){
        return cursos.add(curso);
    }

    // ------------------- GETTERS AND SETTERS -------------------
    public int getIdEscola() {
        return idEscola;
    }

    public void setIdEscola(int idEscola) {
        this.idEscola = idEscola;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public double getNotaMEC() {
        return notaMEC;
    }

    public void setNotaMEC(double notaMEC) {
        this.notaMEC = notaMEC;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }
    
    // ------------------- TO STRING -------------------

    


}
