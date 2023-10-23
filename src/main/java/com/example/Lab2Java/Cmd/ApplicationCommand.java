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

            System.out.println("\nAvailable commands:\n" +
                "get_brands - lists all brands\n" +
                "get_models - lists all models from all brands\n" +
                "delete_model\n" +
                "add_model - lets create new model under the existing brand\n" +
                "quit - to quit the app\n");

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
                    System.out.println("brand name:" + brandName);

                    System.out.println("please provide model name:");
                    String modelName = scanner.nextLine();
                    System.out.println("model: " + modelName);

                    modelService.deleteModel(brandName, modelName);

                    modelService.listAll().forEach(System.out::println);
                }
                case "add_model" -> {
                    System.out.println("please provide uuid:");
                    String uuid = scanner.nextLine();
                    System.out.println("uuid: " + uuid);

                    System.out.println("please provide brand name");
                    String brandName = scanner.nextLine();
                    System.out.println("brand:"+brandName);

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

                    modelService.addModelToBrand(brandName,
                        Model.builder()
                        .uuid(UUID.fromString(uuid))
                        .name(name)
                        .price(price)
                        .announceYear(year)
                        .build()
                    );

                    modelService.listAll().forEach(System.out::println);
                }
                case "quit" -> loop = false;
            }
        }
    }
}

// example UUIDs:
//  e6f6f3da-7986-468a-96c6-9c29649e3411
//  8d3d10dc-f842-44cf-acce-86304603325c
