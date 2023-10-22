package com.example.Lab2Java.Cmd;

import com.example.Lab2Java.Entity.Model;
import com.example.Lab2Java.Service.Api.BrandService;
import com.example.Lab2Java.Service.Api.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.util.UUID;

@Component
public class ApplicationCommand implements CommandLineRunner {

    private final BrandService service;

    private final ModelService modelService;

    @Autowired
    public ApplicationCommand(BrandService service, ModelService modelService)
    {
        this.service = service;
        this.modelService = modelService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String command;

        boolean loop = true;

        while(loop) {
            command = scanner.nextLine();
            switch (command) {
                case "get_brands" -> {
                    service.listAll().forEach(System.out::println);
                }
                case "get_models" -> {
                    modelService.listAll().forEach(System.out::println);
                }
                case "delete_model" -> {
                    System.out.println("please provide brand name:");
                    String brandName = scanner.nextLine();
                    System.out.println(brandName);

                    System.out.println("please provide model name:");
                    String modelName = scanner.nextLine();
                    System.out.println(modelName);

                    modelService.deleteModel(brandName, modelName);

                    modelService.listAll().forEach(System.out::println);
                }
                case "add_model" -> {

                    System.out.println("please provide uuid:");
                    String uuid = scanner.nextLine();
                    System.out.println("uuid: " + uuid);

                    System.out.println("please provide name:");
                    String name = scanner.nextLine();

                    System.out.println("please provide price [9999,99]:");
                    Double price = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("price:"+price);

                    System.out.println("please provide year:");
                    Integer year = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("year:"+year);

                    System.out.println("please provide brand name");
                    String brandName = scanner.nextLine();
                    System.out.println("brand:"+brandName);

                    modelService.addModelToBrand(brandName,
                        Model.builder()
                        .uuid(UUID.fromString(uuid))
                        .name(name)
                        .price(price)
                        .announceYear(year)
                        .build()
                    );
                }
                case "quit" -> {
                    loop = false;
                }
            }
        }

    }
}
