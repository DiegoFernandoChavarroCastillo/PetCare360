package com.PetCare360.demo.repositories;

import com.PetCare360.demo.models.Pet;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface PetRepository extends MongoRepository<Pet, String> {


    List<Pet> findByBreed(String breed);

    List<Pet> findByNameContainingIgnoreCase(String name);

    List<Pet> findByAge(int age);

    List<Pet> findByAgeBetween(int minAge, int maxAge);
}