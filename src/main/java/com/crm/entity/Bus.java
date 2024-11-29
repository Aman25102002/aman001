package com.crm.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "bus")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

//    @ManyToMany
//    @JoinTable(name = "bus_stops",
//            joinColumns = @JoinColumn(name = "bus_id"),
//            inverseJoinColumns = @JoinColumn(name = "stops_id"))
//    private Set<Stop> stops = new LinkedHashSet<>();

}