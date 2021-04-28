package com.example.cinema;

import javax.ws.rs.*;

@Path("/hello-world")
public class HelloResource {
    @GET
    @Produces("aplication/plain")
    public String listaProdutos() {
        return "Hello, World!";
    }

    @GET
    @Path("pt-br")
    @Produces("text/plain")
    public String alomundo() {
        return "alomundo!";
    }
}

