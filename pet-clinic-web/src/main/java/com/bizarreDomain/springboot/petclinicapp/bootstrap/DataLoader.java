package com.bizarreDomain.springboot.petclinicapp.bootstrap;

import com.bizarreDomain.springboot.petclinicapp.model.*;
import com.bizarreDomain.springboot.petclinicapp.services.OwnerService;
import com.bizarreDomain.springboot.petclinicapp.services.PetTypeService;
import com.bizarreDomain.springboot.petclinicapp.services.SpecialityService;
import com.bizarreDomain.springboot.petclinicapp.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count==0){
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        radiology.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        radiology.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);


        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("15073 Hannan Trace Rd");
        owner1.setCity("Crown City, Ohio(OH)");
        owner1.setTelephone("(740) 256-9317");

        Pet o1Pet = new Pet();
        o1Pet.setPetType(savedDogPetType);
        o1Pet.setOwner(owner1);
        o1Pet.setName("Tango");
        o1Pet.setBirthDate(LocalDate.now());
        owner1.getPets().add(o1Pet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("4137 A Corbett Cir");
        owner2.setCity("Farmville, North Carolina(NC)");
        owner2.setTelephone("(225) 753-7676");

        Pet o2Pet = new Pet();
        o2Pet.setPetType(savedCatPetType);
        o2Pet.setOwner(owner2);
        o2Pet.setName("Empress");
        o2Pet.setBirthDate(LocalDate.now());
        owner2.getPets().add(o2Pet);

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Adam");
        owner3.setLastName("Levi");
        owner3.setAddress("401 W Pine Ave");
        owner3.setCity("Lompoc, California(CA)");
        owner3.setTelephone("(805) 735-9505");

        Pet o3Pet = new Pet();
        o3Pet.setPetType(savedDogPetType);
        o3Pet.setOwner(owner3);
        o3Pet.setName("Agnes");
        o3Pet.setBirthDate(LocalDate.now());
        owner3.getPets().add(o3Pet);

        ownerService.save(owner3);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Lemonna");
        vet2.setLastName("Arguira");
        vet2.getSpecialities().add(savedDentistry);

        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("Jessi");
        vet3.setLastName("Porter");
        vet3.getSpecialities().add(savedSurgery);

        vetService.save(vet3);

        System.out.println("Loaded Vets...");
    }
}
