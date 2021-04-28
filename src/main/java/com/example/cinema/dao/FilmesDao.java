package com.example.cinema.dao;

import com.example.cinema.factory.ConnectionFactory;
import com.example.cinema.model.Filmes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmesDao {

    Connection connection;

    public FilmesDao () {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void cadastraFilmes (Filmes f) {
        String sql = "INSERT INTO filmes" +
                "(nomefilme, diretor, descricaofilme, duracao, idademaxima)" +
                "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, f.getNomefilme());
            stmt.setString(2, f.getDiretor());
            stmt.setString(3, f.getDescricaofilme());
            stmt.setString(4, f.getDuracao());
            stmt.setInt(5, f.getIdademaxima());

            stmt.execute();
            stmt.close();
            System.out.println("funcionou");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Filmes alteraFilmes (Filmes f, int idFilme) {
        String sql = "update filmes set nomefilme=?,diretor=?,descricaofilme=?,duracao=?,idademaxima=? where idFilme =?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1,f.getNomefilme() );
            stmt.setString(2,f.getDiretor() );
            stmt.setString(3,f.getDescricaofilme() );
            stmt.setString(4,f.getDuracao());
            stmt.setInt(5,f.getIdademaxima());
            stmt.setInt(6, f.getIdfilme());
            stmt.execute();
            stmt.close();

            Filmes filmes = new Filmes();
            filmes = this.consultaFilmesPorId(idFilme);

            return filmes;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public Filmes consultaFilmesPorId (int id) {
        String sql = "SELECT * FROM  filmes WHERE idFilme =?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Filmes filmes1 = new Filmes();

            while (rs.next()) {
                filmes1.setIdfilme(rs.getInt("idFilme"));
                filmes1.setNomefilme(rs.getString("nomefilme"));
                filmes1.setDiretor(rs.getString("diretor"));
                filmes1.setDescricaofilme(rs.getString("descricaofilme"));
                filmes1.setDuracao(rs.getString("duracao"));
                filmes1.setIdademaxima(rs.getInt("Idademaxima"));
            }
            return filmes1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Filmes> listaDeFilmes () {
        String sql = "SELECT * FROM filmes";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            List<Filmes> filmes = new ArrayList<>();

            ResultSet resultSet = st.executeQuery();

            Filmes filme;
            while (resultSet.next()) {
                filme = new Filmes();
                filme.setIdfilme(resultSet.getInt("idFilmes"));
                filme.setNomefilme(resultSet.getString("nomefilme"));
                filme.setDiretor(resultSet.getString("diretor"));
                filme.setDescricaofilme(resultSet.getString("descricaofilme"));
                filme.setDuracao(resultSet.getString("duracao"));
                filme.setIdademaxima(resultSet.getInt("idademaxima"));


                filmes.add(filme);
            }
            return filmes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeFilmes(int idFilmes){
        try {
            PreparedStatement stmt=connection.prepareStatement("delete from filmes where idFilmes=?");
            stmt.setInt(1,idFilmes);
            stmt.execute();
            stmt.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
