package com.PetCare360.demo.services;

import com.PetCare360.demo.dtos.AppointmentDTO;
import com.PetCare360.demo.enums.Status;
import com.PetCare360.demo.models.Appointment;
import com.PetCare360.demo.repositories.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(String id) {
        return appointmentRepository.findById(id);
    }

    public Appointment createAppointment(AppointmentDTO dto) {
        Appointment appointment = new Appointment(dto.getDateTime(), dto.getPet(), dto.getVet());
        appointment.setStatus(Status.PENDIENTE);
        return appointmentRepository.save(appointment);
    }

    public Optional<Appointment> updateAppointmentStatus(String id, Status status) {
        return appointmentRepository.findById(id)
                .map(existing -> {
                    existing.setStatus(status);
                    return appointmentRepository.save(existing);
                });
    }
    public boolean deleteAppointment(String id) {
        if (appointmentRepository.existsById(id)) {
            appointmentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public List<Appointment> getAppointmentsByVetId(String vetId) {
        return appointmentRepository.findByVetId(vetId);
    }

    public List<Appointment> getAppointmentsByPetId(String petId) {
        return appointmentRepository.findByPetId(petId);
    }


}
