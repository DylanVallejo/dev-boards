package com.hiring.devs.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Entity
@Data
@DynamicInsert
@DynamicUpdate
public class Technology {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private Boolean is_framework;

    @Lob
    private byte[] logo;

    @ManyToMany(mappedBy = "technology", fetch = FetchType.LAZY)
    private List<Position> position;

    @ManyToMany(mappedBy = "technology", fetch = FetchType.LAZY)
    private List<Developer> developer;



}
