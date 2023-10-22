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

        Brand sony = Brand.builder()
            .uuid(UUID.fromString("94c2b18d-9218-476e-8d66-5a2543ee6068"))
            .name("Sony")
            .country("Japan")
            .brandValueDollars(10800000000.00)
            .yearOfEst(1946)
            .build();

        Brand nikon = Brand.builder()
            .uuid(UUID.fromString("91d92bfc-a095-498d-926d-d7199ae2294f"))
            .name("Nikon")
            .country("Japan")
            .brandValueDollars(3450000000.00)
            .yearOfEst(1917)
            .build();

        brandService.create(nikon);
        brandService.create(sony);

        Model a7_iii = Model.builder()
            .uuid(UUID.fromString("99be6917-1f24-4a0e-b5b4-377cedc24ce5"))
            .name("Alpha A7 III")
            .price(1998.00)
            .announceYear(2018)
            .brand(sony)
            .build();

        Model rx100 = Model.builder()
            .uuid(UUID.fromString("8d11bde4-a1c6-434d-b799-2e1ed67604d4"))
            .name("Cyber-shot RX100 VII")
            .price(1298.00)
            .announceYear(2019)
            .brand(sony)
            .build();

        Model a6600 = Model.builder()
            .uuid(UUID.fromString("f4f43786-7768-46cf-bdd9-50495b007821"))
            .name("Alpha A6600")
            .price(1398.00)
            .announceYear(2019)
            .brand(sony)
            .build();

        modelService.create(a7_iii);
        modelService.create(rx100);
        modelService.create(a6600);

            Model d800 = Model.builder()
                .uuid(UUID.fromString("5abd6fb7-6c94-4df0-b497-33bcc8a0af6b"))
                .name("D800")
                .price(2999.95)
                .announceYear(2012)
                .brand(nikon)
                .build();

            Model d850  = Model.builder()
                .uuid(UUID.fromString("729e14eb-fb57-46e0-b88b-ab601fec0c50"))
                .name("D850")
                .price(3299.95)
                .announceYear(2017)
                .brand(nikon)
                .build();

            Model z6 = Model.builder()
                .uuid(UUID.fromString("9fadd584-8b0f-4e25-8a61-6dc74c8f1e29"))
                .name("Z6")
                .price(1999.95)
                .announceYear(2018)
                .brand(nikon)
                .build();

        modelService.create(d800);
        modelService.create(d850);
        modelService.create(z6);
    }
}
