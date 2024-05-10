package com.hiring.devs.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Technology {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Lob
    private byte[] logo;

    @ManyToMany(mappedBy = "technology")
    private List<Position> position;

    @ManyToMany(mappedBy = "technology")
    private List<Developer> developer;

}
