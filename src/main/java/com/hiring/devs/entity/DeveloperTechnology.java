package com.hiring.devs.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.ComponentScan;

@Getter
@Setter
//@Entity
//@Table(name = "developer_technology")
public class DeveloperTechnology {

//    @Id
//    private Long id;

//    agregar entiti me obliga a usar un id y se agrega el id a la tbal de ruptura

    private Long developer_id;

    private Long technology_id;

}
