package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.entity.Pet;
import com.udacity.jdnd.course3.critter.repository.CustomerRepository;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PetService {

    private PetRepository petRepository;
    private CustomerRepository customerRepository;

    public PetService(PetRepository petRepository, CustomerRepository customerRepository) {
        this.petRepository = petRepository;
        this.customerRepository = customerRepository;
    }

    public Pet findById(Long petId) throws NoSuchElementException {
        Optional<Pet> pet = petRepository.findById(petId);
        return pet.get();
    }

    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }


    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    public List<Pet> findPetsByOwnerId(long ownerId) {
        return petRepository.findAllByOwnerId(ownerId);
    }
}

