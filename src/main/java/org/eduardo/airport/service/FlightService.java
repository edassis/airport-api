package org.eduardo.airport.service;

import org.eduardo.airport.entity.Flight;
import org.eduardo.airport.repository.FlightRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;

@ApplicationScoped
public class FlightService {
    @Inject
    FlightRepository flightRepository;

    @Transactional
    public Flight get(Long id) {
        return flightRepository.findById(id);
    }

    @Transactional
    public List<Flight> getAll() {
        return flightRepository.listAll();
    }

    @Transactional
    public Flight save(Flight category) {
        category.setId(null);
        flightRepository.persist(category);

        return category;
    }

    @Transactional
    public Flight update(Flight category) {
        if(flightRepository.findById(category.getId()) == null) {
            throw new NotFoundException();
        }
        flightRepository.persist(category);
        return category;
    }

    @Transactional
    public void delete(Long id) {
        flightRepository.deleteById(id);
    }
}