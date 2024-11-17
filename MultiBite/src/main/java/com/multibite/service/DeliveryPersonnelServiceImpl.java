package com.multibite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multibite.exception.DeliveryPersonnelException;
import com.multibite.exception.LoginException;
import com.multibite.exception.OrderDetailsException;
import com.multibite.model.CurrentUserSession;
import com.multibite.model.DeliveryPersonnel;
import com.multibite.model.FoodCart;
import com.multibite.model.OrderDetails;
import com.multibite.model.UpdateOrderDTO;
import com.multibite.repository.CurrentUserSessionRepo;
import com.multibite.repository.DeliveryPersonnelRepo;
import com.multibite.repository.FoodCartRepo;
import com.multibite.repository.OrderDetailsRepo;

@Service
public class DeliveryPersonnelServiceImpl implements DeliveryPersonnelService {

	@Autowired
	private DeliveryPersonnelRepo deliverypersonnelRepo;

	@Autowired
	private OrderDetailsRepo orderRepo;
	
	@Autowired
	private CurrentUserSessionRepo currSession;

	@Override
	public DeliveryPersonnel addDeliveryPersonnel(DeliveryPersonnel deliverypersonnel) throws DeliveryPersonnelException {

		DeliveryPersonnel existsDeliveryPersonnel = deliverypersonnelRepo.findByEmail(deliverypersonnel.getEmail());

		if (existsDeliveryPersonnel != null) {
			throw new DeliveryPersonnelException("DeliveryPersonnel email alreday exists!");
		} else {

			System.out.println("holaa");
					  	
			return deliverypersonnelRepo.save(deliverypersonnel);
		}

	}

	@Override
	public DeliveryPersonnel updateDeliveryPersonnel(String key, DeliveryPersonnel c) throws DeliveryPersonnelException, LoginException {

		CurrentUserSession currSess = currSession.findByPrivateKey(key);
		if (currSess == null)
			throw new LoginException("Login required");

		if (c == null) {
			throw new DeliveryPersonnelException("Null value is not allowed");
		}

		Optional<DeliveryPersonnel> optional = deliverypersonnelRepo.findById(c.getDeliverypersonnelId());

		if (optional.isEmpty()) {
			throw new DeliveryPersonnelException("No deliverypersonnel exist with given deliverypersonnel id :" + c.getDeliverypersonnelId());
		}
		// this statement will update deliverypersonnel and overrides the old deliverypersonnel data
		return deliverypersonnelRepo.save(c);
	}
	
	@Override
	public	OrderDetails updateDeliveryPersonnelOrder(String key, UpdateOrderDTO updateorderdto) throws LoginException, OrderDetailsException {
		

		CurrentUserSession currSess = currSession.findByPrivateKey(key);
		if (currSess == null)
			throw new LoginException("Login required");
		
		Optional<OrderDetails> opt1 = orderRepo.findById(updateorderdto.getOrderId());
		
		if (opt1.isPresent()) {
			OrderDetails ord = opt1.get();
			ord.setOrderStatus(updateorderdto.getOrderStatus());
			orderRepo.save(ord);
			return ord;
		}else {
			throw new OrderDetailsException("order does not exist...!");
		}
		
		
				
	}

	
	@Override
	public DeliveryPersonnel removeDeliveryPersonnelById(String key, Integer deliverypersonnelId) throws DeliveryPersonnelException, LoginException {

		CurrentUserSession currSess = currSession.findByPrivateKey(key);
		if (currSess == null)
			throw new LoginException("Login required");

		Optional<DeliveryPersonnel> optional = deliverypersonnelRepo.findById(deliverypersonnelId);

		if (optional.isEmpty()) {
			throw new DeliveryPersonnelException("No deliverypersonnel exist with given deliverypersonnel id :" + deliverypersonnelId);
		}

		DeliveryPersonnel deletedDeliveryPersonnel = optional.get();
		deliverypersonnelRepo.delete(deletedDeliveryPersonnel);
		return deletedDeliveryPersonnel;
	}

	@Override
	public DeliveryPersonnel removeDeliveryPersonnel(String key, DeliveryPersonnel c) throws DeliveryPersonnelException, LoginException {

		CurrentUserSession currSess = currSession.findByPrivateKey(key);
		if (currSess == null)
			throw new LoginException("Login required");

		if (c == null) {
			throw new DeliveryPersonnelException("Null value is not allowed");
		}

		Optional<DeliveryPersonnel> optional = deliverypersonnelRepo.findById(c.getDeliverypersonnelId());

		if (optional.isEmpty()) {
			throw new DeliveryPersonnelException("No deliverypersonnel exist with given deliverypersonnel id :" + c.getDeliverypersonnelId());
		}

		DeliveryPersonnel deletedDeliveryPersonnel = optional.get();
		deliverypersonnelRepo.delete(deletedDeliveryPersonnel);
		return deletedDeliveryPersonnel;
	}

	@Override
	public DeliveryPersonnel viewDeliveryPersonnel(String key, Integer cid) throws DeliveryPersonnelException, LoginException {

		CurrentUserSession currSess = currSession.findByPrivateKey(key);
		if (currSess == null)
			throw new LoginException("Login required");

		Optional<DeliveryPersonnel> optional = deliverypersonnelRepo.findById(cid);

		if (optional.isEmpty()) {
			throw new DeliveryPersonnelException("No deliverypersonnel exist with given deliverypersonnel id :" + cid);
		}

		return optional.get();
	}
	
	@Override
	public DeliveryPersonnel toggleAvailabilityStatus(String key, Integer DeliveryPersonnelId) throws DeliveryPersonnelException, LoginException{
		CurrentUserSession currSess = currSession.findByPrivateKey(key);
		if (currSess == null)
			throw new LoginException("Login required");

		Optional<DeliveryPersonnel> optional = deliverypersonnelRepo.findById(DeliveryPersonnelId);

		if (optional.isEmpty()) {
			throw new DeliveryPersonnelException("No deliverypersonnel exist with given deliverypersonnel id :" + DeliveryPersonnelId);
		}
		DeliveryPersonnel returnDP = optional.get();
		Boolean currStatus = returnDP.getAvailable();
		returnDP.setAvailable( !currStatus );
		deliverypersonnelRepo.save(returnDP);
		return returnDP;
	}

	@Override
	public List<DeliveryPersonnel> viewAllDeliveryPersonnels(String key) throws DeliveryPersonnelException, LoginException {

		CurrentUserSession currSess = currSession.findByPrivateKey(key);
		if (currSess == null)
			throw new LoginException("Login required");

		List<DeliveryPersonnel> deliverypersonnels = deliverypersonnelRepo.findAll();

		if (deliverypersonnels.size() == 0) {
			throw new DeliveryPersonnelException("No deliverypersonnels available in list");
		}

		return deliverypersonnels;
	}

}
