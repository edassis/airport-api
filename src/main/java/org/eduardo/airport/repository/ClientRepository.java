package org.eduardo.airport.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.eduardo.airport.entity.Client;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class ClientRepository implements PanacheRepositoryBase<Client, Long> {}
