package org.eduardo.airport.resource;

import lombok.extern.slf4j.Slf4j;
import org.eduardo.airport.entity.Category;
import org.eduardo.airport.service.CategoryService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Slf4j
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/category")
public class CategoryResource {

    @Inject
    CategoryService categoryService;

    @GET
    public Response getAll() {
        return Response.ok(categoryService.getAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") Long ticketId) {
        return Response.ok(categoryService.get(ticketId)).build();
    }

    @PUT
    public Response insert(@Valid Category category) {
        return Response.created(URI.create(categoryService.save(category).toString())).build();
    }

    @POST
    @Path("/{id}")
    public Response update(@Valid Category category) {
        return Response.accepted(categoryService.update(category)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        categoryService.delete(id);
        return Response.ok().build();
    }
}
