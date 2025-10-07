package com.PetCare360.demo.dtos;

import com.PetCare360.demo.models.Pet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerDTO {
    private String id;

    private String name;
    private String phone;
    private String email;
    private List<Pet> pets;
}
