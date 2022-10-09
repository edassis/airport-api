package org.eduardo.airport.resource;

import lombok.extern.slf4j.Slf4j;
import org.eduardo.airport.entity.State;
import org.eduardo.airport.service.StateService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Slf4j
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/state")
public class StateResource {

    @Inject
    StateService stateService;

    @GET
    public Response getAll() {
        return Response.ok(stateService.getAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") Long ticketId) {
        return Response.ok(stateService.get(ticketId)).build();
    }

    @PUT
    public Response insert(@Valid State state) {
        return Response.created(URI.create(stateService.save(state).toString())).build();
    }

    @POST
    @Path("/{id}")
    public Response update(@Valid State state) {
        return Response.accepted(stateService.update(state)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        stateService.delete(id);
        return Response.ok().build();
    }
}
