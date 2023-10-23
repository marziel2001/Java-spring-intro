package com.example.Lab2Java.Repository;

import com.example.Lab2Java.Entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ModelRepository extends JpaRepository<Model, UUID> {

    List<Model> findAllByBrand_Name(String name);

    Optional<Model> findAllByName(String name);

    List<Model> findAll();
}
