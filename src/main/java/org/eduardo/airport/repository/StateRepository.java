package org.eduardo.airport.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.eduardo.airport.entity.State;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StateRepository implements PanacheRepositoryBase<State, Long> {}
