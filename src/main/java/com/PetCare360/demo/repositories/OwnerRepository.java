package com.PetCare360.demo.repositories;

import com.PetCare360.demo.models.Owner;
import com.PetCare360.demo.models.Pet;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OwnerRepository extends MongoRepository<Owner, String> {

}