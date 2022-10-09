package org.eduardo.airport.resource;

import lombok.extern.slf4j.Slf4j;
import org.eduardo.airport.entity.Flight;
import org.eduardo.airport.service.FlightService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Slf4j
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/flight")
public class FlightResource {

    @Inject
    FlightService flightService;

    @GET
    public Response getAll() {
        return Response.ok(flightService.getAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") Long ticketId) {
        return Response.ok(flightService.get(ticketId)).build();
    }

    @PUT
    public Response insert(@Valid Flight flight) {
        return Response.created(URI.create(flightService.save(flight).toString())).build();
    }

    @POST
    @Path("/{id}")
    public Response update(@Valid Flight flight) {
        return Response.accepted(flightService.update(flight)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        flightService.delete(id);
        return Response.ok().build();
    }
}
