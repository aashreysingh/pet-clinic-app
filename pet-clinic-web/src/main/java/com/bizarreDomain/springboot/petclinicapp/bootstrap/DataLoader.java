package com.bizarreDomain.springboot.petclinicapp.bootstrap;

import com.bizarreDomain.springboot.petclinicapp.model.Owner;
import com.bizarreDomain.springboot.petclinicapp.model.Vet;
import com.bizarreDomain.springboot.petclinicapp.services.OwnerService;
import com.bizarreDomain.springboot.petclinicapp.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

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
