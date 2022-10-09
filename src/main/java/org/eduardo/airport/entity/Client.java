package org.eduardo.airport.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String telefone;

    String street;
    String addressComplement;
    @ManyToOne
    @JoinColumn(name = "state_id")
    State state;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;
}
