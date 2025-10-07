package com.PetCare360.demo.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import lombok.Data;

@Document(collection = "owners")
@Data
public class Owner {
    @Id
    private String id;

    private String name;
    private String phone;
    private String email;

    @DocumentReference(lazy = true)
    @JsonIgnoreProperties({"owner"})
    private List<Pet> pets = new ArrayList<>();

    public Owner() {
        this.pets = new ArrayList<>();
    }
}