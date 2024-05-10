package com.hiring.devs.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    private String description;

    @ManyToMany
    private List<Technology> technology;

    @ManyToOne
    private Organization organization;

}
