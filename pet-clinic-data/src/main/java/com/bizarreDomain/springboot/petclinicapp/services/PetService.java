package com.bizarreDomain.springboot.petclinicapp.services;


import com.bizarreDomain.springboot.petclinicapp.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();


}
