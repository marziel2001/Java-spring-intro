package com.example.Lab2Java.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "models")
public class Model implements Comparable<Model>, Serializable {

    @Id
    private UUID uuid;

    @EqualsAndHashCode.Exclude // to avoid circular dependencies
    @ManyToOne
    @JoinColumn
    private Brand brand;

    private String name;

    private Double price;

    @Column(name = "announce_year")
    private Integer announceYear;

    @Override
    public int compareTo(Model o) {
        if(this.equals(o) && (this.hashCode() == o.hashCode())) {
            return 0;
        }
        else {
            return this.name.toLowerCase().compareTo(o.name.toLowerCase());
        }
    }
}
