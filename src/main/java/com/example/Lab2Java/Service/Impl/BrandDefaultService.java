package com.example.Lab2Java.Service.Impl;

import com.example.Lab2Java.Entity.Brand;
import com.example.Lab2Java.Repository.BrandRepository;
import com.example.Lab2Java.Repository.ModelRepository;
import com.example.Lab2Java.Service.Api.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BrandDefaultService implements BrandService {

    private final BrandRepository repository;

    private final ModelRepository modelRepository;

    @Autowired
    public BrandDefaultService(BrandRepository repository, ModelRepository modelRepository) {
        this.repository = repository;
        this.modelRepository = modelRepository;
    }

    @Override
    public List<Brand> listAll() {
        return repository.findAll();
    }

    @Override
    public void create(Brand brand) {
        repository.save(brand);
    }
}
