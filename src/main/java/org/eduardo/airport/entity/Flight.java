package org.eduardo.airport.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String description;

    @ManyToOne
    @JoinColumn(name = "origin_id")
    AirPort origin;

    @ManyToOne
    @JoinColumn(name = "destiny_id")
    AirPort destiny;

    Date boardTime;
}
