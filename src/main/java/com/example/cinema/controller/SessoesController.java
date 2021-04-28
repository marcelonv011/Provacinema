package com.example.cinema.controller;


import com.example.cinema.dao.*;
import com.example.cinema.model.*;
import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("sessoes")

public class SessoesController {
    @GET
    @Produces("application/json")
    public Response listaSessoes () {
        SessoesDao sessoesDao = new SessoesDao();
        List<Sessoes> sessoes = sessoesDao.listaDeSessoes();
        return Response.ok(new Gson().toJson(sessoes)).build();
    }

    @GET
    @Path("{idsessoe}")
    @Produces("application/json")
    public Response getIdSessoes(@PathParam("idsessoe") int id) {
        SessoesDao sessoesDao = new SessoesDao();
        Sessoes sessoe = sessoesDao.consultaSessoesPorId(id);
        return Response.ok(new Gson().toJson(sessoe)).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response criarSessoes (Sessoes sessoes) {
        SessoesDao sessoesDao = new SessoesDao();
        sessoesDao.cadastraSessoes(sessoes);
        return Response.ok(new Gson().toJson("Cadastrado!!!"+sessoes)).build();
    }

    @PUT
    @Path("editar/{idsessoe}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response modificaSessoes (Sessoes sessoes, @PathParam("idsessoe") int id) {
        SessoesDao sessoesDao = new SessoesDao();
        if (sessoesDao.consultaSessoesPorId(id) != null) {
            Sessoes result = sessoesDao.alteraSessoes(sessoes, id);
            return Response.ok(new Gson().toJson(result)).build();
        } else {
            return null;
        }
    }

    @DELETE
    @Path("{idSessoe}")
    @Produces("application/json")
    public Response deletarSessoes (Sessoes sessoes, @PathParam("idsessoe") int id) {
        SessoesDao sessoesDao = new SessoesDao();
        sessoesDao.removeSessoes(id);
        return Response.ok("removido com sucesso!!!").build();
    }
}
