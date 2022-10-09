package org.eduardo.airport.service;

import org.eduardo.airport.entity.Ticket;
import org.eduardo.airport.repository.ClientRepository;
import org.eduardo.airport.repository.FlightRepository;
import org.eduardo.airport.repository.TicketRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotAllowedException;
import javax.ws.rs.NotFoundException;
import java.util.List;

@ApplicationScoped
public class TicketService {

    @Inject
    TicketRepository ticketRepository;
    @Inject
    ClientRepository clientRepository;
    @Inject
    FlightRepository flightRepository;

    @Transactional
    public List<Ticket> getAll() {
        return ticketRepository.listAll();
    }

    @Transactional
    public Ticket get(Long id) {
        return ticketRepository.findById(id);
    }

    @Transactional
    public Ticket buyTicket(Long clientId, Long flightId) {
        var client = clientRepository.findByIdOptional(clientId).orElseThrow(() -> new NotFoundException());
        var flight = flightRepository.findByIdOptional(flightId).orElseThrow(() -> new NotFoundException());

        var ticket = new Ticket();
        ticket.setClient(client);
        ticket.setFlight(flight);
        ticketRepository.persist(ticket);

        return ticket;
    }

    @Transactional
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    @Transactional
    public Ticket checkIn(Long id) {
        var ticket = ticketRepository.findByIdOptional(id).orElseThrow(() -> new NotFoundException());

        ticket.setCheckedIn(true);

        return ticket;
    }

    @Transactional
    public Object OnBoard(Long id) {
        var ticket = ticketRepository.findByIdOptional(id).orElseThrow(() -> new NotFoundException());

        if (!ticket.getCheckedIn()) {
            throw new NotAllowedException("Client didn't checked in.");
        }

        ticket.setClientOnBoard(true);

        return ticket;
    }
}
