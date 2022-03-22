package com.bizarreDomain.springboot.petclinicapp.services;

import com.bizarreDomain.springboot.petclinicapp.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
