package com.multibite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multibite.exception.ItemException;
import com.multibite.model.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer>{
	
	public Item findByItemName(String item) throws ItemException;
	
	
}
