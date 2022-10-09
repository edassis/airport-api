package org.eduardo.airport.service;

import org.eduardo.airport.entity.State;
import org.eduardo.airport.repository.StateRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;

@ApplicationScoped
public class StateService {
    @Inject
    StateRepository stateRepository;

    @Transactional
    public State get(Long id) {
        return stateRepository.findById(id);
    }

    @Transactional
    public List<State> getAll() {
        return stateRepository.listAll();
    }

    @Transactional
    public State save(State category) {
        category.setId(null);
        stateRepository.persist(category);

        return category;
    }

    @Transactional
    public State update(State category) {
        if(stateRepository.findById(category.getId()) == null) {
            throw new NotFoundException();
        }
        stateRepository.persist(category);
        return category;
    }

    @Transactional
    public void delete(Long id) {
        stateRepository.deleteById(id);
    }
}
