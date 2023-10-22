package com.example.Lab2Java.Service.Api;

import com.example.Lab2Java.Entity.Brand;
import com.example.Lab2Java.Entity.Model;

import java.util.List;
import java.util.Optional;

public interface ModelService {

    Optional<Model> find(String name);

    List<Model> findAllByBrand(String name);
    List<Model> listAll();

    void addModelToBrand(String brand, Model model);

    void deleteModel(String brand, String model);

    void create(Model model);

}
