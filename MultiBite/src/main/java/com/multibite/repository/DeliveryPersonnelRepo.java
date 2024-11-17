package com.multibite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multibite.model.DeliveryPersonnel;

@Repository
public interface DeliveryPersonnelRepo extends JpaRepository<DeliveryPersonnel, Integer>{
	
	public DeliveryPersonnel findByEmail(String email);

}
