package com.example.Lab2Java.Service.Impl;

import com.example.Lab2Java.Entity.Brand;
import com.example.Lab2Java.Entity.Model;
import com.example.Lab2Java.Repository.BrandRepository;
import com.example.Lab2Java.Repository.ModelRepository;
import com.example.Lab2Java.Service.Api.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelDefaultService implements ModelService {

    private final ModelRepository repository;
    private final BrandRepository brandRepository;

    @Autowired
    public ModelDefaultService(ModelRepository repository, BrandRepository brandRepository) {
        this.repository = repository;
        this.brandRepository = brandRepository;
    }

    @Override
    public Optional<Model> find(String name) {
        return repository.findAllByName(name);
    }

    @Override
    public List<Model> findAllByBrand(String name) {
        return repository.findAllByBrand_Name(name);
    }
    @Override
    public List<Model> listAll() {
        return repository.findAll();
    }

    @Override
    public void addModelToBrand(String brand, Model model)
    {
        Optional<Brand> b = brandRepository.findAllByName(brand);

        if(b.isPresent()) {
            model.setBrand(b.get());
            repository.save(model);
        }
        else {
            System.out.println("Brand does not exist in database");
        }
    }

    @Override
    public void deleteModel(String brand, String model) {
        Optional<Brand> b = brandRepository.findAllByName(brand);



        if(b.isPresent()) {
            brandRepository.findAllByName(brand).get().models.stream().forEach(System.out::println);



//            repository.deleteByName(model);
        }
        else {
            System.out.println("Brand does not exist in database");
        }
    }

    @Override
    public void create(Model model) {
        repository.save(model);
    }
}
