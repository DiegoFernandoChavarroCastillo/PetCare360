package com.PetCare360.demo.dtos;

import com.PetCare360.demo.enums.Status;
import com.PetCare360.demo.models.Pet;
import com.PetCare360.demo.models.Veterinarian;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {
    private String id;
    private LocalDateTime dateTime;
    private Pet pet;
    private Veterinarian vet;
    private Status status;
    private String reason;

}
