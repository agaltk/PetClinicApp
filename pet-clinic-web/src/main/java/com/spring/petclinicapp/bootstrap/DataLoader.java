package com.spring.petclinicapp.bootstrap;

import com.spring.petclinicapp.model.*;
import com.spring.petclinicapp.services.OwnerService;
import com.spring.petclinicapp.services.PetTypeService;
import com.spring.petclinicapp.services.SpecialityService;
import com.spring.petclinicapp.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;




    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if(count ==0) loadData();


    }

    private void loadData(){
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);


        Owner owner1 = new Owner();
        owner1.setFirstName("Lisa");
        owner1.setLastName("Smith");
        owner1.setAddress("long street 123");
        owner1.setCity("London");
        owner1.setTelephone("1233212");

        Pet lisaPet  = new Pet();
        lisaPet.setPetType(savedDogPetType);
        lisaPet.setName("Miki");
        lisaPet.setBirthDate(LocalDate.now());
        lisaPet.setOwner(owner1);

        owner1.getPets().add(lisaPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("John");
        owner2.setLastName("Snow");
        owner2.setAddress("short street 44");
        owner2.setCity("New York");
        owner2.setTelephone("6555");


        Pet johnCat  = new Pet();
        johnCat.setPetType(savedCatPetType);
        johnCat.setName("Sim");
        johnCat.setBirthDate(LocalDate.now());
        johnCat.setOwner(owner2);
        owner2.getPets().add(johnCat);
        ownerService.save(owner2);

        System.out.println("Owners loaded...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Kim");
        vet1.setLastName("Picard");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Mary");
        vet2.setLastName("Jane");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Vets loaded...");
    }
}
