package org.eduardo.airport.resource;

import lombok.extern.slf4j.Slf4j;
import org.eduardo.airport.entity.Category;
import org.eduardo.airport.entity.Country;
import org.eduardo.airport.service.CountryService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Slf4j
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/country")
public class CountryResource {

    @Inject
    CountryService countryService;

    @GET
    public Response getAll() {
        return Response.ok(countryService.getAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") Long ticketId) {
        return Response.ok(countryService.get(ticketId)).build();
    }

    @PUT
    public Response insert(@Valid Country country) {
        return Response.created(URI.create(countryService.save(country).toString())).build();
    }

    @POST
    @Path("/{id}")
    public Response update(@Valid Country country) {
        return Response.accepted(countryService.update(country)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        countryService.delete(id);
        return Response.ok().build();
    }
}
