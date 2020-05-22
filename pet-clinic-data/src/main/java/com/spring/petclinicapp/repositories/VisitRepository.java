package com.spring.petclinicapp.repositories;

import com.spring.petclinicapp.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
