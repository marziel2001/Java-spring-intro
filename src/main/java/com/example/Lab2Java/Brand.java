package com.example.Lab2Java;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.util.LinkedList;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "brands")
public class Brand implements Comparable<Brand>, Serializable {
    @Id
    private String name;
    private Integer yearOfEst;
    private String country;
    private Double brandValueDollars;
    @ToString.Exclude
    public LinkedList<Model> models;

    @Override
    public int compareTo(Brand o) {
        if(this.equals(o) && (this.hashCode() == o.hashCode())) {
            return 0;
        }
        else {
            return this.name.toLowerCase().compareTo(o.name.toLowerCase());
        }
    }
}
