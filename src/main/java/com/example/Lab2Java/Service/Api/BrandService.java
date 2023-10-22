package com.example.Lab2Java.Service.Api;

import com.example.Lab2Java.Entity.Brand;

import java.util.List;

public interface BrandService {

//    List<Brand> find(String name);
    List<Brand> listAll();

    void create(Brand brand);

}
