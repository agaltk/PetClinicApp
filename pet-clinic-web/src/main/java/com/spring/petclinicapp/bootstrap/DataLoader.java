package com.spring.petclinicapp.bootstrap;

import com.spring.petclinicapp.model.Owner;
import com.spring.petclinicapp.model.PetType;
import com.spring.petclinicapp.model.Vet;
import com.spring.petclinicapp.services.OwnerService;
import com.spring.petclinicapp.services.PetTypeService;
import com.spring.petclinicapp.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;



    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Lisa");
        owner1.setLastName("Smith");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("John");
        owner2.setLastName("Snow");

        ownerService.save(owner2);

        System.out.println("Owners loaded...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Kim");
        vet1.setLastName("Picard");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Mary");
        vet2.setLastName("Jane");

        vetService.save(vet2);

        System.out.println("Vets loaded...");

    }
}
