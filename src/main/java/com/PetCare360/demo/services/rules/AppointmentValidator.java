package com.PetCare360.demo.services.rules;

import com.PetCare360.demo.models.Appointment;
import com.PetCare360.demo.models.Pet;
import com.PetCare360.demo.models.Veterinarian;
import com.PetCare360.demo.models.Veterinarian;
import com.PetCare360.demo.repositories.AppointmentRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AppointmentValidator {

    private final AppointmentRepository appointmentRepository;

    public AppointmentValidator(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }


    public void validateAppointment(Appointment appointment) {
        validateNotNullEntities(appointment.getPet(), appointment.getVet());
        validateDateTime(appointment.getDateTime());
        validateVetAvailability(appointment.getVet().getId(), appointment.getDateTime());
        validatePetAge(appointment.getPet().getAge());
        validateReason(appointment.getReason());
    }


    private void validateNotNullEntities(Pet pet, Veterinarian vet) {
        if (pet == null) {
            throw new IllegalArgumentException("Debe asociar una mascota a la cita.");
        }
        if (vet == null) {
            throw new IllegalArgumentException("Debe asignar un veterinario a la cita.");
        }
    }


    private void validateDateTime(LocalDateTime dateTime) {
        if (dateTime == null) {
            throw new IllegalArgumentException("Debe especificar la fecha y hora de la cita.");
        }
        if (dateTime.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("La fecha y hora de la cita deben ser en el futuro.");
        }
    }


    private void validateVetAvailability(String vetId, LocalDateTime dateTime) {
        boolean conflict = appointmentRepository.findByVetId(vetId).stream()
                .anyMatch(existing -> existing.getDateTime().equals(dateTime));

        if (conflict) {
            throw new IllegalArgumentException("El veterinario ya tiene una cita programada en esa hora.");
        }
    }

    private void validatePetAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("La edad de la mascota debe ser mayor que 0.");
        }
    }


    private void validateReason(String reason) {
        if (reason == null || reason.trim().isEmpty()) {
            throw new IllegalArgumentException("Debe especificar el motivo de la consulta.");
        }
    }
}
