package com.multibite.service;

import java.util.List;

import com.multibite.exception.CategoryException;
import com.multibite.exception.ItemException;
import com.multibite.exception.LoginException;
import com.multibite.model.CategoryDTO;
import com.multibite.model.Item;
import com.multibite.model.ItemDTO;

public interface ItemService {

	public Item addItem(String key, Item item) throws ItemException, CategoryException, LoginException;

	public Item updateItem(String key, ItemDTO itemDTO) throws ItemException, CategoryException, LoginException;

	public Item removeItem(String key, ItemDTO itemDTO) throws ItemException, LoginException;

	public Item removeItemById(String key, Integer itemId) throws ItemException, LoginException;

	public List<Item> getAllItem(String key) throws ItemException, LoginException;

	public List<Item> getAllItemByCategory(String key, CategoryDTO categoryDTO)
			throws ItemException, CategoryException, LoginException;

	public List<Item> getAllItemByCategoryName(String key, String categoryName)
			throws ItemException, CategoryException, LoginException;

}
