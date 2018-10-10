package com.bluespace.tech.hrms.repositories.general;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bluespace.tech.hrms.domain.general.Address;

public interface AddressRepository extends MongoRepository<Address, String> {

}
