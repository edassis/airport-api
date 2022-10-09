package org.eduardo.airport.service;

import org.eduardo.airport.entity.Country;
import org.eduardo.airport.repository.CountryRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;

@ApplicationScoped
public class CountryService {
    @Inject
    CountryRepository countryRepository;

    @Transactional
    public Country get(Long id) {
        return countryRepository.findById(id);
    }

    @Transactional
    public List<Country> getAll() {
        return countryRepository.listAll();
    }

    @Transactional
    public Country save(Country category) {
        category.setId(null);
        countryRepository.persist(category);

        return category;
    }

    @Transactional
    public Country update(Country category) {
        if(countryRepository.findById(category.getId()) == null) {
            throw new NotFoundException();
        }
        countryRepository.persist(category);
        return category;
    }

    @Transactional
    public void delete(Long id) {
        countryRepository.deleteById(id);
    }
}
