package com.spring.petclinicapp.repositories;

import com.spring.petclinicapp.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet,Long> {
}
