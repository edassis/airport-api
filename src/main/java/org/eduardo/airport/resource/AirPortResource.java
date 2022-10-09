package org.eduardo.airport.resource;

import lombok.extern.slf4j.Slf4j;
import org.eduardo.airport.entity.AirPort;
import org.eduardo.airport.service.AirPortService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Slf4j
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/airport")
public class AirPortResource {

    @Inject
    AirPortService airPortService;

    @GET
    public Response getAll() {
        return Response.ok(airPortService.getAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") Long ticketId) {
        return Response.ok(airPortService.get(ticketId)).build();
    }

    @PUT
    public Response insert(@Valid AirPort airPort) {
        return Response.created(URI.create(airPortService.save(airPort).toString())).build();
    }

    @POST
    @Path("/{id}")
    public Response update(@Valid AirPort airPort) {
        return Response.accepted(airPortService.update(airPort)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        airPortService.delete(id);
        return Response.ok().build();
    }
}
