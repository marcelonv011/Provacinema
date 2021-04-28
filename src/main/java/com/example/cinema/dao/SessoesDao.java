package com.example.cinema.dao;

import com.example.cinema.factory.ConnectionFactory;
import com.example.cinema.model.Filmes;
import com.example.cinema.model.Sessoes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SessoesDao {
    Connection connection;

    public SessoesDao () {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void cadastraSessoes (Sessoes s) {
        String sql = "INSERT INTO filmes" +
                "(dia, horario, idioma, preco)" +
                "VALUES (?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, s.getDia());
            stmt.setString(2, s.getHorario());
            stmt.setString(3, s.getIdioma());
            stmt.setFloat(4, s.getPreco());

            stmt.execute();
            stmt.close();
            System.out.println("funcionou");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Sessoes alteraSessoes(Sessoes s, int idSessoe) {
        String sql = "update sessoes set dia=?,horario=?,idioma=?,preco=?, where idSessoe =?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1,s.getDia() );
            stmt.setString(2,s.getHorario() );
            stmt.setString(3,s.getIdioma() );
            stmt.setFloat(4,s.getPreco());
            stmt.setInt(5,s.getIdsessoes());
            stmt.execute();
            stmt.close();

            Sessoes sessoes = new Sessoes();
            sessoes = this.consultaSessoesPorId(idSessoe);

            return sessoes;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public Sessoes consultaSessoesPorId (int id) {
        String sql = "SELECT * FROM  sessoes WHERE idsessoe =?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Sessoes sessoes1 = new Sessoes();

            while (rs.next()) {
                sessoes1.setIdsessoes(rs.getInt("idsessoe"));
                sessoes1.setDia(rs.getString("dia"));
                sessoes1.setHorario(rs.getString("horario"));
                sessoes1.setIdioma(rs.getString("idioma"));
                sessoes1.setPreco(rs.getFloat("preco"));
            }
            return sessoes1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Sessoes> listaDeSessoes () {
        String sql = "SELECT * FROM sessoes";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            List<Sessoes> sessoes = new ArrayList<>();

            ResultSet resultSet = st.executeQuery();

           Sessoes sessoe;
            while (resultSet.next()) {
                sessoe = new Sessoes();
                sessoe.setIdsessoes(resultSet.getInt("idsessoe"));
                sessoe.setDia(resultSet.getString("dia"));
                sessoe.setHorario(resultSet.getString("horario"));
                sessoe.setIdioma(resultSet.getString("idioma"));
                sessoe.setPreco(resultSet.getFloat("preco"));


                sessoes.add(sessoe);
            }
            return sessoes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeSessoes(int idsessoe){
        try {
            PreparedStatement stmt=connection.prepareStatement("delete from sessoes where idsessao=?");
            stmt.setInt(1,idsessoe);
            stmt.execute();
            stmt.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
