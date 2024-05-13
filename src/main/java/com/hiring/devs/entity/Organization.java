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
@Table(name = "organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "organization_name", unique = true)
    private String organization_name;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "contact_email")
    private String contact_email;

    @Column(name = "org_adress")
    private String org_adress;

    @Column(name = "org_city")
    private String org_city;

    @Column(name = "org_state")
    private String org_state;

    @Column(name = "password")
    private String password;

    @OneToMany
    private List<Position> position;

}
