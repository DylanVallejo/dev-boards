package com.hiring.devs.repository;


import com.hiring.devs.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {
    Developer findByEmail(@Param("email") String email);

}
