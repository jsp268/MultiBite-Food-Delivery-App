package com.multibite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multibite.model.FoodCart;

@Repository
public interface FoodCartRepo extends JpaRepository<FoodCart, Integer>{

}
