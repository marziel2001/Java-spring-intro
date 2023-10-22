package com.example.Lab2Java.Service.Impl;

import com.example.Lab2Java.Entity.Model;
import com.example.Lab2Java.Repository.ModelRepository;
import com.example.Lab2Java.Service.Api.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelDefaultService implements ModelService {

    private final ModelRepository repository;

    @Autowired
    public ModelDefaultService(ModelRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Model> find(String name) {
        return repository.findAllByName(name);
    }

    @Override
    public void create(Model model) {
        repository.save(model);
    }
}
