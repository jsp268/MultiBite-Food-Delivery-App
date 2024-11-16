package com.multibite.service;

import java.util.List;

import com.multibite.exception.CustomerException;
import com.multibite.exception.LoginException;
import com.multibite.exception.OrderHistoryException;
import com.multibite.model.OrderHistory;

public interface OrderHistoryService {

	public OrderHistory getOrderHistoryById(String key, Integer orderHisId)
			throws OrderHistoryException, LoginException;

	public List<OrderHistory> getOrderHistoryByCustomerId(String key, Integer customerId)
			throws OrderHistoryException, LoginException, CustomerException;

	public List<OrderHistory> getAllOrderHistory(String key) throws OrderHistoryException, LoginException;

}
