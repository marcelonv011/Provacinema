package com.example.cinema.model;

public class Sessoes {

    private int idsessoes;
    private String dia;
    private String horario;
    private String idioma;
    private float preco;


    public Sessoes(){}

    public Sessoes(String dia, String horario, String idioma, float preco) {
        this.dia = dia;
        this.horario = horario;
        this.idioma = idioma;
        this.preco = preco;
    }

    public int getIdsessoes() {
        return idsessoes;
    }

    public void setIdsessoes(int idsessoes) {
        this.idsessoes = idsessoes;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Sessoes{" +
                "idsessoes=" + idsessoes +
                ", dia='" + dia + '\'' +
                ", horario='" + horario + '\'' +
                ", idioma='" + idioma + '\'' +
                ", preco='" + preco + '\'' +
                '}';
    }
}