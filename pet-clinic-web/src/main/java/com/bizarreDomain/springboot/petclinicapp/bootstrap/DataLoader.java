package com.bizarreDomain.springboot.petclinicapp.bootstrap;

import com.bizarreDomain.springboot.petclinicapp.model.Owner;
import com.bizarreDomain.springboot.petclinicapp.model.PetType;
import com.bizarreDomain.springboot.petclinicapp.model.Vet;
import com.bizarreDomain.springboot.petclinicapp.services.OwnerService;
import com.bizarreDomain.springboot.petclinicapp.services.PetTypeService;
import com.bizarreDomain.springboot.petclinicapp.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Adam");
        owner3.setLastName("Levi");

        ownerService.save(owner3);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Lemonna");
        vet2.setLastName("Arguira");

        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("Jessi");
        vet3.setLastName("Porter");

        vetService.save(vet3);

        System.out.println("Loaded Vets...");

    }
}
