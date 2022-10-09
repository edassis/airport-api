package org.eduardo.airport.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.eduardo.airport.entity.Ticket;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TicketRepository implements PanacheRepositoryBase<Ticket, Long> {}
