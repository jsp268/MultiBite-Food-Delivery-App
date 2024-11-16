package com.multibite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multibite.exception.AddressException;
import com.multibite.model.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer>{

	public Address findByCity(String city) throws AddressException;
	
}
