package com.PetCare360.demo.controllers;

import com.PetCare360.demo.dtos.PetDTO;
import com.PetCare360.demo.models.Pet;
import com.PetCare360.demo.services.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mascotas")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable String id) {
        return petService.getPetById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pet> createPet(@RequestBody PetDTO dto) {
        Pet created = petService.createPet(dto);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable String id, @RequestBody PetDTO dto) {
        return petService.updatePet(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable String id) {
        boolean deleted = petService.deletePet(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }


    @GetMapping("/raza/{breed}")
    public List<Pet> getPetsByBreed(@PathVariable String breed) {
        return petService.getPetsByBreed(breed);
    }

    @GetMapping("/buscar")
    public List<Pet> searchPetsByName(@RequestParam String name) {
        return petService.searchPetsByName(name);
    }

    @GetMapping("/edad/{age}")
    public List<Pet> getPetsByAge(@PathVariable int age) {
        return petService.getPetsByAge(age);
    }

    @GetMapping("/rango-edad")
    public List<Pet> getPetsByAgeRange(@RequestParam int minAge, @RequestParam int maxAge) {
        return petService.getPetsByAgeRange(minAge, maxAge);
    }
}