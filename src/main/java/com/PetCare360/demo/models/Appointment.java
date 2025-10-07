package com.PetCare360.demo.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import com.PetCare360.demo.enums.Status;

@Document(collection = "appointments")
@Data
@NoArgsConstructor
public class Appointment {
    @Id
    private String id;

    private LocalDateTime dateTime;

    @DocumentReference(lazy = true)
    @JsonIgnoreProperties({"owner", "appointments"})
    private Pet pet;

    @DocumentReference(lazy = true)
    @JsonIgnoreProperties("appointments")
    private Veterinarian vet;

    private Status status;
    private String reason;

    public Appointment(LocalDateTime dateTime, Pet pet, Veterinarian vet, String reason) {
        this.dateTime = dateTime;
        this.pet = pet;
        this.vet = vet;
        this.status = Status.PENDIENTE;
        this.reason=reason;
    }
}