package com.multibite.service;

import com.multibite.exception.CustomerException;
import com.multibite.exception.FoodCartException;
import com.multibite.exception.ItemException;
import com.multibite.exception.LoginException;
import com.multibite.model.CustomerDTO;
import com.multibite.model.FoodCart;
import com.multibite.model.ItemDTO;

public interface FoodCartService {
	
	public FoodCart addItemToCart(String key, Integer customerId, Integer itemId) throws ItemException, CustomerException, LoginException;
	
	public FoodCart increaseItemQuantity(String key, Integer cartId, Integer quantity, Integer itemId) throws FoodCartException, ItemException, LoginException;

	public FoodCart decreaseItemQuantity(String key, Integer cartId, Integer quantity, Integer itemId) throws FoodCartException, ItemException, LoginException;
	
	public FoodCart removeItem(String key, Integer cartId, Integer itemId) throws FoodCartException, ItemException, LoginException;
	
	public FoodCart removeCart(String key, Integer cartId) throws FoodCartException, LoginException;
}
