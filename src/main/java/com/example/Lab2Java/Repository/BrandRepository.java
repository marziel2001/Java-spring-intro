package com.example.Lab2Java.Repository;

import com.example.Lab2Java.Entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BrandRepository extends JpaRepository<Brand, UUID> {

    List<Brand> findAllByName(String name);


}
