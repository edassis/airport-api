package org.eduardo.airport.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class AirPort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String description;

    String street;
    String addressComplement;
    @OneToOne
    @JoinColumn(name = "state_id")
    State state;
}
