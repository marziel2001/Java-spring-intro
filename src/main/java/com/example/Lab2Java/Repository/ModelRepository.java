package com.example.Lab2Java.Repository;

import com.example.Lab2Java.Entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ModelRepository extends JpaRepository<Model, UUID> {


    List<Model> findAllByName(String name);


}
