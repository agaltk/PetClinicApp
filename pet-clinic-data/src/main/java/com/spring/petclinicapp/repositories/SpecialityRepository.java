package com.spring.petclinicapp.repositories;

import com.spring.petclinicapp.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality,Long> {
}
