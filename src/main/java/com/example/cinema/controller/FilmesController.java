package com.example.cinema.controller;

import com.example.cinema.dao.*;
import com.example.cinema.model.*;
import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("filmes")

public class FilmesController {
    @GET
    @Produces("application/json")
    public Response listaFilmes () {
        FilmesDao filmesDao = new FilmesDao();
        List<Filmes> filmes = filmesDao.listaDeFilmes();
        return Response.ok(new Gson().toJson(filmes)).build();
    }

    @GET
    @Path("{idfilme}")
    @Produces("application/json")
    public Response getIdFilmes (@PathParam("idFilme") int id) {
        FilmesDao filmesDao = new FilmesDao();
        Filmes filme = filmesDao.consultaFilmesPorId(id);
        return Response.ok(new Gson().toJson(filme)).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response criarfilme (Filmes filmes) {
        FilmesDao filmesDao = new FilmesDao();
        filmesDao.cadastraFilmes(filmes);
        return Response.ok(new Gson().toJson("Cadastrado!!!"+filmes)).build();
    }

    @PUT
    @Path("editar/{idFilme}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response modificaFilmes (Filmes filmes, @PathParam("idFilme") int id) {
        FilmesDao filmesDao = new FilmesDao();
        if (filmesDao.consultaFilmesPorId(id) != null) {
            Filmes result = filmesDao.alteraFilmes(filmes, id);
            return Response.ok(new Gson().toJson(result)).build();
        } else {
            return null;
        }
    }

    @DELETE
    @Path("{idFilme}")
    @Produces("application/json")
    public Response deletarFilmes (Filmes filmes, @PathParam("idFilme") int id) {
        FilmesDao filmesDao = new FilmesDao();
        filmesDao.removeFilmes(id);
        return Response.ok("removido com sucesso!!!").build();
    }
}

