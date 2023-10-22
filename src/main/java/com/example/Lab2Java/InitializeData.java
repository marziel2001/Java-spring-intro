package com.example.Lab2Java;

import com.example.Lab2Java.Entity.Brand;
import com.example.Lab2Java.Entity.Model;
import com.example.Lab2Java.Service.Api.BrandService;
import com.example.Lab2Java.Service.Api.ModelService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {
    private final BrandService brandService;

    private final ModelService modelService;

    @Autowired
    public InitializeData(BrandService brandService, ModelService modelService) {
        this.brandService = brandService;
        this.modelService = modelService;
    }


    @Override
    public void afterPropertiesSet() throws Exception {

        System.out.println("starting initialization");

        Brand sony = Brand.builder()
            .uuid(UUID.fromString("94c2b18d-9218-476e-8d66-5a2543ee6068"))
            .name("Nikon")
            .country("Japan")
            .brandValueDollars(3450000000.00)
            .yearOfEst(1917)
            .build();

        brandService.create(sony);

        Model a7_iii = Model.builder()
            .uuid(UUID.fromString("99be6917-1f24-4a0e-b5b4-377cedc24ce5"))
            .name("Alpha A7 III")
            .price(1998.00)
            .announceYear(2018)
            .brand(sony)
            .build();

        modelService.create(a7_iii);

        System.out.println(brandService.findAll("Nikon"));

        System.out.println("Data initialized");
    }
}
