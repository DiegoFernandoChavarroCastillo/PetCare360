package com.PetCare360.demo.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "veterinarians")
@Data
public class Veterinarian {
    @Id
    private String id;

    private String name;
    private String specialty;
}
