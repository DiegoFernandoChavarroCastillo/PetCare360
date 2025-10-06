package com.PetCare360.demo.models;

import java.time.LocalDateTime;

import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.PetCare360.demo.enums.Status;

@Document(collection = "appointments")
public class Appointment {
    @Id
    private String id;

    private LocalDateTime dateTime;
    private Pet pet;
    private Veterinarian vet;
    @Setter
    private Status status;

    public Appointment(LocalDateTime dateTime, Pet pet, Veterinarian vet) {
        this.dateTime = dateTime;
        this.pet = pet;
        this.vet = vet;
        this.status = Status.PENDIENTE;
    }
}
