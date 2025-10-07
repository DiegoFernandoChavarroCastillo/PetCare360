package com.PetCare360.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import lombok.Data;

@Document(collection = "pets")
@Data
public class Pet {
    @Id
    private String id;

    private String name;
    private String breed;
    private int age;


}