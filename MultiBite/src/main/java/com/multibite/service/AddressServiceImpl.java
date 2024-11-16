package com.multibite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multibite.exception.AddressException;
import com.multibite.exception.RestaurantException;
import com.multibite.model.Address;
import com.multibite.model.Restaurant;
import com.multibite.repository.AddressRepo;

@Service
public class AddressServiceImpl implements AddressService{

	@Override
	public List<Restaurant> getAllRestaurantsByAddressId(Integer addressId) throws AddressException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
