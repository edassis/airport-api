package org.eduardo.airport.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.eduardo.airport.entity.Country;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CountryRepository implements PanacheRepositoryBase<Country, Long> {}
