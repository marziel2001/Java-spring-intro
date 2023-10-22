package com.example.Lab2Java.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "model_dtos")
public class ModelDto implements Comparable<ModelDto> {

    @Id
    private UUID uuid;

    @Column(name = "brand_name")
    private String brandName;

    private String name;

    private Double price;

    @Column(name = "announce_date")
    private Integer announceDate;

    @Override
    public int compareTo(ModelDto o) {
        if(this.equals(o) && (this.hashCode() == o.hashCode())) {
            return 0;
        }
        else {
            int markaComparsionValue = this.brandName.toLowerCase().compareTo(o.brandName.toLowerCase());

            if(markaComparsionValue == 0) {
                return this.name.toLowerCase().compareTo(o.name.toLowerCase());
            }
            else return markaComparsionValue;
        }
    }
}
