package com.PetCare360.demo.services;

import com.PetCare360.demo.dtos.PetDTO;
import com.PetCare360.demo.models.Pet;
import com.PetCare360.demo.models.Owner;
import com.PetCare360.demo.repositories.PetRepository;
import com.PetCare360.demo.repositories.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    private final PetRepository petRepository;
    private final OwnerRepository ownerRepository;

    public PetService(PetRepository petRepository, OwnerRepository ownerRepository) {
        this.petRepository = petRepository;
        this.ownerRepository = ownerRepository;
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Optional<Pet> getPetById(String id) {
        return petRepository.findById(id);
    }

    public Pet createPet(PetDTO dto) {

        Pet pet = new Pet();
        pet.setName(dto.getName());
        pet.setBreed(dto.getBreed());
        pet.setAge(dto.getAge());


        return petRepository.save(pet);
    }

    public Optional<Pet> updatePet(String id, PetDTO dto) {
        return petRepository.findById(id)
                .map(existingPet -> {
                    existingPet.setName(dto.getName());
                    existingPet.setBreed(dto.getBreed());
                    existingPet.setAge(dto.getAge());

                    return petRepository.save(existingPet);
                });
    }

    public boolean deletePet(String id) {
        if (petRepository.existsById(id)) {
            petRepository.deleteById(id);
            return true;
        }
        return false;
    }



    public List<Pet> getPetsByBreed(String breed) {
        return petRepository.findByBreed(breed);
    }

    public List<Pet> searchPetsByName(String name) {
        return petRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Pet> getPetsByAge(int age) {
        return petRepository.findByAge(age);
    }

    public List<Pet> getPetsByAgeRange(int minAge, int maxAge) {
        return petRepository.findByAgeBetween(minAge, maxAge);
    }
}