package com.example.ac2.model;

public class Curso {
    private int idCurso;
    private String nomeCurso;
    private double valor;
    private int likes;
    private String duracao;
    private Escola escola;

    // ------------------- GETTERS AND SETTERS -------------------
    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public Escola getEscola() {
        return escola;
    }
    
    public void setEscola(Escola escola) {
        this.escola = escola;
    }


}
