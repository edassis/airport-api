package org.eduardo.airport.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.eduardo.airport.entity.AirPort;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AirPortRepository implements PanacheRepository<AirPort> {}
