package com.example.cinema.model;

public class Filmes {
    private int idfilme;
    private String nomefilme;
    private String diretor;
    private String descricaofilme;
    private String duracao;
    private int idademaxima;


    public Filmes(){}

    public Filmes(String nomefilme, String diretor, String descricaofilme, String duracao, int idademaxima) {
        this.nomefilme = nomefilme;
        this.diretor = diretor;
        this.descricaofilme = descricaofilme;
        this.duracao = duracao;
        this.idademaxima = idademaxima;
    }

    public int getIdfilme() {
        return idfilme;
    }

    public void setIdfilme(int idfilme) {
        this.idfilme = idfilme;
    }

    public String getNomefilme() {
        return nomefilme;
    }

    public void setNomefilme(String nomefilme) {
        this.nomefilme = nomefilme;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getDescricaofilme() {
        return descricaofilme;
    }

    public void setDescricaofilme(String descricaofilme) {
        this.descricaofilme = descricaofilme;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public int getIdademaxima() {
        return idademaxima;
    }

    public void setIdademaxima(int idademaxima) {
        this.idademaxima = idademaxima;
    }

    @Override
    public String toString() {
        return "Filmes{" +
                "idfilme=" + idfilme +
                ", nomefilme='" + nomefilme + '\'' +
                ", diretor='" + diretor + '\'' +
                ", descricaofilme='" + descricaofilme + '\'' +
                ", duracao='" + duracao + '\'' +
                ", idademaxima='" + idademaxima + '\'' +
                '}';
    }
}
