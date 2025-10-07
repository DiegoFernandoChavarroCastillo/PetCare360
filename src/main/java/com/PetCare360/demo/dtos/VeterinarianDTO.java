package com.PetCare360.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeterinarianDTO {
    private String id;
    private String name;
    private String specialty;
}