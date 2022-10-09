package org.eduardo.airport.resource;

import lombok.extern.slf4j.Slf4j;
import org.eduardo.airport.entity.Client;
import org.eduardo.airport.service.ClientService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Slf4j
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/client")
public class ClientResource {

    @Inject
    ClientService clientService;

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") Long id) {
        return Response.ok(clientService.getByID(id)).build();
    }

    @PUT
    public Response insert(@Valid Client client) {
        return Response.created(URI.create(clientService.insert(client).toString())).build();
    }

    @POST
    public Response update(@Valid Client client) {
        return Response.accepted(clientService.update(client)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        clientService.delete(id);
        return Response.ok().build();
    }

    @GET
    @Path("/on-board-service/{id}")
    public Response OnBoardAttendance(@PathParam("id") Long id)  {
        clientService.OnBoardAttendance(id);
        return Response.ok().build();
    }
}
