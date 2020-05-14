package com.spring.petclinicapp.services;

import com.spring.petclinicapp.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);
    Pet save(Pet owner);
    Set<Pet> findAll();
}