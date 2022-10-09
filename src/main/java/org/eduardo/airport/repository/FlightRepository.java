package org.eduardo.airport.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.eduardo.airport.entity.Flight;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FlightRepository implements PanacheRepositoryBase<Flight, Long> {}
