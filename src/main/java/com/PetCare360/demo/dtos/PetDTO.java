package com.PetCare360.demo.dtos;

import com.PetCare360.demo.models.Owner;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetDTO {
    private String id;
    private String name;
    private String breed;
    private int age;
}
