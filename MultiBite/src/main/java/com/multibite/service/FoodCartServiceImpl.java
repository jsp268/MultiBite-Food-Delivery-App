package com.multibite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multibite.exception.CustomerException;
import com.multibite.exception.FoodCartException;
import com.multibite.exception.ItemException;
import com.multibite.exception.LoginException;
import com.multibite.model.CurrentUserSession;
import com.multibite.model.Customer;
import com.multibite.model.CustomerDTO;
import com.multibite.model.FoodCart;
import com.multibite.model.Item;
import com.multibite.model.ItemDTO;
import com.multibite.repository.CurrentUserSessionRepo;
import com.multibite.repository.CustomerRepo;
import com.multibite.repository.FoodCartRepo;
import com.multibite.repository.ItemRepo;

@Service
public class FoodCartServiceImpl implements FoodCartService {

	@Autowired
	private FoodCartRepo foodcartRepo;

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private ItemRepo itemRepo;

	@Autowired
	private CurrentUserSessionRepo currSession;

	@Override
	public FoodCart addItemToCart(String key, Integer customerId, Integer itemId) throws ItemException, CustomerException, LoginException {
		
		CurrentUserSession currSess = currSession.findByPrivateKey(key);
		if (currSess == null)
			throw new LoginException("Login required");
		
		Optional<Customer> opt = customerRepo.findById(customerId);
		if (opt.isEmpty())
			throw new CustomerException("Customer not found!");
		
		Optional<Item> itemOpt = itemRepo.findById(itemId);
		if (itemOpt.isEmpty())
			throw new ItemException("Item not found!");
		
		
		Customer customer = opt.get();
		FoodCart foodCart = customer.getCart();
		List<Item> itemList=foodCart.getItemList();
		boolean flag=true;
		for(int i=0;i<itemList.size();i++)
		{
			Item element=itemList.get(i);
			if(element.getItemId()==itemId)
			{
				element.setQuantity(element.getQuantity()+1);
				flag=false;
			}
		}
		if(flag)
		{
			foodCart.getItemList().add(itemOpt.get());
		}
		
		foodcartRepo.save(foodCart);		
		return foodCart;
		
	}

	@Override
	public FoodCart increaseItemQuantity(String key, Integer cartId, Integer quantity, Integer itemId)
			throws FoodCartException, ItemException, LoginException {
		// TODO Auto-generated method stub
		
		CurrentUserSession currSess = currSession.findByPrivateKey(key);
		if (currSess == null)
			throw new LoginException("Login required");

		Optional<FoodCart> opt = foodcartRepo.findById(cartId);

		if (opt.isPresent()) {
			FoodCart foodCart = opt.get();

			List<Item> itemList = foodCart.getItemList();

			boolean flag = true;

			for (int i = 0; i < itemList.size(); i++) {
				Item ele = itemList.get(i);
				if (ele.getItemId() == itemId) {
					ele.setQuantity(ele.getQuantity() + quantity);
					flag = false;
				}
			}
			if (flag)
				throw new ItemException("Item not found!");
			else {

				foodCart.setItemList(itemList);
				foodcartRepo.save(foodCart);
				return foodCart;
			}
		} else {
			throw new FoodCartException("Food Cart not found!");
		}

	}

	@Override
	public FoodCart decreaseItemQuantity(String key, Integer cartId, Integer quantity, Integer itemId)
			throws FoodCartException, ItemException, LoginException {
		// TODO Auto-generated method stub
		
		CurrentUserSession currSess = currSession.findByPrivateKey(key);
		if (currSess == null)
			throw new LoginException("Login required");

		Optional<FoodCart> opt = foodcartRepo.findById(cartId);

		if (opt.isPresent()) {
			FoodCart foodCart = opt.get();

			List<Item> itemList = foodCart.getItemList();

			boolean flag = true;

			for (int i = 0; i < itemList.size(); i++) {
				Item ele = itemList.get(i);
				if (ele.getItemId() == itemId) {

					if (ele.getQuantity() >= quantity) {
						ele.setQuantity(ele.getQuantity() - quantity);
						flag = false;
					} else {
						throw new ItemException("Insufficient quantity!");
					}
				}
			}
			if (flag)
				throw new ItemException("Item not found!");
			else {

				foodCart.setItemList(itemList);
				foodcartRepo.save(foodCart);
				return foodCart;
			}
		} else {
			throw new FoodCartException("Food Cart not found!");
		}

	}

	@Override
	public FoodCart removeItem(String key, Integer cartId, Integer itemId) throws FoodCartException, ItemException, LoginException {
		// TODO Auto-generated method stub
		
		CurrentUserSession currSess = currSession.findByPrivateKey(key);
		if (currSess == null)
			throw new LoginException("Login required");

		Optional<FoodCart> opt = foodcartRepo.findById(cartId);

		if (opt.isPresent()) {
			FoodCart foodCart = opt.get();

			List<Item> itemList = foodCart.getItemList();

			boolean flag = true;
			Item getItem = null;

			for (int i = 0; i < itemList.size(); i++) {
				Item ele = itemList.get(i);
				if (ele.getItemId() == itemId) {
					flag = false;
					getItem = ele;
				}
			}
			if (flag)
				throw new ItemException("Item not found!");
			else {
				itemList.remove(getItem);
				foodCart.setItemList(itemList);
				foodcartRepo.save(foodCart);
				return foodCart;
			}
		} else {
			throw new FoodCartException("Food Cart not found!");
		}
	}

	@Override
	public FoodCart removeCart(String key, Integer cartId) throws FoodCartException, LoginException {
		// TODO Auto-generated method stub
		
		CurrentUserSession currSess = currSession.findByPrivateKey(key);
		if (currSess == null)
			throw new LoginException("Login required");

		Optional<FoodCart> opt = foodcartRepo.findById(cartId);

		if (opt.isPresent()) {
			FoodCart foodCart = opt.get();
			foodCart.getItemList().clear();
			return foodcartRepo.save(foodCart);
			
		} else {
			throw new FoodCartException("Food Cart not found!");
		}
	}
}
