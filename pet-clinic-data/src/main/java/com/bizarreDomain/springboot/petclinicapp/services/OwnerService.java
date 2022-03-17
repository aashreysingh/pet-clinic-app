package com.bizarreDomain.springboot.petclinicapp.services;

import com.bizarreDomain.springboot.petclinicapp.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();

}
