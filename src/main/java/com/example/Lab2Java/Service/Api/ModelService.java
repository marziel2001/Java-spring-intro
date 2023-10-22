package com.example.Lab2Java.Service.Api;

import com.example.Lab2Java.Entity.Model;

import java.util.List;

public interface ModelService {

    List<Model> find(String name);

    void create(Model model);

}
