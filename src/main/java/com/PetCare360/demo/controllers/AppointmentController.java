package com.PetCare360.demo.controllers;

import com.PetCare360.demo.dtos.AppointmentDTO;
import com.PetCare360.demo.models.Appointment;
import com.PetCare360.demo.services.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    // ✅ 1. Obtener todas las citas
    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    // ✅ 2. Consultar detalles de una cita por id
    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable String id) {
        return appointmentService.getAppointmentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ 3. Crear una nueva cita (POST)
    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody AppointmentDTO dto) {
        Appointment created = appointmentService.createAppointment(dto);
        return ResponseEntity.ok(created);
    }

    // ✅ 4. Cancelar una cita (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable String id) {
        boolean deleted = appointmentService.deleteAppointment(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    // ✅ 5. Listar citas de un veterinario específico
    @GetMapping("/veterinarios/{id}")
    public List<Appointment> getAppointmentsByVetId(@PathVariable String id) {
        return appointmentService.getAppointmentsByVetId(id);
    }

    // ✅ 6. Listar citas de una mascota específica
    @GetMapping("/mascotas/{id}")
    public List<Appointment> getAppointmentsByPetId(@PathVariable String id) {
        return appointmentService.getAppointmentsByPetId(id);
    }
}
