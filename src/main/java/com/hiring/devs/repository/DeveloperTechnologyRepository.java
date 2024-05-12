package com.hiring.devs.repository;

import com.hiring.devs.entity.DeveloperTechnology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DeveloperTechnologyRepository extends JpaRepository<DeveloperTechnology,Long> {


}
