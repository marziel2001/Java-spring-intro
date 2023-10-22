package com.example.Lab2Java.Repository;

import com.example.Lab2Java.ModelDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ModelDtoRespository extends JpaRepository<ModelDto, UUID> {

    List<ModelDto> findAllByName(String name);

}
