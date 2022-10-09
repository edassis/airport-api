package org.eduardo.airport.resource;

import lombok.extern.slf4j.Slf4j;
import org.eduardo.airport.service.TicketService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Slf4j
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/ticket")
public class TicketResource {

    @Inject
    TicketService ticketService;

    @GET
    public Response getAll() {
        return Response.ok(ticketService.getAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") Long ticketId) {
        return Response.ok(ticketService.get(ticketId)).build();
    }

    @PUT
    @Path("/buy/{clientId}/{flightId}")
    public Response buyTicket(@PathParam("clientId") Long clientId, @PathParam("flightId") Long flightId) {
        return Response.created(URI.create(ticketService.buyTicket(clientId, flightId).toString())).build();
    }

    @POST
    @Path("/check-in/{id}")
    public Response checkIn(@PathParam("id") Long id) {
        return Response.accepted(ticketService.checkIn(id)).build();
    }

    @POST
    @Path("/on-board/{id}")
    public Response OnBoard(@PathParam("id") Long id) {
        return Response.accepted(ticketService.OnBoard(id)).build();
    }
}
