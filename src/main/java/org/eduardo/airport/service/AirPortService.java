package org.eduardo.airport.service;

import org.eduardo.airport.entity.AirPort;
import org.eduardo.airport.entity.Client;
import org.eduardo.airport.repository.AirPortRepository;
import org.eduardo.airport.repository.StateRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;

@ApplicationScoped
public class AirPortService {
    @Inject
    AirPortRepository airPortRepository;
    @Inject
    StateRepository stateRepository;

    @Transactional
    public List<AirPort> getAll() {
        return airPortRepository.listAll();
    }

    @Transactional
    public AirPort get(Long id) {
        return airPortRepository.findById(id);
    }

    @Transactional
    public AirPort save(AirPort airPort) {
        var state = stateRepository.findByIdOptional(airPort.getState().getId()).orElseThrow(() -> new NotFoundException());

        airPort.setId(null);
        airPort.setState(state);
        airPortRepository.persist(airPort);

        return airPort;
    }

    @Transactional
    public AirPort update(AirPort airPort) {
        var state = stateRepository.findByIdOptional(airPort.getState().getId()).orElseThrow(() -> new NotFoundException());
        var airPortDB = airPortRepository.findByIdOptional(airPort.getId()).orElseThrow(() -> new NotFoundException());

        airPortDB.setName(airPort.getName());
        airPortDB.setDescription(airPort.getDescription());
        airPortDB.setStreet(airPort.getStreet());
        airPortDB.setAddressComplement(airPort.getAddressComplement());
        airPortDB.setState(state);

        return airPortDB;
    }

    @Transactional
    public void delete(Long id) {
        airPortRepository.deleteById(id);
    }
}
