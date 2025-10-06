package com.PetCare360.demo.repositories;

import com.PetCare360.demo.models.Appointment;
import com.PetCare360.demo.enums.Status;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends MongoRepository<Appointment, String> {

    List<Appointment> findByVetId(String vetId);

    List<Appointment> findByPetId(String petId);

    List<Appointment> findByStatus(Status status);

    List<Appointment> findByDateTime(LocalDateTime dateTime);
}
