package com.multibite.service;

import com.multibite.exception.BillException;
import com.multibite.exception.CustomerException;
import com.multibite.exception.ItemException;
import com.multibite.exception.LoginException;
import com.multibite.exception.OrderDetailsException;
import com.multibite.model.Bill;

public interface BillService {

	public Bill generateBill(String key, Integer customerId, Integer orderDetailId)
			throws BillException, CustomerException, OrderDetailsException, LoginException;

	public Bill updateBill(String key, Bill bill) throws BillException, LoginException;

	public Bill removeBill(String key, Integer billId) throws BillException, LoginException;

	public Bill viewBill(String key, Integer billId) throws BillException, LoginException;

}
