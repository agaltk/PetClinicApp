package com.spring.petclinicapp.repositories;

import com.spring.petclinicapp.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
