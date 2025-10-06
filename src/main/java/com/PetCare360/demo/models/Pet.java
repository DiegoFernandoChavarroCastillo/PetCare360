package com.PetCare360.demo.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document(collection = "pets")
@Data
public class Pet {
    @Id
    private String id;

    private String name;
    private String breed;
    private int age;
    private Owner owner;
}
