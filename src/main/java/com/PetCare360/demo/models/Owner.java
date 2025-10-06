package com.PetCare360.demo.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document(collection = "owners")
@Data

public class Owner {
    @Id
    private String id;

    private String name;
    private String phone;
    private String email;
    private List<Pet> pets;

    public Owner(){
        
    }
}
