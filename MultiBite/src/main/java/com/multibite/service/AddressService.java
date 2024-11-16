package com.multibite.service;

import java.util.List;

import com.multibite.exception.AddressException;
import com.multibite.model.Restaurant;

public interface AddressService {
	
	public List<Restaurant> getAllRestaurantsByAddressId(Integer addressId) throws AddressException;

}
