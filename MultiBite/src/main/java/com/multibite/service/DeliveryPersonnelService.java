package com.multibite.service;

import java.util.List;

import com.multibite.exception.DeliveryPersonnelException;
import com.multibite.exception.LoginException;
import com.multibite.exception.OrderDetailsException;
import com.multibite.model.DeliveryPersonnel;
import com.multibite.model.OrderDetails;
import com.multibite.model.UpdateOrderDTO;

public interface DeliveryPersonnelService {

	DeliveryPersonnel addDeliveryPersonnel(DeliveryPersonnel DeliveryPersonnel) throws DeliveryPersonnelException;

	DeliveryPersonnel updateDeliveryPersonnel(String key, DeliveryPersonnel DeliveryPersonnel) throws DeliveryPersonnelException, LoginException;

	DeliveryPersonnel removeDeliveryPersonnelById(String key, Integer DeliveryPersonnelId) throws DeliveryPersonnelException, LoginException;

	DeliveryPersonnel removeDeliveryPersonnel(String key, DeliveryPersonnel DeliveryPersonnel) throws DeliveryPersonnelException, LoginException;

	DeliveryPersonnel viewDeliveryPersonnel(String key, Integer DeliveryPersonnelId) throws DeliveryPersonnelException, LoginException;

	DeliveryPersonnel toggleAvailabilityStatus(String key, Integer DeliveryPersonnelId) throws DeliveryPersonnelException, LoginException;

	List<DeliveryPersonnel> viewAllDeliveryPersonnels(String key) throws DeliveryPersonnelException, LoginException;

	OrderDetails updateDeliveryPersonnelOrder(String key, UpdateOrderDTO updateorderdto) throws LoginException, OrderDetailsException;

}
