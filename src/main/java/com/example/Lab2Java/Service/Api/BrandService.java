package com.example.Lab2Java.Service.Api;

import com.example.Lab2Java.Entity.Brand;

import java.util.List;

public interface BrandService {

    List<Brand> findAll(String name);

    void create(Brand brand);

}
