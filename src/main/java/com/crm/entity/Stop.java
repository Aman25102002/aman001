package com.crm.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "stop")
public class Stop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

//    @ManyToMany
//    @JoinTable(name = "stop_buses",
//            joinColumns = @JoinColumn(name = "stop_id"),
//            inverseJoinColumns = @JoinColumn(name = "buses_id"))
//    private Set<Bus> buses = new LinkedHashSet<>();

}