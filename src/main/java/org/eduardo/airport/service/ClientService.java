package org.eduardo.airport.service;

import org.eduardo.airport.entity.Client;
import org.eduardo.airport.repository.CategoryRepository;
import org.eduardo.airport.repository.ClientRepository;
import org.eduardo.airport.repository.StateRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotAllowedException;
import javax.ws.rs.NotFoundException;

@ApplicationScoped
public class ClientService {

    @Inject
    ClientRepository clientRepository;

    @Inject
    StateRepository stateRepository;

    @Inject
    CategoryRepository categoryRepository;

    @Transactional
    public Client getByID(Long id) {
        return clientRepository.findById(id);
    }

    @Transactional
    public Client insert(Client client) {
        var category = categoryRepository.findByIdOptional(client.getCategory().getId()).orElseThrow(() -> new NotFoundException());
        var state = stateRepository.findByIdOptional(client.getState().getId()).orElseThrow(() -> new NotFoundException());

        client.setId(null);
        client.setCategory(category);
        client.setState(state);
        clientRepository.persist(client);

        return client;
    }

    @Transactional
    public Client update(Client client) {
        if(clientRepository.findById(client.getId()) == null) {
            throw new NotFoundException();
        }
        clientRepository.persist(client);
        return client;
    }

    @Transactional
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    public void OnBoardAttendance(Long id) {
        var client = clientRepository.findByIdOptional(id).orElseThrow(() -> new NotFoundException());
        if(!client.getCategory().getName().equals("Executive")) {
            throw new NotAllowedException("Client isn't from Executive class.");
        }
    }
}
