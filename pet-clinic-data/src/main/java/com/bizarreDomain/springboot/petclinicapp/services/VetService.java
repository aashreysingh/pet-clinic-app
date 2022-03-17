package com.bizarreDomain.springboot.petclinicapp.services;

import com.bizarreDomain.springboot.petclinicapp.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();

}
