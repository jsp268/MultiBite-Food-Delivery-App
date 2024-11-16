package com.multibite.service;

import java.util.List;

import com.multibite.exception.AddressException;
import com.multibite.exception.ItemException;
import com.multibite.exception.LoginException;
import com.multibite.exception.RestaurantException;
import com.multibite.model.Restaurant;

public interface RestaurantService {

	public Restaurant addRestaurant(String key, Restaurant restaurant) throws RestaurantException, LoginException;

	public Restaurant updateRestaurant(String key, Restaurant restaurant) throws RestaurantException, LoginException;

	public Restaurant removeRestaurant(String key, Integer restaurantId) throws RestaurantException, LoginException;

	public Restaurant viewRestaurantById(String key, Integer restaurantId) throws RestaurantException, LoginException;

	public List<Restaurant> getAllRestaurants(String key) throws RestaurantException, LoginException;

	public List<Restaurant> viewNearByRestaurant(String key, String city)
			throws RestaurantException, AddressException, LoginException;

	public List<Restaurant> viewRestaurantByItemName(String key, String itemName)
			throws RestaurantException, ItemException, LoginException;

}
