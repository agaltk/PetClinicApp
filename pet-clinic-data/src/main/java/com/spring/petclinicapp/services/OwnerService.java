package com.spring.petclinicapp.services;

import com.spring.petclinicapp.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}
